// ---------------------------------------------------------------------------
// TypeChecker.java
// Type checker.
// $Id: TypeChecker.java,v 1.29 2024/10/24 15:11:50 schreine Exp $
//
// (c) 2023 https://www.risc.jku.at/research/formal/software/SLANG
// Wolfgang.Schreiner <Wolfgang.Schreiner@risc.jku.at>
// William Steingartner <william.steingartner@tuke.sk>
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
// ----------------------------------------------------------------------------
package slang.types;

import java.io.*;
import java.util.*;

import slang.Main;
import slang.syntax.AST.*;

public class TypeChecker
{
  // raised on type errors
  private static class TypeError extends RuntimeException
  {
    public final static long serialVersionUID = 12072023L;
    public TypeError(String msg) { super(msg); }
  }
  private static void typeError(String msg) 
  { throw new TypeError(msg); }
  private static void typeError(String msg, TypeError e)
  { throw new TypeError(e.getMessage() + "\n" + msg); }
  
  // the generic environment used in the type checker
  public static class Env<T> extends LinkedHashMap<String,T>
  {
    public final static long serialVersionUID = 13072023L;
    public Env() { super(); }
    public Env(Env<T> e) { super(e); }
  }
  
  // --------------------------------------------------------------------------
  // information determined by type checker
  // --------------------------------------------------------------------------
  
  // the name of the language
  private static String languageName = "";
  public String getLanguageName() { return languageName; }
  
  // the header
  private static String header = "";
  public String getHeader() { return header; }
  
  // the code
  private static String code = "";
  public String getCode() { return code; }
  
  // the mapping of domain names to domain definitions
  private final static Env<DomainDef> domains = new Env<DomainDef>();
  public final static Collection<DomainDef> getDomains() { return domains.values(); } 
  private final static Set<String> builtinDomains = new HashSet<String>();
  public final static Set<String> getBuiltinDomains() { return builtinDomains; }
  private final static Set<String> literalDomains = new HashSet<String>();
  public final static Set<String> getLiteralDomains() { return literalDomains; }
  static
  {
    // predefined domains
    builtinDomains.add("ID");
    builtinDomains.add("STR");
    builtinDomains.add("NUM");
    for (String domain : builtinDomains)
      domains.put(domain, new DomainDef(new Id(domain), new ArrayList<DomainCon>()));
  }
  
  // the registered constructors and their types
  public record Constructor(
    String name,
    List<String> adomains, // argument domains
    String rdomain         // result domain
  ) { }
  private static Env<Constructor> constructors = new Env<Constructor>();
  public static Env<Constructor> getConstructors() { return constructors; }
  
  // the kinds of operations and the associated case definitions
  public enum OperationKind { Judgment, Transition, Function }
  public static String okind(OperationKind kind)
  { return switch(kind) { case Judgment -> "judgment"; case Transition -> "transition"; case Function -> "function"; }; }
  public static String ckind(OperationKind kind)
  { return switch(kind) { case Judgment -> "inference"; case Transition -> "step"; case Function -> "equation"; }; }
  
  // the registered operations (may be overloaded on input types)
  public record Operation(
    String name,        
    String domain,
    OperationKind kind, 
    List<String> in,  // input types
    List<String> out, // output types
    Clause clause     // the defining clause
  ) { }
  private static Env<Operation> operations = new Env<Operation>();
  public static Collection<Operation> getOperations() { return operations.values(); }
  private static String opKey(String name, String domain)
  {
    return name + ":" + domain;
  }
  public static Operation getOperation(String name, String domain)
  {
    String key = opKey(name, domain);
    return operations.get(key);  
  }
  public static Operation putOperation(Operation operation)
  {
    String key = opKey(operation.name, operation.domain);
    return operations.put(key, operation);
  }
  
  // the registered print declarations for domains
  private static Env<PrinterDomain> dprinters = new Env<PrinterDomain>();
  public static Env<PrinterDomain> getDomainPrinters() { return dprinters; }
  
  // the registered print strings for constructors
  private static Env<String> cprinters = new Env<String>();
  public static Env<String> getConstructorPrinters() { return cprinters; }
  
  // the registered parser declarations for domains
  private static Env<ParserDomain> dparsers = new Env<ParserDomain>();
  public static Collection<ParserDomain> getDomainParsers() { return dparsers.values(); }
  
