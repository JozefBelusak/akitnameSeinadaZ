// ---------------------------------------------------------------------------
// TreeVisitor.java
// Translation from ANTLR4 parse trees to abstract syntax trees.
// $Id: TreeTranslator.java,v 1.18 2024/10/24 15:11:50 schreine Exp $
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
package slang.parser;

import java.util.*;

import slang.syntax.AST.*;

public final class TreeTranslator extends SLANGBaseVisitor<Object>
{
  // --------------------------------------------------------------------------
  // languages and clauses
  // --------------------------------------------------------------------------
  
  public Language visitLanguage(SLANGParser.LanguageContext c)
  {
    Id id = id(c.id());
    List<Clause> clauses = new ArrayList<Clause>();
    for (SLANGParser.ClauseContext clause : c.clause())
      clauses.add((Clause)visit(clause));
    return new Language(id, clauses);
  }
  
  public Clause.Target visitTarget(SLANGParser.TargetContext c)
  {
    Id id = new Id("java");
    Optional<Literal> literal = c.literal() == null ?
        Optional.empty() : Optional.of(literal(c.literal()));
    return new Clause.Target(id, literal);
  }
  
  public Clause.Code visitCode(SLANGParser.CodeContext c)
  {
    Literal literal = literal(c.literal());
    return new Clause.Code(literal);
  }
  
  public Clause.Domains visitDomains(SLANGParser.DomainsContext c)
  {
    List<DomainDef> domaindefs = new ArrayList<DomainDef>();
    for (SLANGParser.DomaindefContext domaindef : c.domaindef())
      domaindefs.add((DomainDef)visit(domaindef));
    return new Clause.Domains(domaindefs);
  }
  
  public Clause.Printer visitPrinter(SLANGParser.PrinterContext c)
  {
    List<PrinterDomain> printerdomains = new ArrayList<PrinterDomain>();
    for (SLANGParser.PrinterdomainContext printerdomain : c.printerdomain())
      printerdomains.add((PrinterDomain)visit(printerdomain));
    return new Clause.Printer(printerdomains);
  }
  
  public Clause.Parser visitParser(SLANGParser.ParserContext c)
  {
    List<ParserDomain> parserdomains = new ArrayList<ParserDomain>();
    for (SLANGParser.ParserdomainContext parserdomain : c.parserdomain())
      parserdomains.add((ParserDomain)visit(parserdomain));
    return new Clause.Parser(parserdomains);
  }
  
