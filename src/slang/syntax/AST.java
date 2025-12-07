// ---------------------------------------------------------------------------
// AST.java
// Abstract syntax trees.
// $Id: AST.java,v 1.20 2023/07/20 08:17:32 schreine Exp $
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
package slang.syntax;

import java.util.*;

public sealed interface AST permits 
  AST.Language, AST.Clause, AST.DomainDef, AST.DomainCon, AST.Domain,
  AST.PrinterDomain, AST.PrinterCase, AST.ParserDomain, AST.ParserCase,
  AST.Inference, AST.Step, AST.Equation, 
  AST.Body, AST.Command, AST.Effect, AST.Variable, AST.Value,
  AST.DomainPattern, AST.DomainExp, AST.Type, AST.Id, AST.Literal
{
  // languages and clauses
  public record Language(Id id, List<Clause> clauses) implements AST { }
  public sealed interface Clause extends AST permits 
    Clause.Target, Clause.Code, Clause.Domains, Clause.Printer, Clause.Parser,
    Clause.Judgment, Clause.Transition, Clause.Function
  {
    public record Target(Id id, Optional<Literal> header) implements Clause { }
    public record Code(Literal literal) implements Clause { }
    public record Domains(List<DomainDef> defs) implements Clause { }
    public record Printer(List<PrinterDomain> prdomains) implements Clause { }
    public record Parser(List<ParserDomain> padomains) implements Clause { }
    public record Judgment(Id id, Id domain, 
      List<Type> in, List<Type> out, List<Inference> inferences,
      Optional<Effect> before, Optional<Effect> after) implements Clause { }
    public record Transition(Id id, Id domain, 
      List<Type> in, List<Type> out, List<Step> steps,
      Optional<Effect> before, Optional<Effect> after) implements Clause { }
    public record Function(Id id, Id domain,
      List<Type> in, List<Type> out, List<Equation> equations,
      Optional<Effect> before, Optional<Effect> after) implements Clause { }
  }
  // domains and their constructors
  public record DomainDef(Id id, List<DomainCon> cons) implements AST { }
  public record DomainCon(Id id, List<Domain> domains) implements AST { }
  public sealed interface Domain extends AST permits Id, Literal { }
  // printers
  public record PrinterDomain(Id id, List<PrinterCase> pcases) implements AST { }
  public record PrinterCase(DomainPattern dpattern, Literal literal) implements AST { }
  // parsers
  public record ParserDomain(Id id, Optional<Literal> literal, 
    List<ParserCase> pcases) implements AST { }
  public record ParserCase(Literal literal, DomainExp dexp) implements AST { }
  // inferences, steps, equations, effects
  public record Inference(Id id, DomainPattern dpattern, 
    List<Id> in, List<Id> out, List<Body> bodies,
    Optional<Literal> before, Optional<Literal> after) implements AST { }
  public record Step(Id id, DomainPattern dpattern, 
    List<Id> in, List<Id> out, List<Body> bodies,
    Optional<Literal> before, Optional<Literal> after) implements AST { }
  public record Equation(Id id, DomainPattern dpattern,
    List<Id> in, List<Id> out, List<Body> bodies,
    Optional<Literal> before, Optional<Literal> after) implements AST { }
  public record Effect(Id id, Id phrase, List<Id> in, List<Id> out, Literal literal) implements AST { }
  // bodies and commands
  public record Body(List<Command> commands) implements AST { }
  public sealed interface Command extends AST permits 
    Literal, Command.Inference, Command.Step, Command.Assignment
  { 
    public record Inference(Id id, Id domain, 
      List<Id> in, List<Id> out) implements Command { }
    public record Step(Id id, Id domain, 
      List<Id> in, List<Id> out) implements Command { }
    public record Assignment(List<Variable> variables, 
      Optional<Value> value) implements Command { }
  }
  // auxiliaries
  public record Variable(Id id, Optional<Type> type) implements AST { }
  public sealed interface Value extends AST permits Id, Literal, Value.Application
  {
    public record Application(Id id, Id domain, List<Value> values) implements Value { }
  }
  public record DomainPattern(Optional<Id> id, Id con, List<Id> ids) implements AST { }
  public sealed interface DomainExp extends AST permits Literal, DomainExp.Application
  {
    public record Application(Id id, List<Id> ids) implements DomainExp { }
  }
  public sealed interface Type extends AST permits Literal { }
  public record Literal(String string) implements AST, Domain, Type, Value, Command, DomainExp { }
  public final class Id implements AST, Domain, Value 
  { 
    // the immutable part
    private final String string;
    public Id(String string) { this.string = string; }
    public String string() { return string; }
    // for compatibility with records, also the object methods (just to be sure)
    public String toString() { return string; }
    public boolean equals(Object object) 
    {
      if (!(object instanceof Id)) return false;
      Id object0 = (Id)object;
      return string.equals(object0.string);
    }
    public int hashCode() { return string.hashCode(); }
    // the mutable part
    private String type = null;
    public void setType(String type) { this.type = type; }
    public String type() { return type; }
    private boolean declare = false;
    public void setDeclare(boolean declare) { this.declare = true; }
    public boolean declare() { return declare; }
  }
}
// ---------------------------------------------------------------------------
// end of file
// ---------------------------------------------------------------------------