  // the current output stream
  private static PrintWriter out = null;
  
  /****************************************************************************
   * Checks a language specification, aborts on errors.
   * @param language the language specification.
   ***************************************************************************/
  public static void check(Language language)
  {
    out = Main.getOut();
    try
    {
      languageName = language.id().string();
      // 1st pass: collect declarations
      for (Clause clause : language.clauses())
        declare(clause);
      // 2nd pass: check clauses
      for (Clause clause : language.clauses())
        check(clause);
      // finally check that definitions are complete
      postcheck();
    }
    catch (TypeError e)
    {
      out.print("  ");
      out.println(e.getMessage());
      out.println("ERROR: type checking of language specification failed.");
      System.exit(-1);
    }
  }
  
  // check completeness of definitions
  private static void postcheck()
  {
    for (DomainDef def : domains.values())
    {
      String dname = string(def.id());
      if (builtinDomains.contains(dname)) continue;
      PrinterDomain dprinter = dprinters.get(dname);
      if (dprinter == null) 
      {
        out.println("WARNING: no printer declaration for domain " + dname);
      }
      else
      {
        for (DomainCon con : def.cons())
        {
          String cname = string(con.id());
          String cprinter = cprinters.get(cname);
          if (cprinter == null) typeError("missing case " 
              + " for constructor " + cname 
              + " in printer declaration for domain " + dname);
        }
      }
      ParserDomain dparser = dparsers.get(dname);
      if (dparser == null)
        out.println("WARNING: no parser declaration for domain " + dname);
    }
  }
  
  // declare domains, judgments, functions
  private static void declare(Clause clause)
  {
    switch (clause)
    {
    case Clause.Domains domains -> declare(domains);
    case Clause.Judgment judgment -> declare(judgment);
    case Clause.Transition transition -> declare(transition);
    case Clause.Function function -> declare(function);
    default -> { }
    }
  }
  
  // declare domains
  private static void declare(Clause.Domains domains)
  {
    for (DomainDef def : domains.defs())
    {
      String dname = string(def.id());
      DomainDef def0 = TypeChecker.domains.put(dname, def);
      if (def0 != null) typeError("multiple declarations of domain " + dname);
      for (DomainCon con : def.cons())
      {
        String cname = string(con.id());
        DomainDef def1 = TypeChecker.domains.get(cname);
        if (def1 != null) typeError("constructor name " + cname + " is also the name of a domain");
        for (Domain domain : con.domains())
        {
          if (!(domain instanceof Literal)) continue;
          String dname0 = domainName(domain);
          TypeChecker.literalDomains.add(dname0);
          TypeChecker.domains.put(dname0, new DomainDef(new Id(dname0), new ArrayList<DomainCon>()));
        }
        List<String> anames = domainNames(con.domains());
        Constructor constructor =  new Constructor(cname, anames, dname);
        Constructor constructor0 = constructors.put(cname, constructor);
        if (constructor0 != null) typeError("multiple declarations of constructor " + cname);
      }
    }
  }
  
  // declare judgments
  private static void declare(Clause.Judgment judgment)
  {
    Operation operation =
        new Operation(string(judgment.id()), string(judgment.domain()), 
            OperationKind.Judgment, 
            typeNames(judgment.in()), typeNames(judgment.out()), judgment);
    Operation operation0 = putOperation(operation);
    if (operation0 != null) typeError("multiple declarations of operation " +
        name(judgment) + " on domain " + string(judgment.domain()));
  }
  
  // declare transitions
  private static void declare(Clause.Transition transition)
  {
    Operation operation =
        new Operation(string(transition.id()), string(transition.domain()), 
            OperationKind.Transition, 
            typeNames(transition.in()), typeNames(transition.out()), transition);
    Operation operation0 = putOperation(operation);
    if (operation0 != null) typeError("multiple declarations of operation " +
        name(transition) + " on domain " + string(transition.domain()));
  }
  
  // declare functions
  private static void declare(Clause.Function function)
  {
    Operation operation =
        new Operation(string(function.id()), string(function.domain()), 
            OperationKind.Function, 
            typeNames(function.in()), typeNames(function.out()), function);
    Operation operation0 = putOperation(operation);
    if (operation0 != null) typeError("multiple declarations of operation " +
        name(function) + " on domain " + string(function.domain()));
  }
  
