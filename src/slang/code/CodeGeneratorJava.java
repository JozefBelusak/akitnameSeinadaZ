// ---------------------------------------------------------------------------
// CodeGenerator.java
// Generation of executable code from language definitions.
// $Id: CodeGeneratorJava.java,v 1.29 2024/12/12 17:12:19 schreine Exp $
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
package slang.code;

import java.util.*;
import java.io.*;

import slang.*;
import slang.syntax.AST.*;
import slang.types.*;

public class CodeGeneratorJava
{
  // the current streams for error messages and generated code
  private static PrintWriter err = null;
  private static PrintWriter out = null;
  
  // the language for which to generate code and its name
  private static Language language = null;
  private static String languageName = null;
  
  // the directory for the generated output files and its path
  private static File directory = null;
  private static String dirPath = null;
  
  public static void generate(Language language, File directory)
  {
    CodeGeneratorJava.language = language;
    CodeGeneratorJava.directory = directory;
    languageName = language.id().string();
    err = Main.getOut();
    try
    {
      dirPath = directory.getCanonicalPath();
      err.println("Generating files in directory " + dirPath + ".");
      if (!directory.exists())
        Main.exit("directory " + dirPath + " does not exist");
      if (!directory.isDirectory())
        Main.exit("path " + dirPath + " does not denote a directory");
      if (!directory.canWrite())
        Main.exit("directory " + dirPath + " is not writable");
      generateCode();
      generateANTLR4();
      generateParser();
      for (DomainDef ddef : TypeChecker.getDomains())
        generateInterface(ddef);
      for (TypeChecker.Operation operation : TypeChecker.getOperations())
        generateClass(operation);
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
  }
  
  /****************************************************************************
   * Generate class for embedded code.
   ***************************************************************************/
  private static void generateCode()
  {
    String fileName = languageName + ".java";
    err.println("Generating code class file " + fileName + ".");
    File file = new File(directory, fileName);
    try
    {
      out = new PrintWriter(new FileWriter(file));
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
    emitHeader();
    emitLine("public final class " + languageName);
    openBlock();
    emitCode();
    closeBlock();
    out.close();
  }
  
  /****************************************************************************
   * Generate interface from a domain definition.
   * @param ddef the domain definition.
   ***************************************************************************/
  private static void generateInterface(DomainDef ddef)
  {
    Id domain = ddef.id();
    String domainName = domain.string();
    if (TypeChecker.getBuiltinDomains().contains(domainName)) return;
    if (TypeChecker.getLiteralDomains().contains(domainName)) return;
    String interfaceName = typeNameJava(domainName);
    String fileName = interfaceName + ".java";
    err.println("Generating for domain " + domainName + " interface file " + fileName + ".");
    File file = new File(directory, fileName);
    try
    {
      out = new PrintWriter(new FileWriter(file));
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
    emitHeader();
    emitLine("public sealed interface " + interfaceName + " permits");
    int n = ddef.cons().size();
    int i = 0;
    for (DomainCon con : ddef.cons())
    {
      String optionName = interfaceName + "." + con.id().string();
      emit(optionName);
      if (i+1 < n) emit(", ");
      i++;
    }
    emitNewLine();
    openBlock();
    TypeChecker.Env<PrinterDomain> printers = TypeChecker.getDomainPrinters();
    PrinterDomain printer = printers.get(domainName);
    for (DomainCon con : ddef.cons())
    {
      String cname = con.id().string();
      indent();
      emit("public record " + cname + "(");
      int n0 = con.domains().size();
      int i0 = 0;
      for (Domain domain0 : con.domains())
      {
        String domainName0 = switch(domain0) { 
        case Id id -> id.string(); 
        case Literal literal -> literal.string(); 
        };
        String interfaceName0 = typeNameJava(domainName0);
        emit(interfaceName0 + " _" + (i0+1));
        if (i0+1 < n0) emit(", ");
        i0++;
      }
      emit(") implements " + interfaceName);
      if (printer == null)
      {
        emit(" { }");
        emitNewLine();
      }
      else
      {
        emitNewLine();
        openBlock();
        emitLine("public String toString()");
        openBlock();
        for (PrinterCase pcase : printer.pcases())
        {
          String cname0 = pcase.dpattern().con().string();
          if (!cname.equals(cname0)) continue;
          int i1 = 0;
          for (Id pid : pcase.dpattern().ids())
          {
            String pname = pid.string();
            emitLine("var " + pname + " = _" + (i1+1) + ";");
            i1++;
          }
          emitLine("String _result;");
          emitLine(pcase.literal().string());
          emitLine("return _result;");
          break;
        }
        closeBlock();
        closeBlock();
      }
    }
    closeBlock();
    out.close();
  }
  
  /****************************************************************************
   * Generate class from an operation.
   * @param operation the operation (judgment, transition, function)
   ***************************************************************************/
  private static void generateClass(TypeChecker.Operation operation)
  {
    initializeOperationContext(operation);
    String domainName = operation.domain();
    String operationName = operation.name();
    String className = operationNameJava(domainName, operationName);
    String fileName = className + ".java";
    String operationText = operationName.equals("") ? 
        "operation ␣" : "operation " + operationName;
    err.println("Generating for " + operationText +
        "[" + domainName + "] class file " + fileName + ".");
    File file = new File(directory, fileName);
    try
    {
      out = new PrintWriter(new FileWriter(file));
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
    emitHeader();
    emitLine("public final class " + className);
    openBlock();
    emitOperation(operation);
    emitBeforeEffect(operation);
    emitAfterEffect(operation);
    emitLine("public static _Operation operation(" + typeNameJava(domainName) + " _phrase)");
    openBlock();
    generate();
    closeBlock();
    closeBlock();
    out.close();
  }
  
  private static void emitOperation(TypeChecker.Operation operation)
  {
    emitLine("public static interface _Operation");
    openBlock();
    String rtype;
    int n = operation.out().size();
    if (n == 0)
      rtype = "void";
    else if (n == 1)
      rtype = operation.out().get(0);
    else
    {
      rtype = "Result";
      indent();
      emit("public record " + rtype + "(");
      int i = 0;
      for (String outtype : operation.out())
      {
        emit(typeNameJava(outtype) + " _" + (i+1));
        if (i+1 < n) emit(", ");
        i++;
      }
      emit(") { }");
      emitNewLine();
    }
    indent();
    emit("public " + rtype + " apply(");
    int i = 0;
    int n0 = operation.in().size();
    for (String intype : operation.in())
    {
      emit(typeNameJava(intype) + " _" + (i+1));
      if (i+1 < n0) emit(", ");
      i++;
    }
    emit(");");
    emitNewLine();
    closeBlock();
  }

  private static void emitBeforeEffect(TypeChecker.Operation operation)
  {
    emitLine("public static interface _BeforeEffect");
    openBlock();
    indent();
    emit("public void apply(");
    int i = 0;
    int n0 = operation.in().size();
    for (String intype : operation.in())
    {
      emit(typeNameJava(intype) + " _" + (i+1));
      if (i+1 < n0) emit(", ");
      i++;
    }
    emit(");");
    emitNewLine();
    closeBlock();
  }
  
  private static void emitAfterEffect(TypeChecker.Operation operation)
  {
    emitLine("public static interface _AfterEffect");
    openBlock();
    indent();
    emit("public void apply(");
    int i = 0;
    int n0 = operation.in().size();
    int n1 = operation.out().size();
    for (String intype : operation.in())
    {
      emit(typeNameJava(intype) + " _" + (i+1));
      if (i+1 < n0+n1) emit(", ");
      i++;
    }
    for (String outtype : operation.out())
    {
      emit(typeNameJava(outtype) + " _" + (i+1));
      if (i+1 < n0+n1) emit(", ");
      i++;
    }
    emit(");");
    emitNewLine();
    closeBlock();
  }
  
  /****************************************************************************
   * Generate the body of the function implementing the current operation.
   ***************************************************************************/
  private static void generate()
  {
    switch (operation.clause())
    {
    case Clause.Judgment judgment -> generate(judgment);
    case Clause.Transition transition -> generate(transition);
    case Clause.Function function -> generate(function);
    default -> { }
    }
  }
  
  // register handled effects
  private final static String BEFORE = "_before";
  private final static String AFTER = "_after";
  private static Set<String> effectVars = null;
  private static void generateEffects(Optional<Effect> before, Optional<Effect> after)
  {
    effectVars = new HashSet<String>();
    if (before.isPresent())
    {
      generateBeforeEffect(before.get());
      effectVars.add(BEFORE);
    }
    if (after.isPresent())
    {
      generateAfterEffect(after.get());
      effectVars.add(AFTER);
    }
  }
  
  private static void generate(Clause.Judgment judgment)
  {
    generateEffects(judgment.before(), judgment.after());
    emitLine("switch (_phrase)");
    openBlock();
    for (Inference inference : judgment.inferences())
    {
      generate(inference.id(), inference.dpattern(), 
          inference.in(), inference.out(), inference.bodies(),
          inference.before(), inference.after());
    }
    closeBlock();
  }
  
  private static void generate(Clause.Transition transition)
  {
    generateEffects(transition.before(), transition.after());
    emitLine("switch (_phrase)");
    openBlock();
    for (Step step : transition.steps())
    {
      generate(step.id(), step.dpattern(), 
          step.in(), step.out(), step.bodies(),
          step.before(), step.after());
    }
    closeBlock();
  }
  
  private static void generate(Clause.Function function)
  {
    generateEffects(function.before(), function.after());
    emitLine("switch (_phrase)");
    openBlock();
    for (Equation equation : function.equations())
    {
      generate(equation.id(), equation.dpattern(), 
          equation.in(), equation.out(), equation.bodies(),
          equation.before(), equation.after());
    }
    closeBlock();
  }
  
  private static void generateBeforeEffect(Effect effect)
  {
    indent();
    emit("var " + BEFORE + " = (_BeforeEffect)(");
    int n0 = effect.in().size();
    int i = 0; 
    for (Id id : effect.in())
    {
      emit("var " + id.string());
      if (i+1 < n0) emit(", ");
      i++;
    }
    emit(") ->");
    emitNewLine();
    openBlock();
    emitLine("var " + effect.phrase().string() + " = _phrase;");
    emit(effect.literal().string());
    emitNewLine();
    closeBlock(";");
  }
  
  private static void generateAfterEffect(Effect effect)
  {
    indent();
    emit("var " + AFTER + " = (_AfterEffect)(");
    int n0 = effect.in().size();
    int n1 = effect.out().size();
    int i = 0; 
    for (Id id : effect.in())
    {
      emit("var " + id.string());
      if (i+1 < n0+n1) emit(", ");
      i++;
    }
    for (Id id : effect.out())
    {
      emit("var " + id.string());
      if (i+1 < n0+n1) emit(", ");
      i++;
    }
    emit(") ->");
    emitNewLine();
    openBlock();
    emitLine("var " + effect.phrase().string() + " = _phrase;");
    emit(effect.literal().string());
    emitNewLine();
    closeBlock(";");
  }
  
  private static void generate(Id id, DomainPattern dpattern,
    List<Id> in, List<Id> out, List<Body> bodies,
    Optional<Literal> before, Optional<Literal> after)
  {
    initializeCaseContext();
    indent();
    emit("case ");
    String cname = dpattern.con().string();
    TypeChecker.Constructor constructor = TypeChecker.getConstructors().get(cname);
    String iname = typeNameJava(constructor.rdomain());
    emit(iname + "." + cname + "(");
    int n = dpattern.ids().size();
    int i = 0;
    for (Id did : dpattern.ids())
    {
      emit("var " + did.string());
      if (i+1 < n) emit(", ");
      i++;
    }
    emit(") ");
    emit("->");
    emitNewLine();
    openBlock();
    if (dpattern.id().isPresent())
    {
      thisPhrase = dpattern.id().get().string();
      emitLine("var " + thisPhrase + " = (" + iname + ")_phrase;");
    }
    PrintWriter out0 = CodeGeneratorJava.out;
    StringWriter swriter = new StringWriter();
    CodeGeneratorJava.out = new PrintWriter(swriter);
    generateRuntimeCode(id, dpattern, in, out, bodies, before, after);
    CodeGeneratorJava.out = out0;
    for (OperationApplication app : operationApplications)
    {
      String className = operationNameJava(app.domain, app.id);
      emitLine("var " + app.variable + " = " + className + ".operation(" + app.phrase + ");");
    }
    indent();
    emit(swriter.toString());
    closeBlock();
  }
  
  private static void generateRuntimeCode(Id id, DomainPattern dpattern,
    List<Id> in, List<Id> out, List<Body> bodies,
    Optional<Literal> before, Optional<Literal> after)
  {
    // TypeChecker.Constructor con = TypeChecker.getConstructors().get(dpattern.con().string());
    boolean novar = thisPhrase == null;
    if (novar)
      emit("return (_Operation)(");
    else
    {
      emit("var _this = new _Operation[1];");
      emitNewLine(); indent();
      emit("_this[0] = (_Operation)(");
    }
    int n0 = in.size();
    int i0 = 0;
    for (Id idin : in)
    {
      emit("var " + idin.string());
      if (i0+1 < n0) emit(", ");
      i0++;
    }
    emit(") -> ");
    emitNewLine();
    openBlock();
    if (effectVars.contains(BEFORE)) generateEffect(BEFORE, in, null);
    if (before.isPresent()) emitLine(before.get().string());
    for (Id idout : out)
      emitLine(idout.type() + " " + idout.string() + ";");
    generate(bodies, 0);
    if (after.isPresent()) emitLine(after.get().string());
    if (effectVars.contains(AFTER)) generateEffect(AFTER, in, out);
    int n1 = out.size();
    if (n1 == 1)
      emitLine("return " + out.get(0) + ";");
    else if (n1 >= 2)
    {
      indent();
      emit("return new _Operation.Result(");
      int i1 = 0;
      for (Id outid : out)
      {
        emit(outid.string());
        if (i1+1 < n1) emit(", ");
        i1++;
      }
      emit(");");
      emitNewLine();
    }
    closeBlock(";");
    if (!novar) emitLine("return _this[0];");
  }
  
  private static void generateEffect(String var, List<Id> in, List<Id> out)
  {
    indent();
    emit(var + ".apply(");
    int n0 = in.size();
    int n1 = out == null ? 0 : out.size();
    int i = 0;
    for (Id id : in)
    {
      emit(id.string());
      if (i+1 < n0+n1) emit(", ");
      i++;
    }
    if (out != null)
    {
      for (Id id : out)
      {
        emit(id.string());
        if (i+1 < n0+n1) emit(", ");
        i++;
      }
    }
    emit(");");
    emitNewLine();
  }
  
  private static void generate(List<Body> bodies, int counter)
  {
    Body body = bodies.get(counter);
    if (counter+1 == bodies.size())
    {
      generate(body);
      return;
    } 
    emitLine("try");
    openBlock();
    generate(body);
    closeBlock();
    String varName = newVariableName();
    emitLine("catch (RuntimeException " + varName + ")");
    openBlock();
    generate(bodies, counter+1);
    closeBlock();
  }
  
  private static void generate(Body body)
  {
    for (Command command : body.commands())
      generate(command);
  }
  
  private static void generate(Command command)
  {
    switch (command)
    {
    case Literal literal -> emitLine(literal.string());
    case Command.Inference inference -> 
      generate(inference.id(), inference.domain(), inference.in(), inference.out());
    case Command.Step step -> 
      generate(step.id(), step.domain(), step.in(), step.out());
    case Command.Assignment assignment -> 
      generate(assignment);
    }
  }
  
  private static void generate(Id id, Id phrase, List<Id> in, List<Id> out)
  {
    String domain = phrase.type();
    String funName = newFunctionName(id.string(), domain, phrase.string());
    int nout = out.size();
    String varName = nout == 0 ? null : nout == 1 ? out.get(0).string() : newVariableName();
    indent();
    String prefix = nout >= 2 || (nout == 1 && out.get(0).declare()) ? "var " : "";
    if (varName != null) emit(prefix + varName + " = ");
    emit(funName + ".apply(");
    int nin = in.size();
    int i = 0;
    for (Id invar : in)
    {
      emit(invar.string());
      if (i+1 < nin) emit(", ");
      i++;
    }
    emit(");");
    emitNewLine();
    if (nout >= 2)
    {
      indent();
      int i0 = 0;
      for (Id outvar : out)
      {
        String prefix0 = outvar.declare() ? outvar.type() + " " : "";
        emitLine(prefix0 + outvar.string() + " = " + varName + "._" + (i0+1) + "();");
        i0++;
      }
    }
  }
  
  private static void generate(Command.Assignment assignment)
  {
    Value value = assignment.value().isEmpty() ? null : assignment.value().get();
    if (value == null)
    {
      for (Variable variable : assignment.variables())
      {
        if (!variable.id().declare()) continue;
        emitLine(variable.id().type() + " " + variable.id().string() + ";");
      }
      return;
    }
    String valueCode = generate(value); 
    int n = assignment.variables().size();
    if (n == 1)
    {
      Variable variable = assignment.variables().get(0);
      String prefix = variable.id().declare() ? variable.id().type() + " " : "";
      emitLine(prefix + variable.id().string() + " = " + valueCode + ";");
      return;
    }
    String opName = "_Operation";
    if (value instanceof Value.Application)
    {
      Value.Application value0 = (Value.Application)value;
      String domain = value0.domain().type();
      String op = value0.id().string();
      opName = operationNameJava(domain, op) + "." + opName;
    }
    String variableName = newVariableName();
    emitLine(opName + ".Result " + variableName + " = " + valueCode + ";");
    int i = 0;
    for (Variable variable : assignment.variables())
    {
      String prefix = variable.id().declare() ? variable.id().type() + " " : "";
      emitLine(prefix + variable.id().string() + " = " + variableName + "._" + (i+1) + "();");
      i++;
    }
  }
  
  private static String generate(Value value)
  {
    switch (value)
    {
    case Id id -> { return id.string(); }
    case Literal literal -> { return literal.string(); }
    case Value.Application(Id id, Id phrase, List<Value> values) ->
    {
      List<String> args = new ArrayList<String>();
      for (Value value0 : values)
      {
        String arg = generate(value0);
        args.add(arg);
      }
      String domain = phrase.type();
      String function = newFunctionName(id.string(), domain, phrase.string());
      StringBuilder builder = new StringBuilder();
      builder.append(function + ".apply(");
      int n = args.size();
      int i = 0;
      for (String arg : args)
      {
        builder.append(arg);
        if (i+1 < n) builder.append(", ");
        i++;
      }
      builder.append(")");
      return builder.toString();
    }
    }
  }

  // --------------------------------------------------------------------------
  // the context of an operation
  // --------------------------------------------------------------------------

  // initialize the context of an operation
  private static TypeChecker.Operation operation = null;
  private static void initializeOperationContext(TypeChecker.Operation operation)
  {
    CodeGeneratorJava.operation = operation;
  }
  
  // the name of this phrase in the current case
  private static String thisPhrase = null;
  
  // get auxiliary variable name that is not in use anywhere else
  private static int variableNumber = 0;
  private static String newVariableName()
  {
    String name = "_" + variableNumber;
    variableNumber++;
    return name;
  }
  
  // a record of applications of operations to syntactic phrases
  private record OperationApplication(
    String variable,  // the variable name assigned to the application
    String id,        // the name of the operation
    String domain,    // the name of the syntactic domain
    String phrase     // the syntactic phrase to which the operation was applied
  ) { }
  
  // a list of generated operation applications
  private static List<OperationApplication> operationApplications = null;
  
  // initialize the context of an operation case
  private static void initializeCaseContext()
  {
    thisPhrase = null;
    variableNumber = 1;
    operationApplications = new ArrayList<OperationApplication>();
  }
  
  // generate and register the function name for an operation application 
  private static String newFunctionName(String id, String domain, String phrase)
  {
    if (thisPhrase != null && phrase.equals(thisPhrase)) return "_this[0]";
    String name = newVariableName();
    operationApplications.add(new OperationApplication(name, id, domain, phrase));
    return name;
  }

  /****************************************************************************
   * Generate ANTLR4 file.
   ***************************************************************************/
  private static void generateANTLR4()
  {
    String fileName = languageName + ".g4";
    err.println("Generating ANTLR4 grammar " + fileName + ".");
    File file = new File(directory, fileName);
    try
    {
      out = new PrintWriter(new FileWriter(file));
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
    emitLine("grammar " + languageName + ";");
    emitLine("options { language = Java; }");
    emitLine("@header");
    openBlock();
    emitHeader();
    closeBlock();
    for (ParserDomain parser : TypeChecker.getDomainParsers())
      emitRule(parser);
    emit("""
      dNUM returns [ String _result ] : n=NUM { $_result = $n.text; } ;
      dID returns [ String _result ] : i=ID { $_result = $i.text; } ;
      dSTR returns [ String _result ] : s=STR { $_result = $s.text; } ;
      NUM : [0-9]+ ;
      ID : [a-zA-Z][a-zA-Z_0-9]* ;
      STR : '"' (ESC|.)*? '"' ;
      fragment ESC : '\\\\"' | '\\\\n' | '\\\\%' | '\\\\\\\\';
      WHITESPACE  : [ \\t\\r\\n\\f]+ -> skip ;
      LINECOMMENT : '//' .*? '\\r'? ('\\n' | EOF) -> skip ;
      COMMENT     : '/*' .*? '*/' -> skip ;
      ERROR : . ;
      """);
    out.close();
  }
  
  private static void emitRule(ParserDomain parser)
  {
    String name = parser.id().string();
    String jname = typeNameJava(name);
    emit("d" + name + " returns [ " + jname + " _result ] ");
    if (parser.literal().isPresent())
    {
      emitNewLine();
      emitLine(parser.literal().get().string());
    }
    emit(":");
    emitNewLine();
    boolean first = true;
    for (ParserCase pcase : parser.pcases())
    {
      if (first) emit("  "); else emit("| "); first = false;
      emit(pcase.literal().string());
      switch (pcase.dexp())
      {
      case Literal literal -> 
      {
        emit("{ " + literal.string() + " }");
      }
      case DomainExp.Application app ->
      {
        emit("{ $_result = new " + jname + "." + app.id().string() + "(");
        int n = app.ids().size();
        int i = 0;
        for (Id id : app.ids())
        {
          emit("$" + id.string() + "._result");
          if (i+1 < n) emit(", ");
          i++;
        }
        emit("); }");
      }
      }
      emitNewLine();
    }
    emitLine(";");
  }
  
  /****************************************************************************
   * Generate class for parser.
   ***************************************************************************/
  private static void generateParser()
  {
    String fileName = languageName + "_parser.java";
    err.println("Generating parser class file " + fileName + ".");
    File file = new File(directory, fileName);
    try
    {
      out = new PrintWriter(new FileWriter(file));
    }
    catch(IOException e)
    {
      Main.exit("output error: " + e.getMessage());
    }
    emitHeader();
    emit("""
      import java.io.*;
      import java.nio.charset.*;
      import java.util.*;
      import org.antlr.v4.runtime.*;
      import org.antlr.v4.runtime.misc.*;
      """);
    emitLine("public final class " + languageName + "_parser");
    openBlock();
    emitErrorListener();
    for (DomainDef ddef : TypeChecker.getDomains())
    {
      String domain = ddef.id().string();
      if (TypeChecker.getBuiltinDomains().contains(domain)) continue;
      if (TypeChecker.getLiteralDomains().contains(domain)) continue;
      emitParser(domain);
    }
    closeBlock();
    out.close();
  }
  
  private static void emitErrorListener()
  {
    emit("""
        private static class ErrorListener extends BaseErrorListener
        {
          private int errors = 0;
          public void syntaxError(Recognizer<?,?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e)
          {
            errors++; 
          }
        }
      """);
  }
  
  private static void emitParser(String domain)
  {
    String jname = typeNameJava(domain);
    emitLine("public static " + jname + " parse" + domain + "()");
    openBlock();
    emitLine(" return parse" + domain + "(new BufferedReader(new InputStreamReader(System.in)));");
    closeBlock();
    emitLine("public static " + jname + " parse" + domain + "(File file) throws FileNotFoundException");
    openBlock();
    emitLine(" return parse" + domain + "(new FileReader(file));");
    closeBlock();
    emitLine("public static " + jname + " parse" + domain + "(String text)");
    openBlock();
    emitLine(" return parse" + domain + "(new StringReader(text));");
    closeBlock();
    emitLine("public static " + jname + " parse" + domain + "(Reader reader)");
    openBlock();
    emit("""
            try
            {
              var input = CharStreams.fromReader(reader);
        """);
    level++;
    emitLine("var lexer = new " + languageName + "Lexer(input);");
    emitLine("var tokens = new CommonTokenStream(lexer);");
    emitLine("var parser = new " + languageName + "Parser(tokens);");
    emitLine("var listener = new ErrorListener();");
    emitLine("parser.addErrorListener(listener);");
    emitLine("var result = parser.d" + domain + "()._result;");
    level--;
    emit("""
        if (listener.errors > 0) 
        { 
          // System.out.println(listener.errors + " syntax errors.");
          throw new RuntimeException(listener.errors + " syntax errors"); 
        }
        return result;
        }
        catch(Exception e)
        {
          // var writer = new StringWriter();
          // e.printStackTrace(new PrintWriter(writer));
          // System.out.println("parser error (" + writer.toString() +")");
          throw new RuntimeException("parser error (" + e.getMessage() +")");
        }
    """);
    closeBlock();
  }
  
  // --------------------------------------------------------------------------
  // auxiliaries
  // --------------------------------------------------------------------------
  
  // get the name of the interface for a domain
  private static String typeNameJava(String domainName)
  {
    if (TypeChecker.getBuiltinDomains().contains(domainName)) return "String";
    return domainName; // both for literal domains and constructed domains
  }

  // get the name of the class for an operation on some domain
  private static String operationNameJava(String domainName, String operationName)
  {
    String interfaceName = typeNameJava(domainName);
    return interfaceName + "_" + operationName;
  }
  
  // emit code and new line character
  private static void emit(String code) { out.print(code); }
  private static void emitNewLine() { out.println(); }
  
  // the current indentation level
  private static int level = 0;
  
  // indent line and emit line of code at the current indentation level
  private static void indent() 
  {
    for (int i = 0; i < level; i++) emit("  ");
  }
  private static void emitLine(String code)
  {
    indent();
    emit(code);
    emitNewLine();
  }
  
  // open and close a code block
  private static void openBlock() { emitLine("{"); level++; }
  private static void closeBlock() { level--; emitLine("}"); }
  private static void closeBlock(String s) { level--; emitLine("}" + s); }
  
  // emit header code
  public static void emitHeader()
  {
    for (Clause clause : language.clauses())
    {
      if (!(clause instanceof Clause.Target)) continue;
      Clause.Target target = (Clause.Target)clause;
      Optional<Literal> header = target.header();
      if (header.isEmpty()) continue;
      emit(header.get().string());
    }
    emitNewLine();
  }
  
  // emit body code
  public static void emitCode()
  {
    for (Clause clause : language.clauses())
    {
      if (!(clause instanceof Clause.Code)) continue;
      Clause.Code code = (Clause.Code)clause;
      emit(code.literal().string());
    }
    emitNewLine();
  }
}
// ---------------------------------------------------------------------------
// end of file
// ---------------------------------------------------------------------------