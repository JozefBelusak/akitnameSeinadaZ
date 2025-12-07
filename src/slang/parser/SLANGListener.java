// Generated from SLANG.g4 by ANTLR 4.13.1

  package slang.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SLANGParser}.
 */
public interface SLANGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SLANGParser#language}.
	 * @param ctx the parse tree
	 */
	void enterLanguage(SLANGParser.LanguageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#language}.
	 * @param ctx the parse tree
	 */
	void exitLanguage(SLANGParser.LanguageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Target}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterTarget(SLANGParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Target}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitTarget(SLANGParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Code}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterCode(SLANGParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Code}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitCode(SLANGParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Domains}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterDomains(SLANGParser.DomainsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Domains}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitDomains(SLANGParser.DomainsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Printer}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterPrinter(SLANGParser.PrinterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Printer}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitPrinter(SLANGParser.PrinterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parser}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterParser(SLANGParser.ParserContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parser}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitParser(SLANGParser.ParserContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Judgment}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterJudgment(SLANGParser.JudgmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Judgment}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitJudgment(SLANGParser.JudgmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Transition}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterTransition(SLANGParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Transition}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitTransition(SLANGParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SLANGParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link SLANGParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SLANGParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#domaindef}.
	 * @param ctx the parse tree
	 */
	void enterDomaindef(SLANGParser.DomaindefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#domaindef}.
	 * @param ctx the parse tree
	 */
	void exitDomaindef(SLANGParser.DomaindefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#domaincon}.
	 * @param ctx the parse tree
	 */
	void enterDomaincon(SLANGParser.DomainconContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#domaincon}.
	 * @param ctx the parse tree
	 */
	void exitDomaincon(SLANGParser.DomainconContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DomainId}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 */
	void enterDomainId(SLANGParser.DomainIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DomainId}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 */
	void exitDomainId(SLANGParser.DomainIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DomainLiteral}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 */
	void enterDomainLiteral(SLANGParser.DomainLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DomainLiteral}
	 * labeled alternative in {@link SLANGParser#domainname}.
	 * @param ctx the parse tree
	 */
	void exitDomainLiteral(SLANGParser.DomainLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#printerdomain}.
	 * @param ctx the parse tree
	 */
	void enterPrinterdomain(SLANGParser.PrinterdomainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#printerdomain}.
	 * @param ctx the parse tree
	 */
	void exitPrinterdomain(SLANGParser.PrinterdomainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#printercase}.
	 * @param ctx the parse tree
	 */
	void enterPrintercase(SLANGParser.PrintercaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#printercase}.
	 * @param ctx the parse tree
	 */
	void exitPrintercase(SLANGParser.PrintercaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#parserdomain}.
	 * @param ctx the parse tree
	 */
	void enterParserdomain(SLANGParser.ParserdomainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#parserdomain}.
	 * @param ctx the parse tree
	 */
	void exitParserdomain(SLANGParser.ParserdomainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#parsercase}.
	 * @param ctx the parse tree
	 */
	void enterParsercase(SLANGParser.ParsercaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#parsercase}.
	 * @param ctx the parse tree
	 */
	void exitParsercase(SLANGParser.ParsercaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#inference}.
	 * @param ctx the parse tree
	 */
	void enterInference(SLANGParser.InferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#inference}.
	 * @param ctx the parse tree
	 */
	void exitInference(SLANGParser.InferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(SLANGParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(SLANGParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(SLANGParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(SLANGParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(SLANGParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(SLANGParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandLiteral}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandLiteral(SLANGParser.CommandLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandLiteral}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandLiteral(SLANGParser.CommandLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandInference}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandInference(SLANGParser.CommandInferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandInference}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandInference(SLANGParser.CommandInferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandStep}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandStep(SLANGParser.CommandStepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandStep}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandStep(SLANGParser.CommandStepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SLANGParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SLANGParser#command}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SLANGParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SLANGParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SLANGParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueId}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueId(SLANGParser.ValueIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueId}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueId(SLANGParser.ValueIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueLiteral}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLiteral(SLANGParser.ValueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueLiteral}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLiteral(SLANGParser.ValueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Application}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void enterApplication(SLANGParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link SLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void exitApplication(SLANGParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#domainpattern}.
	 * @param ctx the parse tree
	 */
	void enterDomainpattern(SLANGParser.DomainpatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#domainpattern}.
	 * @param ctx the parse tree
	 */
	void exitDomainpattern(SLANGParser.DomainpatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DomainExpLiteral}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 */
	void enterDomainExpLiteral(SLANGParser.DomainExpLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DomainExpLiteral}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 */
	void exitDomainExpLiteral(SLANGParser.DomainExpLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DomainExpApplication}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 */
	void enterDomainExpApplication(SLANGParser.DomainExpApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DomainExpApplication}
	 * labeled alternative in {@link SLANGParser#domainexp}.
	 * @param ctx the parse tree
	 */
	void exitDomainExpApplication(SLANGParser.DomainExpApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SLANGParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SLANGParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(SLANGParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(SLANGParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#bodies}.
	 * @param ctx the parse tree
	 */
	void enterBodies(SLANGParser.BodiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#bodies}.
	 * @param ctx the parse tree
	 */
	void exitBodies(SLANGParser.BodiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link SLANGParser#clauseclauseclauseclauseclauseclauseclauseclausedomainnamedomainnamecommandcommandcommandcommandvaluevaluevaluedomainexpdomainexp}.
	 * @param ctx the parse tree
	 */
	void enterValues(SLANGParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link SLANGParser#clauseclauseclauseclauseclauseclauseclauseclausedomainnamedomainnamecommandcommandcommandcommandvaluevaluevaluedomainexpdomainexp}.
	 * @param ctx the parse tree
	 */
	void exitValues(SLANGParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(SLANGParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(SLANGParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(SLANGParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(SLANGParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(SLANGParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(SLANGParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLANGParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SLANGParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLANGParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SLANGParser.LiteralContext ctx);
}