  // --------------------------------------------------------------------------
  // check syntactic phrases
  // --------------------------------------------------------------------------
  
  private static void check(Clause clause)
  {
    try
    {
    switch (clause)
    {
    case Clause.Target target -> check(target);
    case Clause.Code code -> check(code);
    case Clause.Domains domains -> check(domains);
    case Clause.Printer printer -> check(printer);
    case Clause.Parser parser -> check(parser);
    case Clause.Judgment judgment -> check(judgment);
    case Clause.Transition transition -> check(transition);
    case Clause.Function function -> check(function);
    }
    }
    catch(TypeError e)
    {
      switch (clause)
      {
      case Clause.Target target -> typeError("Type error in 'target' clause.", e);
      case Clause.Code code -> typeError("Type error in 'code' clause.", e);
      case Clause.Domains domains -> typeError("Type error in 'domains' clause.", e);
      case Clause.Printer printer -> typeError("Type error in 'printer' clause:", e);
      case Clause.Parser parser -> typeError("Type error in 'parser' clause.", e);
      case Clause.Judgment judgment -> typeError("Type error in clause for judgment " 
          + name(judgment) + " on domain " + judgment.domain().string() + ".", e);
      case Clause.Transition transition -> typeError("Type error in clause for transition " 
          + name(transition) + " on domain " + transition.domain().string() + ".", e);
      case Clause.Function function -> typeError("Type error in clause for function " 
          + name(function) + " on domain " + function.domain().string() + ".", e);
      }
      throw e;
    }
  }
  
  private static void check(Clause.Target target)
  {
    // accumulate header
    Optional<Literal> header = target.header();
    if (header.isPresent()) TypeChecker.header += string(header.get());
  }
  
  private static void check(Clause.Code code)
  {
    // accumulate code
    TypeChecker.code += string(code.literal());
  }
  
  private static void check(Clause.Domains domains)
  {
    for (DomainDef def : domains.defs())
    {
      for (DomainCon con : def.cons())
      {
        for (Domain domain : con.domains())
        {
          String dname = domainName(domain);
          DomainDef def0 = TypeChecker.domains.get(dname);
          if (def0 == null) typeError("unknown domain " + dname +
              " in definition of constructor " + string(con.id()) +
              " of domain " + string(def.id()));
        }
      }
    }
  }
  
  private static void check(Clause.Printer printer)
  {
    for (PrinterDomain dprinter : printer.prdomains())
    {
      String dname = string(dprinter.id());
      DomainDef def = domains.get(dname);
      if (def == null) typeError("printer declaration for unknown domain " + dname);
      PrinterDomain dprinter0 = dprinters.put(dname, dprinter);
      if (dprinter0 != null) typeError("multiple printer declarations for domain " + dname);
      for (PrinterCase pcase : dprinter.pcases())
      {
        DomainPattern dpattern = pcase.dpattern();
        String cname = string(dpattern.con());
        Constructor constructor = constructors.get(cname);
        if (constructor == null) typeError("unknown constructor " + cname 
            + " in printer declaration for domain " + dname);
        List<String> params = strings(dpattern.ids());
        int csize = constructor.adomains.size();
        int psize = params.size();
        if (csize != psize) typeError("invalid application of constructor " + cname
            + " with "+ csize + " parameters to " + psize + " arguments" 
            + " in printer declaration for domain " + dname);
        Set<String> pset = new HashSet<String>();
        if (dpattern.id().isPresent()) pset.add(string(dpattern.id().get()));
        for (String param : params)
        {
          boolean isnew = pset.add(param);
          if (!isnew) typeError("multiple declarations of variable " + param
              + " in constructor " + cname 
              + " in printer declaration for domain " + dname);
        }
        String cprinter = string(pcase.literal());
        String cprinter0 = cprinters.put(cname, cprinter);
        if (cprinter0 != null) typeError("multiple printer declarations for constructor " + cname);
      }
    }
  }
  
  private static void check(Clause.Parser parser)
  {
    for (ParserDomain dparser : parser.padomains())
    {
      String dname = string(dparser.id());
      DomainDef def = domains.get(dname);
      if (def == null) typeError("parser declaration for unknown domain " + dname);
      ParserDomain dparser0 = dparsers.put(dname, dparser);
      if (dparser0 != null) typeError("multiple parser declarations for domain " + dname);
      for (ParserCase pcase : dparser.pcases())
      {
        DomainExp dexp = pcase.dexp();
        check(dexp);
      }
    }
  }
  