  public Clause.Judgment visitJudgment(SLANGParser.JudgmentContext c)
  {
    Id id = id(c.fun);
    Id domain = id(c.domain);
    List<Type> in = types(c.in);
    List<Type> out = types(c.out);
    List<Inference> inferences = new ArrayList<Inference>();
    for (SLANGParser.InferenceContext inference : c.inference())
      inferences.add((Inference)visit(inference));
    Optional<Effect> before = c.bid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.before), id(c.bid),
              ids(c.bin), ids(c.bout), literal(c.bliteral)));
    Optional<Effect> after = c.aid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.after), id(c.aid),
              ids(c.ain), ids(c.aout), literal(c.aliteral)));
    return new Clause.Judgment(id, domain, in, out, inferences, before, after);
  }
  
  public Clause.Transition visitTransition(SLANGParser.TransitionContext c)
  {
    Id id = id(c.fun);
    Id domain = id(c.domain);
    List<Type> in = types(c.in);
    List<Type> out = types(c.out);
    List<Step> steps = new ArrayList<Step>();
    for (SLANGParser.StepContext step : c.step())
      steps.add((Step)visit(step));
    Optional<Effect> before = c.bid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.before), id(c.bid),
              ids(c.bin), ids(c.bout), literal(c.bliteral)));
    Optional<Effect> after = c.aid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.after), id(c.aid),
              ids(c.ain), ids(c.aout), literal(c.aliteral)));
    return new Clause.Transition(id, domain, in, out, steps, before, after);
  }
  
  public Clause.Function visitFunction(SLANGParser.FunctionContext c)
  {
    Id id = id(c.fun);
    Id domain = id(c.domain);
    List<Type> in = types(c.in);
    List<Type> out = types(c.out);
    List<Equation> equations = new ArrayList<Equation>();
    for (SLANGParser.EquationContext equation : c.equation())
      equations.add((Equation)visit(equation));
    Optional<Effect> before = c.bid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.before), id(c.bid),
              ids(c.bin), ids(null), literal(c.bliteral)));
    Optional<Effect> after = c.aid == null ? Optional.empty() : 
      Optional.of(new Effect(id(c.after), id(c.aid),
              ids(c.ain), ids(c.aout), literal(c.aliteral)));
    return new Clause.Function(id, domain, in, out, equations, before, after);
  }
  
  public DomainDef visitDomaindef(SLANGParser.DomaindefContext c)
  {
    Id id = id(c.id());
    List<DomainCon> domaincons = new ArrayList<DomainCon>();
    for (SLANGParser.DomainconContext domaincon : c.domaincon())
      domaincons.add((DomainCon)visit(domaincon));
    return new DomainDef(id, domaincons);
  }
  
  public DomainCon visitDomaincon(SLANGParser.DomainconContext c)
  {
    Id id = id(c.id());
    List<Domain> domains = new ArrayList<Domain>();
    for (SLANGParser.DomainnameContext domainname : c.domainname())
    {
      Domain domain = (Domain)visit(domainname);
      domains.add(domain);
    }
    return new DomainCon(id, domains);
  }
  
  public Domain visitDomainId(SLANGParser.DomainIdContext c)
  {
    Id id = id(c.id());
    return id; 
  }
  
  public Domain visitDomainLiteral(SLANGParser.DomainLiteralContext c)
  {
    Literal literal = literal(c.literal());
    return literal; 
  }
  
  public PrinterDomain visitPrinterdomain(SLANGParser.PrinterdomainContext c)
  {
    Id id = id(c.id());
    List<PrinterCase> printercases = new ArrayList<PrinterCase>();
    for (SLANGParser.PrintercaseContext printercase : c.printercase())
      printercases.add((PrinterCase)visit(printercase));
    return new PrinterDomain(id, printercases);
  }
  
  public PrinterCase visitPrintercase(SLANGParser.PrintercaseContext c)
  {
    DomainPattern dpattern = (DomainPattern)visit(c.domainpattern());
    Literal literal = literal(c.literal());
    return new PrinterCase(dpattern, literal);
  }
  
  public ParserDomain visitParserdomain(SLANGParser.ParserdomainContext c)
  {
    Id id = id(c.id());
    Optional<Literal> literal = c.literal() == null ? Optional.empty() :
      Optional.of(literal(c.literal()));
    List<ParserCase> parsercases = new ArrayList<ParserCase>();
    for (SLANGParser.ParsercaseContext parsercase : c.parsercase())
      parsercases.add((ParserCase)visit(parsercase));
    return new ParserDomain(id, literal, parsercases);
  }
  
  public ParserCase visitParsercase(SLANGParser.ParsercaseContext c)
  {
    Literal literal = literal(c.literal());
    DomainExp dexp = domainexp(c.domainexp());
    return new ParserCase(literal, dexp);
  }
  
  public Inference visitInference(SLANGParser.InferenceContext c)
  {
    Id id = id(c.id());
    DomainPattern dpattern = (DomainPattern)visit(c.domainpattern());
    List<Id> in = ids(c.in);
    List<Id> out = ids(c.out);
    List<Body> bodies = bodies(c.bodies());
    Optional<Literal> before = c.before == null ? Optional.empty() :
      Optional.of(literal(c.before));
    Optional<Literal> after = c.after == null ? Optional.empty() :
      Optional.of(literal(c.after));
    return new Inference(id, dpattern, in, out, bodies, before, after);
  }
  
  public Step visitStep(SLANGParser.StepContext c)
  {
    Id id = id(c.id());
    DomainPattern dpattern = (DomainPattern)visit(c.domainpattern());
    List<Id> in = ids(c.in);
    List<Id> out = ids(c.out);
    List<Body> bodies = bodies(c.bodies());
    Optional<Literal> before = c.before == null ? Optional.empty() :
      Optional.of(literal(c.before));
    Optional<Literal> after = c.after == null ? Optional.empty() :
      Optional.of(literal(c.after));
    return new Step(id, dpattern, in, out, bodies, before, after);
  }
  
  public Equation visitEquation(SLANGParser.EquationContext c)
  {
    Id id = id(c.id());
    DomainPattern dpattern = (DomainPattern)visit(c.domainpattern());
    List<Id> in = ids(c.in);
    List<Id> out = ids(c.out);
    List<Body> bodies = bodies(c.bodies());
    Optional<Literal> before = c.before == null ? Optional.empty() :
      Optional.of(literal(c.before));
    Optional<Literal> after = c.after == null ? Optional.empty() :
      Optional.of(literal(c.after));
    return new Equation(id, dpattern, in, out, bodies, before, after);
  }
  
  public Body visitBody(SLANGParser.BodyContext c)
  {
    List<Command> commands = new ArrayList<Command>();
    for (SLANGParser.CommandContext command : c.command())
      commands.add(command(command));
    return new Body(commands);
  }
  
  public Literal visitCommandLiteral(SLANGParser.CommandLiteralContext c)
  {
    Literal literal = literal(c.literal());
    return literal;
  }
  
  public Command.Inference visitCommandInference(SLANGParser.CommandInferenceContext c)
  {
    Id domain = id(c.id(0));
    Id id = id(c.id(1));
    List<Id> in = ids(c.in);
    List<Id> out = ids(c.out);
    return new Command.Inference(id, domain, in, out);
  }
  
  public Command.Step visitCommandStep(SLANGParser.CommandStepContext c)
  {
    Id domain = id(c.id(0));
    Id id = id(c.id(1));
    List<Id> in = ids(c.in);
    List<Id> out = ids(c.out);
    return new Command.Step(id, domain, in, out);
  }
  
  public Command.Assignment visitAssignment(SLANGParser.AssignmentContext c)
  {
    List<Variable> variables = variables(c.variables());
    Optional<Value> value = c.value() == null ? Optional.empty() :
      Optional.of(value(c.value()));
    return new Command.Assignment(variables, value);
  }
  
  // --------------------------------------------------------------------------
  // auxiliary domains
  // --------------------------------------------------------------------------
  
  public Variable visitVariable(SLANGParser.VariableContext c)
  {
    Id id = id(c.id());
    Optional<Type> type = c.type() == null ? Optional.empty() :
      Optional.of(type(c.type()));
    return new Variable(id, type);
  }
  
  public Id visitValueId(SLANGParser.ValueIdContext c)
  {
    Id id = id(c.id());
    return id;
  }
  
  public Literal visitValueLiteral(SLANGParser.ValueLiteralContext c)
  {
    Literal literal = literal(c.literal());
    return literal;
  }

  public Value.Application visitApplication(SLANGParser.ApplicationContext c)
  {
    Id fun = id(c.fun);
    Id domain = id(c.domain);
    List<Value> values = values(c.values());
    return new Value.Application(fun, domain, values);
  }
  
  public DomainPattern visitDomainpattern(SLANGParser.DomainpatternContext c)
  {
    Optional<Id> id = c.res == null ? Optional.empty() : Optional.of(id(c.res));
    Id con = id(c.con);
    List<Id> ids = ids(c.ids());
    return new DomainPattern(id, con, ids);
  }

  public Literal visitDomainExpLiteral(SLANGParser.DomainExpLiteralContext c)
  {
    Literal literal = literal(c.literal());
    return literal;
  }
  
  public DomainExp.Application visitDomainExpApplication(SLANGParser.DomainExpApplicationContext c)
  {
    Id id = id(c.id());
    List<Id> ids = ids(c.ids());
    return new DomainExp.Application(id, ids);
  }
  
  public Literal visitType(SLANGParser.TypeContext c)
  {
    Literal literal = literal(c.literal());
    return literal;
  }
  
  // --------------------------------------------------------------------------
  // sequences
  // --------------------------------------------------------------------------
  
  public List<Type> visitTypes(SLANGParser.TypesContext c)
  {
    List<Type> types = new ArrayList<Type>();
    for (SLANGParser.TypeContext type : c.type())
      types.add(type(type));
    return types;
  }
  
  public List<Body> visitBodies(SLANGParser.BodiesContext c)
  {
    List<Body> bodies = new ArrayList<Body>();
    for (SLANGParser.BodyContext body : c.body())
      bodies.add(body(body));
    return bodies;
  }
  
  public List<Value> visitValues(SLANGParser.ValuesContext c)
  {
    List<Value> values = new ArrayList<Value>();
    for (SLANGParser.ValueContext value : c.value())
      values.add(value(value));
    return values;
  }
  
  public List<Variable> visitVariables(SLANGParser.VariablesContext c)
  {
    List<Variable> variables = new ArrayList<Variable>();
    for (SLANGParser.VariableContext variable : c.variable())
      variables.add(variable(variable));
    return variables;
  }
  
  public List<Id> visitIds(SLANGParser.IdsContext c)
  {
    List<Id> ids = new ArrayList<Id>();
    for (SLANGParser.IdContext id : c.id())
      ids.add(id(id));
    return ids;
  }
  
  // --------------------------------------------------------------------------
  // wrappers for lexer domains
  // --------------------------------------------------------------------------
  
  public Id visitId(SLANGParser.IdContext c)
  {
    return new Id(c.getText());
  }
  
  public Literal visitLiteral(SLANGParser.LiteralContext c)
  {
    String text = c.getText();
    int n = text.length();
    if (text.startsWith("{##"))
      text = text.substring(3, n-3);
    else if (text.startsWith("##"))
      text = text.substring(2, n-2);
    else if (text.startsWith("{#"))
      text = text.substring(2, n-2);
    else if (text.startsWith("#"))
      text = text.substring(1, n-1);
    return new Literal(text);
  }
  
  // --------------------------------------------------------------------------
  // visitor auxiliaries
  // --------------------------------------------------------------------------
  
  private Id id(SLANGParser.IdContext c)
  {
    if (c == null) return new Id("");
    Id id = (Id)visit(c);
    return id;
  }
  
  private Literal literal(SLANGParser.LiteralContext c)
  {
    if (c == null) return new Literal("");
    Literal literal = (Literal)visit(c);
    return literal;
  }
  
  private Type type(SLANGParser.TypeContext c)
  {
    Type type = (Type)visit(c);
    return type;
  }
  
  private Body body(SLANGParser.BodyContext c)
  {
    Body body = (Body)visit(c);
    return body;
  }
  
  private Value value(SLANGParser.ValueContext c)
  {
    Value value = (Value)visit(c);
    return value;
  }
  
  private Variable variable(SLANGParser.VariableContext c)
  {
    Variable variable = (Variable)visit(c);
    return variable;
  }
  
  private DomainExp domainexp(SLANGParser.DomainexpContext c)
  {
    DomainExp domainexp = (DomainExp)visit(c);
    return domainexp;
  }
  
  private Command command(SLANGParser.CommandContext c)
  {
    Command command = (Command)visit(c);
    return command;
  }
  
  private List<Type> types(SLANGParser.TypesContext c)
  {
    if (c == null) return new ArrayList<Type>();
    @SuppressWarnings("unchecked")
    List<Type> types = (List<Type>)visit(c);
    return types;
  }
  
  private List<Body> bodies(SLANGParser.BodiesContext c)
  {
    if (c == null) return new ArrayList<Body>();
    @SuppressWarnings("unchecked")
    List<Body> bodies = (List<Body>)visit(c);
    return bodies;
  }
  
  private List<Id> ids(SLANGParser.IdsContext c)
  {
    if (c == null) return new ArrayList<Id>();
    @SuppressWarnings("unchecked")
    List<Id> ids = (List<Id>)visit(c);
    return ids;
  }
  
  private List<Variable> variables(SLANGParser.VariablesContext c)
  {
    if (c == null) return new ArrayList<Variable>();
    @SuppressWarnings("unchecked")
    List<Variable> variables = (List<Variable>)visit(c);
    return variables;
  }
  
  private List<Value> values(SLANGParser.ValuesContext c)
  {
    if (c == null) return new ArrayList<Value>();
    @SuppressWarnings("unchecked")
    List<Value> values = (List<Value>)visit(c);
    return values;
  }
}
// ---------------------------------------------------------------------------
// end of file
// ---------------------------------------------------------------------------
