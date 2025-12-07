// Generated from SLANG.g4 by ANTLR 4.13.1

  package slang.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SLANGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SLANGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SLANGParser#language}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguage(SLANGParser.LanguageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Target}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(SLANGParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Code}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(SLANGParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Domains}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomains(SLANGParser.DomainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Printer}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrinter(SLANGParser.PrinterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parser}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParser(SLANGParser.ParserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Judgment}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJudgment(SLANGParser.JudgmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Transition}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(SLANGParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SLANGParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#domaindef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomaindef(SLANGParser.DomaindefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#domaincon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomaincon(SLANGParser.DomainconContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DomainId}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainId(SLANGParser.DomainIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DomainLiteral}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainLiteral(SLANGParser.DomainLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#printerdomain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrinterdomain(SLANGParser.PrinterdomainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#printercase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintercase(SLANGParser.PrintercaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#parserdomain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParserdomain(SLANGParser.ParserdomainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#parsercase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsercase(SLANGParser.ParsercaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#inference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInference(SLANGParser.InferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(SLANGParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(SLANGParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(SLANGParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandLiteral}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandLiteral(SLANGParser.CommandLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandInference}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandInference(SLANGParser.CommandInferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandStep}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandStep(SLANGParser.CommandStepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SLANGParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SLANGParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueId}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueId(SLANGParser.ValueIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueLiteral}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueLiteral(SLANGParser.ValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(SLANGParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#domainpattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainpattern(SLANGParser.DomainpatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DomainExpLiteral}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainExpLiteral(SLANGParser.DomainExpLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DomainExpApplication}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainExpApplication(SLANGParser.DomainExpApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SLANGParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(SLANGParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#bodies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodies(SLANGParser.BodiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link SLANGParser#clauseclauseclauseclauseclauseclauseclauseclausedomainnamedomainnamecommandcommandcommandcommandvaluevaluevaluedomainexpdomainexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(SLANGParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(SLANGParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#ids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIds(SLANGParser.IdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(SLANGParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLANGParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SLANGParser.LiteralContext ctx);
}