  private static void check(DomainExp dexp)
  {
    switch (dexp)
    {
    case Literal literal -> { }
    case DomainExp.Application app -> 
    {
      String cname = string(app.id());
      List<Id> ids = app.ids();
      Constructor constructor = constructors.get(cname);
      int dsize = ids.size();
      if (constructor == null) 
      {
        // may be reference to variable declared in parser literal
        if (dsize != 0)
        {
          typeError("in parser declaration, application of unknown constructor "
              + cname);
        }
      }
      else
      {
        int csize = constructor.adomains().size();
        if (csize != dsize) typeError("in parser declaration, constructor " + cname
            + " with " + csize + " parameters cannot be applied to " + dsize + " arguments ");
      }
    }
    }
  }
  
  private static void check(Clause.Judgment judgment)
  {
    String name = string(judgment.id());
    String domain = string(judgment.domain());
    Operation operation = getOperation(name, domain);
    Set<String> cnames = new HashSet<String>();
    int i = 1;
    for (Inference inference : judgment.inferences())
    {
      try
      {
      String cname = check(inference, operation);
      boolean isnew = cnames.add(cname);
      if (!isnew) typeError("multiple inferences for constructor " + cname +
          " of domain " + domain + " in judgment " + name);
      }
      catch(TypeError e)
      {
        typeError("Type error in inference " + i + ".", e);
      }
      i++;
    }
    DomainDef def = domains.get(domain);
    for (DomainCon con : def.cons())
    {
      String cname = string(con.id());
      if (!cnames.contains(cname)) typeError("no inference for constructor " + cname +
          " of domain " + domain + " in judgment " + name);
    }
    check(judgment.before(), true, operation);
    check(judgment.after(), false, operation);
  }
  
  
  private static void check(Clause.Transition transition)
  {
    String name = string(transition.id());
    String domain = string(transition.domain());
    Operation operation = getOperation(name, domain);
    Set<String> cnames = new HashSet<String>();
    int i = 1;
    for (Step step : transition.steps())
    {
      try
      {
      String cname = check(step, operation);
      boolean isnew = cnames.add(cname);
      if (!isnew) typeError("multiple steps for constructor " + cname +
          " of domain " + domain + " in transition " + name);
      }
      catch(TypeError e)
      {
        typeError("Type error in step " + i + ".", e);
      }
      i++;
    }
    DomainDef def = domains.get(domain);
    for (DomainCon con : def.cons())
    {
      String cname = string(con.id());
      if (!cnames.contains(cname)) typeError("no step for constructor " + cname +
          " of domain " + domain + " in transition " + name);
    }
    check(transition.before(), true, operation);
    check(transition.after(), false, operation);
  }
  
  private static void check(Clause.Function function)
  {
    String name = string(function.id());
    String domain = string(function.domain());
    Operation operation = getOperation(name, domain);
    Set<String> cnames = new HashSet<String>();
    int i = 1;
    for (Equation equation : function.equations())
    {
      try
      {
      String cname = check(equation, operation);
      boolean isnew = cnames.add(cname);
      if (!isnew) typeError("multiple equations for constructor " + cname +
          " of domain " + domain + " in function " + name);
      }
      catch(TypeError e)
      {
        typeError("Type error in equation " + i + ".", e);
      }
      i++;
    }
    DomainDef def = domains.get(domain);
    for (DomainCon con : def.cons())
    {
      String cname = string(con.id());
      if (!cnames.contains(cname)) typeError("no equation for constructor " + cname +
          " of domain " + domain + " in function " + name);    
    }
    check(function.before(), true, operation);
    check(function.after(), false, operation);
  }
  
  private static void check(Optional<Effect> effect0, boolean before, Operation operation)
  {
    if (effect0.isEmpty()) return;
    String kind = before ? "before" : "after";
    Effect effect = effect0.get();
    String name = string(effect.id());
    if (!name.equals(operation.name))
      typeError("invalid name " + name + 
          " in '" + kind + "' clause of " + okind(operation.kind) + " " + name(operation) +
          " on domain " + operation.domain);
    List<Id> in = effect.in();
    int insize = in.size();
    int insize0 = operation.in.size();
    if (insize != insize0)
      typeError("in its " + kind + " clause, the " + okind(operation.kind) + " " + name +
          " on domain " + operation.domain +
          " with " + insize0 + " input parameters cannot be applied to " + insize + " arguments");
    List<Id> out = effect.out();
    if (!before)
    {
      int outsize = out.size();
      int outsize0 = operation.out.size();
      if (outsize != outsize0)
        typeError("in its " + kind + " clause, the " + okind(operation.kind) + " " + name +
            " on domain " + operation.domain +
            " with " + outsize0 + " output parameters cannot yield " + outsize + " results");
    }
    String phrase = string(effect.phrase());
    List<String> ids = new ArrayList<String>();
    ids.add(phrase);
    ids.addAll(strings(in));
    ids.addAll(strings(out));
    Set<String> ids0 = new HashSet<String>();
    for (String id : ids)
    {
      boolean isnew = ids0.add(id);
      if (!isnew)
        typeError("multiple declarations of variable " + id +
            " in '" + kind + "' clause of " + okind(operation.kind) + " " + name(operation) +
            " on domain " + operation.domain);   
    }
  }

  private static String check(Inference inference, Operation operation)
  {
    return check(operation, true,
        inference.id(), inference.dpattern(), inference.in(), inference.out(),
        inference.bodies(), inference.before(), inference.after());
  }
  
  private static String check(Step step, Operation operation)
  {
    return check(operation, true,
        step.id(), step.dpattern(), step.in(), step.out(),
        step.bodies(), step.before(), step.after());
  }
  
  private static String check(Equation eq, Operation operation)
  {
    return check(operation, false,
        eq.id(), eq.dpattern(), eq.in(), eq.out(),
        eq.bodies(), eq.before(), eq.after());
  }
  
  private static String check(Operation operation, boolean inference,
      Id oid, DomainPattern dpattern, List<Id> in, List<Id> out,
      List<Body> bodies, Optional<Literal> before, Optional<Literal> after)
  {
    String name = string(oid);
    if (!name.equals(operation.name))
      typeError("invalid name " + name + " in " + ckind(operation.kind) +
          " for " + okind(operation.kind) + " " + name(operation) +
          " for domain " + operation.domain);
    String cname = string(dpattern.con());
    Constructor constructor = constructors.get(cname);
    if (constructor == null) 
      typeError("unknown constructor " + cname + " in " + ckind(operation.kind) +
      " for " + okind(operation.kind) + " " + name(operation) +
      " for domain " + operation.domain);
    int dsize = dpattern.ids().size();
    int dsize0 = constructor.adomains().size();
    if (dsize != dsize0)
      typeError("the constructor " + cname + " of domain " + operation.domain +
          " with " + dsize0 + " parameters cannot be applied to " + dsize + " arguments" +
          " in " + ckind(operation.kind) +
          " for " + okind(operation.kind) + " " + name(operation));
    int insize = in.size();
    int insize0 = operation.in.size();
    if (insize != insize0)
      typeError("the " + ckind(operation.kind) + " " + name +
          " for the case " + cname + " of domain " + operation.domain +
          " with " + insize0 + " input parameters cannot be applied to " + insize + " arguments" +
          " in " + ckind(operation.kind) + " for " + okind(operation.kind) + " " + name(operation));
    int outsize = out.size();
    int outsize0 = operation.out.size();
    if (outsize != outsize0)
      typeError("the " + ckind(operation.kind) + " " + name +
          " for the case " + cname + " of domain " + operation.domain +
          " with " + outsize0 + " output parameters cannot yield " + outsize + " results");
    List<String> ids = new ArrayList<String>();
    if (dpattern.id().isPresent()) ids.add(string(dpattern.id().get()));
    ids.addAll(strings(dpattern.ids()));
    ids.addAll(strings(in));
    ids.addAll(strings(out));
    Set<String> ids0 = new HashSet<String>();
    for (String id : ids)
    {
      boolean isnew = ids0.add(id);
      if (!isnew)
        typeError("multiple declarations of variable " + id +
            " in " + ckind(operation.kind) + 
            " for " + okind(operation.kind) + " " + name(operation) + 
            " for constructor " + cname + " of domain " + operation.domain);   
    }
    Env<String> env = new Env<String>();
    if (dpattern.id().isPresent())
      declare(dpattern.id().get(), constructor.rdomain, env);
    declare(dpattern.ids(), constructor.adomains, env);
    declare(in, operation.in(), env);
    declare(out, operation.out(), env);
    for (Body body: bodies)
    {
      Env<String> env0 = new Env<String>(env);
      for (Command command : body.commands())
        check(command, env0);
    }
    return cname;
  }

  private static void check(Command command, Env<String> env)
  {
    switch (command)
    {
    case Literal literal -> { }
    case Command.Inference inference -> check(inference, env);
    case Command.Step step -> check(step, env);
    case Command.Assignment assignment -> check(assignment, env);
    }
  }

  private static void check(Command.Inference inference, Env<String> env)
  {
    Operation operation = getOperation(inference.id(), inference.domain(), env);
    checkIn(operation, inference.in(), env);
    declareOut(operation, inference.out(), env);
  }

  private static void check(Command.Step step, Env<String> env)
  {
    Operation operation = getOperation(step.id(), step.domain(), env);
    checkIn(operation, step.in(), env);
    declareOut(operation, step.out(), env);
  }
  
  private static void check(Command.Assignment assignment, Env<String> env)
  {
    Optional<Value> value = assignment.value();
    List<String> tnames = value.isEmpty() ? null : check(value.get(), env);
    if (tnames != null)
    {
      int tsize = tnames.size();
      int vsize = assignment.variables().size();
      if (tsize != vsize)
        typeError("assignment to " + vsize + " variables " + assignment.variables() +
            "from expression with " + tsize + " values");
    }
    int i = 0;
    for (Variable variable : assignment.variables())
    {
      Id id = variable.id();
      Optional<Type> type0 = variable.type();
      if (type0.isPresent())
      {
        Type type = type0.get();
        String tname = typeName(type);
        declare(id, tname, env);
      }
      if (tnames != null)
      {
        String tname = tnames.get(i);
        checkedDeclare(id, tname, env);
      }
      i++;
    }
  }
  
  private static List<String> check(Value value, Env<String> env)
  {
    List<String> result = new ArrayList<String>();
    switch (value)
    {
    case Literal literal -> result.add("*");
    case Id id -> { String type = getType(id, env); result.add(type); }
    case Value.Application(Id id, Id domain, List<Value> values) ->
    {
      Operation operation = getOperation(id, domain, env);
      List<String> vtypes = new ArrayList<String>();
      for (Value value0 : values)
      {
        List<String> vtypes0 = check(value0, env);
        int size = vtypes0.size();
        if (size != 1)
          typeError("expression " + value0 + 
              " denotes " + size + " values rather than a single one");
        String vtype0 = vtypes0.get(0);
        vtypes.add(vtype0);
      }
      checkIn(operation, vtypes);
      result.addAll(operation.out());
    }
    }
    return result;
  }
  
  // --------------------------------------------------------------------------
  // auxiliaries
  // --------------------------------------------------------------------------
    
  // get name of operation
  private static String opName(String string)
  { if (string.equals("")) return "␣"; else return string; }
  private static String name(Operation operation)
  { return opName(operation.name()); }
  private static String name(Clause.Judgment judgment)
  { return opName(judgment.id().string()); }
  private static String name(Clause.Transition transition)
  { return opName(transition.id().string()); }
  private static String name(Clause.Function function)
  { return opName(function.id().string()); }
  
  // get text of literal
  private static String string(Literal literal)
  {
    return literal.string();
  }
  
  // get name of identifier
  private static String string(Id id)
  {
    return id.string();
  }
  
  // get identifier names
  private static List<String> strings(List<Id> ids)
  {
    List<String> strings = new ArrayList<String>();
    for (Id id : ids) strings.add(string(id));
    return strings;
  }
  
  // get name of domain
  private static String domainName(Domain domain)
  {
    switch (domain)
    {
    case Id id -> { return string(id); }
    case Literal literal -> { return string(literal); }
    }
  }
  
  // get domain names
  private static List<String> domainNames(List<Domain> domains)
  {
    List<String> strings = new ArrayList<String>();
    for (Domain domain : domains) strings.add(domainName(domain));
    return strings;
  }
  
  // get name of type
  private static String typeName(Type type)
  {
    switch (type) { case Literal literal -> { return string(literal); } }
  }
  
  // get names of types
  private static List<String> typeNames(List<Type> types)
  {
    List<String> strings = new ArrayList<String>();
    for (Type type : types) strings.add(typeName(type));
    return strings;
  }
  
  // compare two types for equality
  private static boolean equalTypes(String type1, String type2)
  {
    if (type1.equals("*") || type2.equals("*")) return true;
    return type1.equals(type2);
  }
  
  // declare an identifier with a type in environment
  // as a side effect, annotates the identifier with the type
  private static void declare(Id id, String type, Env<String> env)
  {
    String name = string(id);
    if (type.equals("*"))
      typeError("variable " + name + 
          " cannot be declared without an explicit type annotation");
    String type0 = env.put(name, type);
    if (type0 != null)
      typeError("variable " + name + 
          " to be declared of type " + type +
          " has already been previously declared (of type " + type0 + ")");
    id.setType(type);
    id.setDeclare(true);
  }
  
  // declares multiple identifiers with types in environment
  // as a side effect, annotates the identifiers with the types
  private static void declare(List<Id> ids, List<String> types,
    Env<String> env)
  {
    int i = 0;
    for (Id id : ids)
    {
      String type = types.get(i);
      declare(id, type, env);
      i++;
    }
  }
  
  // declare id in environment from type of assigned value
  private static void checkedDeclare(Id id, String tname, Env<String> env)
  {
    if (!declared(id, env))
    {
      declare(id, tname, env);
      return;
    }
    if (tname.isEmpty()) return;
    String tname0 = getType(id, env);
    if (!equalTypes(tname, tname0))
      typeError("variable " + id.string() + 
          " has been declared with type " + tname0 +
          " but is defined by a value with type " + tname);
  }
  
  // declare variables from the output parameters of operation
  private static void declareOut(Operation operation,
    List<Id> ids, Env<String> env)
  {
    int idsize = ids.size();
    int outsize = operation.out().size();
    if (idsize != outsize)
      typeError("application of operation " + name(operation) +
          " with " + outsize + 
          " output parameters cannot yield " + idsize + " results");
    int i = 0;
    for (Id id : ids)
    {
      String type = operation.out().get(i);
      checkedDeclare(id, type, env);
      i++;
    }
  }
  
  // check types for compatibility with input parameters of operation
  private static void checkIn(Operation operation, List<String> types)
  {
    int insize = types.size();
    int insize0 = operation.in().size();
    if (insize != insize0)
      typeError("operation " + name(operation) +
          " with " + insize0 + 
          " input parameters cannot be applied to " + insize + " arguments");
    
    int i = 0;
    for (String type : types)
    {
      String type0 = operation.in().get(i);
      if (!equalTypes(type, type0))
        typeError("argument " + (i+1) + 
            " of operation " + name(operation) +
            " has type " + type + " but should have type " + type0);
      i++;
    }
  }
  
  // check identifiers for compatibility with the input parameters of operation
  private static void checkIn(Operation operation,
    List<Id> ids, Env<String> env)
  {
    int idsize = ids.size();
    int insize = operation.in().size();
    if (idsize != insize)
      typeError("operation " + name(operation) +
          " with " + insize + 
          " input parameters cannot be applied to " + idsize + " arguments");
    int i = 0;
    for (Id id : ids)
    {
      String idtype = getType(id, env);
      String intype = operation.in().get(i);
      if (!equalTypes(idtype, intype))
        typeError("variable " + id.string() + 
            " passed as argument " + (i+1) + 
            " to operation " + name(operation)  +
            " has type " + idtype + " but should have type " + intype);
      i++;
    }
  }
  
  // get operation for name and domain
  public static Operation getOperation(Id id, Id domain, Env<String> env)
  {
    String name = string(id);
    String dname = getType(domain, env);
    Operation operation = getOperation(name, dname); 
    if (operation == null)
      typeError("undeclared operation " + name + " on domain " + domain);
    return operation;
  }
  
  // return true if identifier is declared in environment
  private static boolean declared(Id id, Env<String> env)
  {
    String name = string(id);
    return env.get(name) != null;
  }
  
  // gets the type of an identifier in an environment
  // raises a type error, if the identifier has not been declared
  private static String getType(Id id, Env<String> env) 
  { 
    String name = string(id);
    String type = env.get(name);
    if (type == null) typeError("undeclared variable " + name);
    id.setType(type);
    return type;
  }
}
// ----------------------------------------------------------------------------
// end of file
// ----------------------------------------------------------------------------