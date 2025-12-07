// Generated from SLANG.g4 by ANTLR 4.13.1

  package slang.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SLANGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, ID=48, LITA=49, LITB=50, LITC=51, LITD=52, WHITESPACE=53, 
		LINECOMMENT=54, COMMENT=55, ERROR=56;
	public static final int
		RULE_language = 0, RULE_clause = 1, RULE_domaindef = 2, RULE_domaincon = 3, 
		RULE_domainname = 4, RULE_printerdomain = 5, RULE_printercase = 6, RULE_parserdomain = 7, 
		RULE_parsercase = 8, RULE_inference = 9, RULE_step = 10, RULE_equation = 11, 
		RULE_body = 12, RULE_command = 13, RULE_variable = 14, RULE_value = 15, 
		RULE_domainpattern = 16, RULE_domainexp = 17, RULE_type = 18, RULE_types = 19, 
		RULE_bodies = 20, RULE_values = 21, RULE_variables = 22, RULE_ids = 23, 
		RULE_id = 24, RULE_literal = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"language", "clause", "domaindef", "domaincon", "domainname", "printerdomain", 
			"printercase", "parserdomain", "parsercase", "inference", "step", "equation", 
			"body", "command", "variable", "value", "domainpattern", "domainexp", 
			"type", "types", "bodies", "values", "variables", "ids", "id", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'language'", "'{'", "';'", "'}'", "'target'", "'java'", "'header'", 
			"'code'", "'domains'", "'printer'", "'parser'", "'antlr4'", "'judgment'", 
			"'judgement'", "'\\u22A2'", "'|-'", "':'", "'('", "')'", "'before'", 
			"'after'", "'transition'", "'\\u27E8'", "'<<'", "','", "'\\u27E9'", "'>>'", 
			"'\\u2192'", "'->'", "'function'", "'\\u301A'", "'[['", "'\\u301B'", 
			"']]'", "'='", "'+'", "'['", "']'", "'domain'", "'case'", "'prefix'", 
			"'inference'", "'step'", "'equation'", "'\\u00D7'", "'*'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "LITA", "LITB", "LITC", "LITD", "WHITESPACE", "LINECOMMENT", "COMMENT", 
			"ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SLANG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SLANGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LanguageContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SLANGParser.EOF, 0); }
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public LanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_language; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterLanguage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitLanguage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitLanguage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguageContext language() throws RecognitionException {
		LanguageContext _localctx = new LanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_language);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__0);
			setState(53);
			id();
			setState(54);
			match(T__1);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(55);
				match(T__2);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1077964576L) != 0)) {
				{
				{
				setState(61);
				clause();
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(62);
					match(T__2);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__3);
			setState(74);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClauseContext extends ParserRuleContext {
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
	 
		public ClauseContext() { }
		public void copyFrom(ClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomainsContext extends ClauseContext {
		public List<DomaindefContext> domaindef() {
			return getRuleContexts(DomaindefContext.class);
		}
		public DomaindefContext domaindef(int i) {
			return getRuleContext(DomaindefContext.class,i);
		}
		public DomainsContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomains(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomains(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomains(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ClauseContext {
		public IdContext fun;
		public IdContext domain;
		public TypesContext in;
		public TypesContext out;
		public IdContext before;
		public IdContext bid;
		public IdsContext bin;
		public LiteralContext bliteral;
		public IdContext after;
		public IdContext aid;
		public IdsContext ain;
		public IdsContext aout;
		public LiteralContext aliteral;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public List<EquationContext> equation() {
			return getRuleContexts(EquationContext.class);
		}
		public EquationContext equation(int i) {
			return getRuleContext(EquationContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public FunctionContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TargetContext extends ClauseContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TargetContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitTarget(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ClauseContext {
		public IdContext domain;
		public TypesContext in;
		public IdContext fun;
		public TypesContext out;
		public IdsContext bin;
		public IdContext bid;
		public IdContext before;
		public IdsContext bout;
		public LiteralContext bliteral;
		public IdsContext ain;
		public IdContext aid;
		public IdContext after;
		public IdsContext aout;
		public LiteralContext aliteral;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public TransitionContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrinterContext extends ClauseContext {
		public List<PrinterdomainContext> printerdomain() {
			return getRuleContexts(PrinterdomainContext.class);
		}
		public PrinterdomainContext printerdomain(int i) {
			return getRuleContext(PrinterdomainContext.class,i);
		}
		public PrinterContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterPrinter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitPrinter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitPrinter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeContext extends ClauseContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CodeContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParserContext extends ClauseContext {
		public List<ParserdomainContext> parserdomain() {
			return getRuleContexts(ParserdomainContext.class);
		}
		public ParserdomainContext parserdomain(int i) {
			return getRuleContext(ParserdomainContext.class,i);
		}
		public ParserContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitParser(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JudgmentContext extends ClauseContext {
		public TypesContext in;
		public IdContext domain;
		public IdContext fun;
		public TypesContext out;
		public IdsContext bin;
		public IdContext bid;
		public IdContext before;
		public IdsContext bout;
		public LiteralContext bliteral;
		public IdsContext ain;
		public IdContext aid;
		public IdContext after;
		public IdsContext aout;
		public LiteralContext aliteral;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<InferenceContext> inference() {
			return getRuleContexts(InferenceContext.class);
		}
		public InferenceContext inference(int i) {
			return getRuleContext(InferenceContext.class,i);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public JudgmentContext(ClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterJudgment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitJudgment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitJudgment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clause);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new TargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__4);
				setState(77);
				match(T__5);
				setState(78);
				match(T__1);
				setState(79);
				match(T__6);
				setState(80);
				literal();
				setState(81);
				match(T__3);
				}
				break;
			case T__7:
				_localctx = new CodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(T__7);
				setState(84);
				literal();
				}
				break;
			case T__8:
				_localctx = new DomainsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				match(T__8);
				setState(86);
				match(T__1);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(87);
					domaindef();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__3);
				}
				break;
			case T__9:
				_localctx = new PrinterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				match(T__9);
				setState(95);
				match(T__1);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__38) {
					{
					{
					setState(96);
					printerdomain();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(T__3);
				}
				break;
			case T__10:
				_localctx = new ParserContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				match(T__10);
				setState(104);
				match(T__11);
				setState(105);
				match(T__1);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__38) {
					{
					{
					setState(106);
					parserdomain();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(T__3);
				}
				break;
			case T__12:
			case T__13:
				_localctx = new JudgmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8444249301319680L) != 0)) {
					{
					setState(114);
					((JudgmentContext)_localctx).in = types();
					}
				}

				setState(117);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				((JudgmentContext)_localctx).domain = id();
				setState(119);
				match(T__16);
				setState(120);
				((JudgmentContext)_localctx).fun = id();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(121);
					match(T__17);
					setState(122);
					((JudgmentContext)_localctx).out = types();
					setState(123);
					match(T__18);
					}
				}

				setState(127);
				match(T__1);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__41) {
					{
					{
					setState(128);
					inference();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				match(T__3);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(135);
					match(T__19);
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(136);
						((JudgmentContext)_localctx).bin = ids();
						}
					}

					setState(139);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(140);
					((JudgmentContext)_localctx).bid = id();
					setState(141);
					match(T__16);
					setState(142);
					((JudgmentContext)_localctx).before = id();
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(143);
						match(T__17);
						setState(144);
						((JudgmentContext)_localctx).bout = ids();
						setState(145);
						match(T__18);
						}
					}

					setState(149);
					((JudgmentContext)_localctx).bliteral = literal();
					}
				}

				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(153);
					match(T__20);
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(154);
						((JudgmentContext)_localctx).ain = ids();
						}
					}

					setState(157);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(158);
					((JudgmentContext)_localctx).aid = id();
					setState(159);
					match(T__16);
					setState(160);
					((JudgmentContext)_localctx).after = id();
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(161);
						match(T__17);
						setState(162);
						((JudgmentContext)_localctx).aout = ids();
						setState(163);
						match(T__18);
						}
					}

					setState(167);
					((JudgmentContext)_localctx).aliteral = literal();
					}
				}

				}
				break;
			case T__21:
				_localctx = new TransitionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(T__21);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22 || _la==T__23) {
					{
					setState(172);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(175);
				((TransitionContext)_localctx).domain = id();
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(176);
					match(T__24);
					setState(177);
					((TransitionContext)_localctx).in = types();
					}
				}

				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(180);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(183);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(184);
					((TransitionContext)_localctx).fun = id();
					}
				}

				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22 || _la==T__23) {
					{
					setState(187);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(190);
				((TransitionContext)_localctx).out = types();
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(191);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(194);
				match(T__1);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__42) {
					{
					{
					setState(195);
					step();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(T__3);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(202);
					match(T__19);
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(203);
						((TransitionContext)_localctx).bin = ids();
						}
					}

					setState(206);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(207);
					((TransitionContext)_localctx).bid = id();
					setState(208);
					match(T__16);
					setState(209);
					((TransitionContext)_localctx).before = id();
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(210);
						match(T__17);
						setState(211);
						((TransitionContext)_localctx).bout = ids();
						setState(212);
						match(T__18);
						}
					}

					setState(216);
					((TransitionContext)_localctx).bliteral = literal();
					}
				}

				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(220);
					match(T__20);
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(221);
						((TransitionContext)_localctx).ain = ids();
						}
					}

					setState(224);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(225);
					((TransitionContext)_localctx).aid = id();
					setState(226);
					match(T__16);
					setState(227);
					((TransitionContext)_localctx).after = id();
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(228);
						match(T__17);
						setState(229);
						((TransitionContext)_localctx).aout = ids();
						setState(230);
						match(T__18);
						}
					}

					setState(234);
					((TransitionContext)_localctx).aliteral = literal();
					}
				}

				}
				break;
			case T__29:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(238);
				match(T__29);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(239);
					((FunctionContext)_localctx).fun = id();
					}
				}

				setState(242);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(243);
				((FunctionContext)_localctx).domain = id();
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==T__32 || _la==T__33) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(245);
				match(T__16);
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(246);
					((FunctionContext)_localctx).in = types();
					setState(247);
					_la = _input.LA(1);
					if ( !(_la==T__27 || _la==T__28) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(251);
				((FunctionContext)_localctx).out = types();
				setState(252);
				match(T__1);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__43) {
					{
					{
					setState(253);
					equation();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259);
				match(T__3);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(260);
					match(T__19);
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(261);
						((FunctionContext)_localctx).before = id();
						}
					}

					setState(264);
					_la = _input.LA(1);
					if ( !(_la==T__30 || _la==T__31) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(265);
					((FunctionContext)_localctx).bid = id();
					setState(266);
					_la = _input.LA(1);
					if ( !(_la==T__32 || _la==T__33) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(267);
						match(T__17);
						setState(268);
						((FunctionContext)_localctx).bin = ids();
						setState(269);
						match(T__18);
						}
					}

					setState(273);
					((FunctionContext)_localctx).bliteral = literal();
					}
				}

				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(277);
					match(T__20);
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(278);
						((FunctionContext)_localctx).after = id();
						}
					}

					setState(281);
					_la = _input.LA(1);
					if ( !(_la==T__30 || _la==T__31) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(282);
					((FunctionContext)_localctx).aid = id();
					setState(283);
					_la = _input.LA(1);
					if ( !(_la==T__32 || _la==T__33) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__17) {
						{
						setState(284);
						match(T__17);
						setState(285);
						((FunctionContext)_localctx).ain = ids();
						setState(286);
						match(T__18);
						}
					}

					setState(290);
					match(T__34);
					setState(291);
					((FunctionContext)_localctx).aout = ids();
					setState(292);
					((FunctionContext)_localctx).aliteral = literal();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomaindefContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<DomainconContext> domaincon() {
			return getRuleContexts(DomainconContext.class);
		}
		public DomainconContext domaincon(int i) {
			return getRuleContext(DomainconContext.class,i);
		}
		public DomaindefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domaindef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomaindef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomaindef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomaindef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomaindefContext domaindef() throws RecognitionException {
		DomaindefContext _localctx = new DomaindefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_domaindef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			id();
			setState(299);
			match(T__34);
			setState(300);
			domaincon();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(301);
				match(T__35);
				setState(302);
				domaincon();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomainconContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<DomainnameContext> domainname() {
			return getRuleContexts(DomainnameContext.class);
		}
		public DomainnameContext domainname(int i) {
			return getRuleContext(DomainnameContext.class,i);
		}
		public DomainconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domaincon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomaincon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomaincon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomaincon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainconContext domaincon() throws RecognitionException {
		DomainconContext _localctx = new DomainconContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_domaincon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			id();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(311);
				match(T__36);
				{
				setState(312);
				domainname();
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(313);
					match(T__24);
					setState(314);
					domainname();
					}
					}
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(320);
				match(T__37);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomainnameContext extends ParserRuleContext {
		public DomainnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainname; }
	 
		public DomainnameContext() { }
		public void copyFrom(DomainnameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomainIdContext extends DomainnameContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public DomainIdContext(DomainnameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomainId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomainId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomainId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomainLiteralContext extends DomainnameContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public DomainLiteralContext(DomainnameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomainLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomainLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomainLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainnameContext domainname() throws RecognitionException {
		DomainnameContext _localctx = new DomainnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_domainname);
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new DomainIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				id();
				}
				break;
			case LITA:
			case LITB:
			case LITC:
			case LITD:
				_localctx = new DomainLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrinterdomainContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<PrintercaseContext> printercase() {
			return getRuleContexts(PrintercaseContext.class);
		}
		public PrintercaseContext printercase(int i) {
			return getRuleContext(PrintercaseContext.class,i);
		}
		public PrinterdomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printerdomain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterPrinterdomain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitPrinterdomain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitPrinterdomain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrinterdomainContext printerdomain() throws RecognitionException {
		PrinterdomainContext _localctx = new PrinterdomainContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printerdomain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__38);
			setState(329);
			id();
			setState(330);
			match(T__1);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(331);
				printercase();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintercaseContext extends ParserRuleContext {
		public DomainpatternContext domainpattern() {
			return getRuleContext(DomainpatternContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrintercaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printercase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterPrintercase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitPrintercase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitPrintercase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintercaseContext printercase() throws RecognitionException {
		PrintercaseContext _localctx = new PrintercaseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printercase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(T__39);
			setState(340);
			domainpattern();
			setState(341);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(342);
			literal();
			setState(343);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParserdomainContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public List<ParsercaseContext> parsercase() {
			return getRuleContexts(ParsercaseContext.class);
		}
		public ParsercaseContext parsercase(int i) {
			return getRuleContext(ParsercaseContext.class,i);
		}
		public ParserdomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserdomain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterParserdomain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitParserdomain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitParserdomain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParserdomainContext parserdomain() throws RecognitionException {
		ParserdomainContext _localctx = new ParserdomainContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parserdomain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__38);
			setState(346);
			id();
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__40) {
				{
				setState(347);
				match(T__40);
				setState(348);
				literal();
				}
			}

			setState(351);
			match(T__1);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(352);
				parsercase();
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParsercaseContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public DomainexpContext domainexp() {
			return getRuleContext(DomainexpContext.class,0);
		}
		public ParsercaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsercase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterParsercase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitParsercase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitParsercase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsercaseContext parsercase() throws RecognitionException {
		ParsercaseContext _localctx = new ParsercaseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parsercase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__39);
			setState(361);
			literal();
			setState(362);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(363);
			domainexp();
			setState(364);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InferenceContext extends ParserRuleContext {
		public IdsContext in;
		public IdsContext out;
		public LiteralContext before;
		public LiteralContext after;
		public DomainpatternContext domainpattern() {
			return getRuleContext(DomainpatternContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public BodiesContext bodies() {
			return getRuleContext(BodiesContext.class,0);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public InferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterInference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitInference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitInference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferenceContext inference() throws RecognitionException {
		InferenceContext _localctx = new InferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(T__41);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(367);
				((InferenceContext)_localctx).in = ids();
				}
			}

			setState(370);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(371);
			domainpattern();
			setState(372);
			match(T__16);
			setState(373);
			id();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(374);
				match(T__17);
				setState(375);
				((InferenceContext)_localctx).out = ids();
				setState(376);
				match(T__18);
				}
			}

			setState(380);
			bodies();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(381);
				match(T__19);
				setState(382);
				((InferenceContext)_localctx).before = literal();
				}
			}

			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(385);
				match(T__20);
				setState(386);
				((InferenceContext)_localctx).after = literal();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StepContext extends ParserRuleContext {
		public IdsContext in;
		public IdsContext out;
		public LiteralContext before;
		public LiteralContext after;
		public DomainpatternContext domainpattern() {
			return getRuleContext(DomainpatternContext.class,0);
		}
		public BodiesContext bodies() {
			return getRuleContext(BodiesContext.class,0);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_step);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(T__42);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22 || _la==T__23) {
				{
				setState(390);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(393);
			domainpattern();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(394);
				match(T__24);
				setState(395);
				((StepContext)_localctx).in = ids();
				}
			}

			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25 || _la==T__26) {
				{
				setState(398);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(401);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(403);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(402);
				id();
				}
				break;
			}
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22 || _la==T__23) {
				{
				setState(405);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(408);
			((StepContext)_localctx).out = ids();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25 || _la==T__26) {
				{
				setState(409);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(412);
			bodies();
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(413);
				match(T__19);
				setState(414);
				((StepContext)_localctx).before = literal();
				}
			}

			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(417);
				match(T__20);
				setState(418);
				((StepContext)_localctx).after = literal();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EquationContext extends ParserRuleContext {
		public IdsContext in;
		public IdsContext out;
		public LiteralContext before;
		public LiteralContext after;
		public DomainpatternContext domainpattern() {
			return getRuleContext(DomainpatternContext.class,0);
		}
		public BodiesContext bodies() {
			return getRuleContext(BodiesContext.class,0);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_equation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__43);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(422);
				id();
				}
			}

			setState(425);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(426);
			domainpattern();
			setState(427);
			_la = _input.LA(1);
			if ( !(_la==T__32 || _la==T__33) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(428);
				match(T__17);
				setState(429);
				((EquationContext)_localctx).in = ids();
				setState(430);
				match(T__18);
				}
			}

			setState(434);
			match(T__34);
			setState(435);
			((EquationContext)_localctx).out = ids();
			setState(436);
			bodies();
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(437);
				match(T__19);
				setState(438);
				((EquationContext)_localctx).before = literal();
				}
			}

			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(441);
				match(T__20);
				setState(442);
				((EquationContext)_localctx).after = literal();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(T__1);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8725724303294464L) != 0)) {
				{
				{
				setState(446);
				command();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends CommandContext {
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AssignmentContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommandInferenceContext extends CommandContext {
		public IdsContext in;
		public IdsContext out;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public CommandInferenceContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterCommandInference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitCommandInference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitCommandInference(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommandStepContext extends CommandContext {
		public IdsContext in;
		public IdsContext out;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public CommandStepContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterCommandStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitCommandStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitCommandStep(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommandLiteralContext extends CommandContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CommandLiteralContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterCommandLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitCommandLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitCommandLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_command);
		int _la;
		try {
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				_localctx = new CommandLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				literal();
				}
				break;
			case 2:
				_localctx = new CommandInferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(455);
					((CommandInferenceContext)_localctx).in = ids();
					}
				}

				setState(458);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(459);
				id();
				setState(460);
				match(T__16);
				setState(461);
				id();
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(462);
					match(T__17);
					setState(463);
					((CommandInferenceContext)_localctx).out = ids();
					setState(464);
					match(T__18);
					}
				}

				setState(468);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new CommandStepContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22 || _la==T__23) {
					{
					setState(470);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(473);
				id();
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(474);
					match(T__24);
					setState(475);
					((CommandStepContext)_localctx).in = ids();
					}
				}

				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(478);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(481);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(483);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(482);
					id();
					}
					break;
				}
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22 || _la==T__23) {
					{
					setState(485);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(488);
				((CommandStepContext)_localctx).out = ids();
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==T__26) {
					{
					setState(489);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(492);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(494);
				variables();
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__34) {
					{
					setState(495);
					match(T__34);
					setState(496);
					value();
					}
				}

				setState(499);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			id();
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(504);
				match(T__16);
				setState(505);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueLiteralContext extends ValueContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ValueLiteralContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterValueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitValueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitValueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueIdContext extends ValueContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ValueIdContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterValueId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitValueId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitValueId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ValueContext {
		public IdContext fun;
		public IdContext domain;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public ApplicationContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				_localctx = new ValueIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				id();
				}
				break;
			case 2:
				_localctx = new ValueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				literal();
				}
				break;
			case 3:
				_localctx = new ApplicationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(510);
					((ApplicationContext)_localctx).fun = id();
					}
				}

				setState(513);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(514);
				((ApplicationContext)_localctx).domain = id();
				setState(515);
				_la = _input.LA(1);
				if ( !(_la==T__32 || _la==T__33) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(516);
					match(T__17);
					setState(517);
					values();
					setState(518);
					match(T__18);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomainpatternContext extends ParserRuleContext {
		public IdContext res;
		public IdContext con;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public DomainpatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainpattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomainpattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomainpattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomainpattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainpatternContext domainpattern() throws RecognitionException {
		DomainpatternContext _localctx = new DomainpatternContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_domainpattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(524);
				((DomainpatternContext)_localctx).res = id();
				setState(525);
				match(T__34);
				}
				break;
			}
			setState(529);
			((DomainpatternContext)_localctx).con = id();
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(530);
				match(T__36);
				setState(531);
				ids();
				setState(532);
				match(T__37);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomainexpContext extends ParserRuleContext {
		public DomainexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainexp; }
	 
		public DomainexpContext() { }
		public void copyFrom(DomainexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomainExpLiteralContext extends DomainexpContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public DomainExpLiteralContext(DomainexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomainExpLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomainExpLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomainExpLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomainExpApplicationContext extends DomainexpContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public DomainExpApplicationContext(DomainexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterDomainExpApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitDomainExpApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitDomainExpApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainexpContext domainexp() throws RecognitionException {
		DomainexpContext _localctx = new DomainexpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_domainexp);
		int _la;
		try {
			setState(544);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LITA:
			case LITB:
			case LITC:
			case LITD:
				_localctx = new DomainExpLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				literal();
				}
				break;
			case ID:
				_localctx = new DomainExpApplicationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				id();
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(538);
					match(T__36);
					setState(539);
					ids();
					setState(540);
					match(T__37);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypesContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			type();
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 105553149820928L) != 0)) {
				{
				{
				setState(549);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 105553149820928L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(550);
				type();
				}
				}
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodiesContext extends ParserRuleContext {
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public BodiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterBodies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitBodies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitBodies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodiesContext bodies() throws RecognitionException {
		BodiesContext _localctx = new BodiesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bodies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			body();
			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__46) {
				{
				{
				setState(557);
				match(T__46);
				setState(558);
				body();
				}
				}
				setState(563);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValuesContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			value();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(565);
				match(T__24);
				setState(566);
				value();
				}
				}
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			variable();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(573);
				match(T__24);
				setState(574);
				variable();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdsContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitIds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			id();
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(581);
				match(T__24);
				setState(582);
				id();
				}
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLANGParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode LITA() { return getToken(SLANGParser.LITA, 0); }
		public TerminalNode LITB() { return getToken(SLANGParser.LITB, 0); }
		public TerminalNode LITC() { return getToken(SLANGParser.LITC, 0); }
		public TerminalNode LITD() { return getToken(SLANGParser.LITD, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLANGListener ) ((SLANGListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLANGVisitor ) return ((SLANGVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8444249301319680L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0251\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u00009\b\u0000\n\u0000\f\u0000<\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0005\u0000E\b\u0000\n"+
		"\u0000\f\u0000H\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"Y\b\u0001\n\u0001\f\u0001\\\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001b\b\u0001\n\u0001\f\u0001e\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001l\b\u0001"+
		"\n\u0001\f\u0001o\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"t\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001~\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u0082\b\u0001\n\u0001\f\u0001\u0085\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u008a\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0094\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0098"+
		"\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u009c\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00a6\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00aa\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00ae\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b3\b\u0001\u0001\u0001\u0003"+
		"\u0001\u00b6\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00ba\b\u0001"+
		"\u0001\u0001\u0003\u0001\u00bd\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00c1\b\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u00c5\b\u0001\n\u0001"+
		"\f\u0001\u00c8\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00cd\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00d7\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00db\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00df\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00e9\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00ed\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00f1\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u00fa\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u00ff\b\u0001\n\u0001\f\u0001\u0102\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0107\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u0110\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0114\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0118\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0121\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0127\b\u0001\u0003\u0001\u0129\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0130\b\u0002\n\u0002\f\u0002"+
		"\u0133\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\u013c\b\u0003\n\u0003\f\u0003\u013f"+
		"\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0143\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0147\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u014d\b\u0005\n\u0005\f\u0005\u0150\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u015e\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0162\b\u0007"+
		"\n\u0007\f\u0007\u0165\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u0171\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u017b"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u0180\b\t\u0001\t\u0001\t\u0003\t"+
		"\u0184\b\t\u0001\n\u0001\n\u0003\n\u0188\b\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u018d\b\n\u0001\n\u0003\n\u0190\b\n\u0001\n\u0001\n\u0003\n\u0194\b"+
		"\n\u0001\n\u0003\n\u0197\b\n\u0001\n\u0001\n\u0003\n\u019b\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u01a0\b\n\u0001\n\u0001\n\u0003\n\u01a4\b\n\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u01a8\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u01b1"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u01b8\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u01bc\b\u000b"+
		"\u0001\f\u0001\f\u0005\f\u01c0\b\f\n\f\f\f\u01c3\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0003\r\u01c9\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u01d3\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u01d8"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u01dd\b\r\u0001\r\u0003\r\u01e0\b"+
		"\r\u0001\r\u0001\r\u0003\r\u01e4\b\r\u0001\r\u0003\r\u01e7\b\r\u0001\r"+
		"\u0001\r\u0003\r\u01eb\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u01f2\b\r\u0001\r\u0001\r\u0003\r\u01f6\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u01fb\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0200\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0209\b\u000f\u0003\u000f"+
		"\u020b\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0210\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u0217\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u021f\b\u0011\u0003\u0011\u0221\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u0228\b\u0013\n\u0013\f\u0013\u022b\t\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u0230\b\u0014\n\u0014\f\u0014\u0233\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u0238\b\u0015\n\u0015\f\u0015\u023b"+
		"\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0240\b\u0016"+
		"\n\u0016\f\u0016\u0243\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u0248\b\u0017\n\u0017\f\u0017\u024b\t\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02\u0000\t\u0001\u0000\r\u000e\u0001\u0000\u000f\u0010\u0001\u0000"+
		"\u0017\u0018\u0001\u0000\u001a\u001b\u0001\u0000\u001c\u001d\u0001\u0000"+
		"\u001f \u0001\u0000!\"\u0002\u0000\u0019\u0019-.\u0001\u000014\u0294\u0000"+
		"4\u0001\u0000\u0000\u0000\u0002\u0128\u0001\u0000\u0000\u0000\u0004\u012a"+
		"\u0001\u0000\u0000\u0000\u0006\u0136\u0001\u0000\u0000\u0000\b\u0146\u0001"+
		"\u0000\u0000\u0000\n\u0148\u0001\u0000\u0000\u0000\f\u0153\u0001\u0000"+
		"\u0000\u0000\u000e\u0159\u0001\u0000\u0000\u0000\u0010\u0168\u0001\u0000"+
		"\u0000\u0000\u0012\u016e\u0001\u0000\u0000\u0000\u0014\u0185\u0001\u0000"+
		"\u0000\u0000\u0016\u01a5\u0001\u0000\u0000\u0000\u0018\u01bd\u0001\u0000"+
		"\u0000\u0000\u001a\u01f5\u0001\u0000\u0000\u0000\u001c\u01f7\u0001\u0000"+
		"\u0000\u0000\u001e\u020a\u0001\u0000\u0000\u0000 \u020f\u0001\u0000\u0000"+
		"\u0000\"\u0220\u0001\u0000\u0000\u0000$\u0222\u0001\u0000\u0000\u0000"+
		"&\u0224\u0001\u0000\u0000\u0000(\u022c\u0001\u0000\u0000\u0000*\u0234"+
		"\u0001\u0000\u0000\u0000,\u023c\u0001\u0000\u0000\u0000.\u0244\u0001\u0000"+
		"\u0000\u00000\u024c\u0001\u0000\u0000\u00002\u024e\u0001\u0000\u0000\u0000"+
		"45\u0005\u0001\u0000\u000056\u00030\u0018\u00006:\u0005\u0002\u0000\u0000"+
		"79\u0005\u0003\u0000\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;F\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000=A\u0003\u0002\u0001\u0000>@\u0005"+
		"\u0003\u0000\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000D=\u0001\u0000\u0000\u0000EH\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\u0004\u0000\u0000"+
		"JK\u0005\u0000\u0000\u0001K\u0001\u0001\u0000\u0000\u0000LM\u0005\u0005"+
		"\u0000\u0000MN\u0005\u0006\u0000\u0000NO\u0005\u0002\u0000\u0000OP\u0005"+
		"\u0007\u0000\u0000PQ\u00032\u0019\u0000QR\u0005\u0004\u0000\u0000R\u0129"+
		"\u0001\u0000\u0000\u0000ST\u0005\b\u0000\u0000T\u0129\u00032\u0019\u0000"+
		"UV\u0005\t\u0000\u0000VZ\u0005\u0002\u0000\u0000WY\u0003\u0004\u0002\u0000"+
		"XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000]\u0129\u0005\u0004\u0000\u0000^_\u0005\n\u0000\u0000_c\u0005"+
		"\u0002\u0000\u0000`b\u0003\n\u0005\u0000a`\u0001\u0000\u0000\u0000be\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000f\u0129\u0005\u0004"+
		"\u0000\u0000gh\u0005\u000b\u0000\u0000hi\u0005\f\u0000\u0000im\u0005\u0002"+
		"\u0000\u0000jl\u0003\u000e\u0007\u0000kj\u0001\u0000\u0000\u0000lo\u0001"+
		"\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"np\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000p\u0129\u0005\u0004"+
		"\u0000\u0000qs\u0007\u0000\u0000\u0000rt\u0003&\u0013\u0000sr\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0007"+
		"\u0001\u0000\u0000vw\u00030\u0018\u0000wx\u0005\u0011\u0000\u0000x}\u0003"+
		"0\u0018\u0000yz\u0005\u0012\u0000\u0000z{\u0003&\u0013\u0000{|\u0005\u0013"+
		"\u0000\u0000|~\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0083\u0005\u0002"+
		"\u0000\u0000\u0080\u0082\u0003\u0012\t\u0000\u0081\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0097\u0005\u0004\u0000"+
		"\u0000\u0087\u0089\u0005\u0014\u0000\u0000\u0088\u008a\u0003.\u0017\u0000"+
		"\u0089\u0088\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0001\u0000\u0000"+
		"\u008c\u008d\u00030\u0018\u0000\u008d\u008e\u0005\u0011\u0000\u0000\u008e"+
		"\u0093\u00030\u0018\u0000\u008f\u0090\u0005\u0012\u0000\u0000\u0090\u0091"+
		"\u0003.\u0017\u0000\u0091\u0092\u0005\u0013\u0000\u0000\u0092\u0094\u0001"+
		"\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0003"+
		"2\u0019\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0087\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u00a9\u0001\u0000"+
		"\u0000\u0000\u0099\u009b\u0005\u0015\u0000\u0000\u009a\u009c\u0003.\u0017"+
		"\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0007\u0001\u0000"+
		"\u0000\u009e\u009f\u00030\u0018\u0000\u009f\u00a0\u0005\u0011\u0000\u0000"+
		"\u00a0\u00a5\u00030\u0018\u0000\u00a1\u00a2\u0005\u0012\u0000\u0000\u00a2"+
		"\u00a3\u0003.\u0017\u0000\u00a3\u00a4\u0005\u0013\u0000\u0000\u00a4\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u00032\u0019\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u0099\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u0129\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ad\u0005\u0016\u0000\u0000\u00ac\u00ae\u0007"+
		"\u0002\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b2\u0003"+
		"0\u0018\u0000\u00b0\u00b1\u0005\u0019\u0000\u0000\u00b1\u00b3\u0003&\u0013"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b6\u0007\u0003\u0000"+
		"\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0007\u0004\u0000"+
		"\u0000\u00b8\u00ba\u00030\u0018\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0007\u0002\u0000\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00c0\u0003&\u0013\u0000\u00bf\u00c1\u0007\u0003\u0000\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c6\u0005\u0002\u0000\u0000\u00c3"+
		"\u00c5\u0003\u0014\n\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c9\u00da\u0005\u0004\u0000\u0000\u00ca\u00cc"+
		"\u0005\u0014\u0000\u0000\u00cb\u00cd\u0003.\u0017\u0000\u00cc\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0007\u0001\u0000\u0000\u00cf\u00d0\u0003"+
		"0\u0018\u0000\u00d0\u00d1\u0005\u0011\u0000\u0000\u00d1\u00d6\u00030\u0018"+
		"\u0000\u00d2\u00d3\u0005\u0012\u0000\u0000\u00d3\u00d4\u0003.\u0017\u0000"+
		"\u00d4\u00d5\u0005\u0013\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u00032\u0019\u0000\u00d9"+
		"\u00db\u0001\u0000\u0000\u0000\u00da\u00ca\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00ec\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u0015\u0000\u0000\u00dd\u00df\u0003.\u0017\u0000\u00de\u00dd"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0007\u0001\u0000\u0000\u00e1\u00e2"+
		"\u00030\u0018\u0000\u00e2\u00e3\u0005\u0011\u0000\u0000\u00e3\u00e8\u0003"+
		"0\u0018\u0000\u00e4\u00e5\u0005\u0012\u0000\u0000\u00e5\u00e6\u0003.\u0017"+
		"\u0000\u00e6\u00e7\u0005\u0013\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00eb\u00032\u0019\u0000"+
		"\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00dc\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u0129\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f0\u0005\u001e\u0000\u0000\u00ef\u00f1\u00030\u0018\u0000\u00f0"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0007\u0005\u0000\u0000\u00f3"+
		"\u00f4\u00030\u0018\u0000\u00f4\u00f5\u0007\u0006\u0000\u0000\u00f5\u00f9"+
		"\u0005\u0011\u0000\u0000\u00f6\u00f7\u0003&\u0013\u0000\u00f7\u00f8\u0007"+
		"\u0004\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0003&\u0013\u0000\u00fc\u0100\u0005\u0002"+
		"\u0000\u0000\u00fd\u00ff\u0003\u0016\u000b\u0000\u00fe\u00fd\u0001\u0000"+
		"\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0103\u0001\u0000"+
		"\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0113\u0005\u0004"+
		"\u0000\u0000\u0104\u0106\u0005\u0014\u0000\u0000\u0105\u0107\u00030\u0018"+
		"\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0007\u0005\u0000"+
		"\u0000\u0109\u010a\u00030\u0018\u0000\u010a\u010f\u0007\u0006\u0000\u0000"+
		"\u010b\u010c\u0005\u0012\u0000\u0000\u010c\u010d\u0003.\u0017\u0000\u010d"+
		"\u010e\u0005\u0013\u0000\u0000\u010e\u0110\u0001\u0000\u0000\u0000\u010f"+
		"\u010b\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u00032\u0019\u0000\u0112\u0114"+
		"\u0001\u0000\u0000\u0000\u0113\u0104\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0001\u0000\u0000\u0000\u0114\u0126\u0001\u0000\u0000\u0000\u0115\u0117"+
		"\u0005\u0015\u0000\u0000\u0116\u0118\u00030\u0018\u0000\u0117\u0116\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0007\u0005\u0000\u0000\u011a\u011b\u0003"+
		"0\u0018\u0000\u011b\u0120\u0007\u0006\u0000\u0000\u011c\u011d\u0005\u0012"+
		"\u0000\u0000\u011d\u011e\u0003.\u0017\u0000\u011e\u011f\u0005\u0013\u0000"+
		"\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u011c\u0001\u0000\u0000"+
		"\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0005#\u0000\u0000\u0123\u0124\u0003.\u0017\u0000\u0124"+
		"\u0125\u00032\u0019\u0000\u0125\u0127\u0001\u0000\u0000\u0000\u0126\u0115"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0129"+
		"\u0001\u0000\u0000\u0000\u0128L\u0001\u0000\u0000\u0000\u0128S\u0001\u0000"+
		"\u0000\u0000\u0128U\u0001\u0000\u0000\u0000\u0128^\u0001\u0000\u0000\u0000"+
		"\u0128g\u0001\u0000\u0000\u0000\u0128q\u0001\u0000\u0000\u0000\u0128\u00ab"+
		"\u0001\u0000\u0000\u0000\u0128\u00ee\u0001\u0000\u0000\u0000\u0129\u0003"+
		"\u0001\u0000\u0000\u0000\u012a\u012b\u00030\u0018\u0000\u012b\u012c\u0005"+
		"#\u0000\u0000\u012c\u0131\u0003\u0006\u0003\u0000\u012d\u012e\u0005$\u0000"+
		"\u0000\u012e\u0130\u0003\u0006\u0003\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000"+
		"\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0134\u0001\u0000\u0000"+
		"\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134\u0135\u0005\u0003\u0000"+
		"\u0000\u0135\u0005\u0001\u0000\u0000\u0000\u0136\u0142\u00030\u0018\u0000"+
		"\u0137\u0138\u0005%\u0000\u0000\u0138\u013d\u0003\b\u0004\u0000\u0139"+
		"\u013a\u0005\u0019\u0000\u0000\u013a\u013c\u0003\b\u0004\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0140"+
		"\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0005&\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0137\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0007\u0001"+
		"\u0000\u0000\u0000\u0144\u0147\u00030\u0018\u0000\u0145\u0147\u00032\u0019"+
		"\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0145\u0001\u0000\u0000"+
		"\u0000\u0147\t\u0001\u0000\u0000\u0000\u0148\u0149\u0005\'\u0000\u0000"+
		"\u0149\u014a\u00030\u0018\u0000\u014a\u014e\u0005\u0002\u0000\u0000\u014b"+
		"\u014d\u0003\f\u0006\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014d\u0150"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f"+
		"\u0001\u0000\u0000\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000\u0151\u0152\u0005\u0004\u0000\u0000\u0152\u000b"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0005(\u0000\u0000\u0154\u0155\u0003"+
		" \u0010\u0000\u0155\u0156\u0007\u0004\u0000\u0000\u0156\u0157\u00032\u0019"+
		"\u0000\u0157\u0158\u0005\u0003\u0000\u0000\u0158\r\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0005\'\u0000\u0000\u015a\u015d\u00030\u0018\u0000\u015b"+
		"\u015c\u0005)\u0000\u0000\u015c\u015e\u00032\u0019\u0000\u015d\u015b\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001"+
		"\u0000\u0000\u0000\u015f\u0163\u0005\u0002\u0000\u0000\u0160\u0162\u0003"+
		"\u0010\b\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0162\u0165\u0001\u0000"+
		"\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000"+
		"\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\u0005\u0004\u0000\u0000\u0167\u000f\u0001\u0000"+
		"\u0000\u0000\u0168\u0169\u0005(\u0000\u0000\u0169\u016a\u00032\u0019\u0000"+
		"\u016a\u016b\u0007\u0004\u0000\u0000\u016b\u016c\u0003\"\u0011\u0000\u016c"+
		"\u016d\u0005\u0003\u0000\u0000\u016d\u0011\u0001\u0000\u0000\u0000\u016e"+
		"\u0170\u0005*\u0000\u0000\u016f\u0171\u0003.\u0017\u0000\u0170\u016f\u0001"+
		"\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0172\u0001"+
		"\u0000\u0000\u0000\u0172\u0173\u0007\u0001\u0000\u0000\u0173\u0174\u0003"+
		" \u0010\u0000\u0174\u0175\u0005\u0011\u0000\u0000\u0175\u017a\u00030\u0018"+
		"\u0000\u0176\u0177\u0005\u0012\u0000\u0000\u0177\u0178\u0003.\u0017\u0000"+
		"\u0178\u0179\u0005\u0013\u0000\u0000\u0179\u017b\u0001\u0000\u0000\u0000"+
		"\u017a\u0176\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000"+
		"\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017f\u0003(\u0014\u0000\u017d"+
		"\u017e\u0005\u0014\u0000\u0000\u017e\u0180\u00032\u0019\u0000\u017f\u017d"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0183"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0005\u0015\u0000\u0000\u0182\u0184"+
		"\u00032\u0019\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u0013\u0001\u0000\u0000\u0000\u0185\u0187\u0005"+
		"+\u0000\u0000\u0186\u0188\u0007\u0002\u0000\u0000\u0187\u0186\u0001\u0000"+
		"\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000"+
		"\u0000\u0000\u0189\u018c\u0003 \u0010\u0000\u018a\u018b\u0005\u0019\u0000"+
		"\u0000\u018b\u018d\u0003.\u0017\u0000\u018c\u018a\u0001\u0000\u0000\u0000"+
		"\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018f\u0001\u0000\u0000\u0000"+
		"\u018e\u0190\u0007\u0003\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000"+
		"\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000"+
		"\u0191\u0193\u0007\u0004\u0000\u0000\u0192\u0194\u00030\u0018\u0000\u0193"+
		"\u0192\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194"+
		"\u0196\u0001\u0000\u0000\u0000\u0195\u0197\u0007\u0002\u0000\u0000\u0196"+
		"\u0195\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000\u0197"+
		"\u0198\u0001\u0000\u0000\u0000\u0198\u019a\u0003.\u0017\u0000\u0199\u019b"+
		"\u0007\u0003\u0000\u0000\u019a\u0199\u0001\u0000\u0000\u0000\u019a\u019b"+
		"\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019f"+
		"\u0003(\u0014\u0000\u019d\u019e\u0005\u0014\u0000\u0000\u019e\u01a0\u0003"+
		"2\u0019\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000"+
		"\u0000\u0000\u01a0\u01a3\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005\u0015"+
		"\u0000\u0000\u01a2\u01a4\u00032\u0019\u0000\u01a3\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u0015\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a7\u0005,\u0000\u0000\u01a6\u01a8\u00030\u0018\u0000\u01a7"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u0007\u0005\u0000\u0000\u01aa"+
		"\u01ab\u0003 \u0010\u0000\u01ab\u01b0\u0007\u0006\u0000\u0000\u01ac\u01ad"+
		"\u0005\u0012\u0000\u0000\u01ad\u01ae\u0003.\u0017\u0000\u01ae\u01af\u0005"+
		"\u0013\u0000\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01ac\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b3\u0005#\u0000\u0000\u01b3\u01b4\u0003.\u0017"+
		"\u0000\u01b4\u01b7\u0003(\u0014\u0000\u01b5\u01b6\u0005\u0014\u0000\u0000"+
		"\u01b6\u01b8\u00032\u0019\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7"+
		"\u01b8\u0001\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9"+
		"\u01ba\u0005\u0015\u0000\u0000\u01ba\u01bc\u00032\u0019\u0000\u01bb\u01b9"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u0017"+
		"\u0001\u0000\u0000\u0000\u01bd\u01c1\u0005\u0002\u0000\u0000\u01be\u01c0"+
		"\u0003\u001a\r\u0000\u01bf\u01be\u0001\u0000\u0000\u0000\u01c0\u01c3\u0001"+
		"\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c4\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c5\u0005\u0004\u0000\u0000\u01c5\u0019\u0001"+
		"\u0000\u0000\u0000\u01c6\u01f6\u00032\u0019\u0000\u01c7\u01c9\u0003.\u0017"+
		"\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000"+
		"\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0007\u0001\u0000"+
		"\u0000\u01cb\u01cc\u00030\u0018\u0000\u01cc\u01cd\u0005\u0011\u0000\u0000"+
		"\u01cd\u01d2\u00030\u0018\u0000\u01ce\u01cf\u0005\u0012\u0000\u0000\u01cf"+
		"\u01d0\u0003.\u0017\u0000\u01d0\u01d1\u0005\u0013\u0000\u0000\u01d1\u01d3"+
		"\u0001\u0000\u0000\u0000\u01d2\u01ce\u0001\u0000\u0000\u0000\u01d2\u01d3"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5"+
		"\u0005\u0003\u0000\u0000\u01d5\u01f6\u0001\u0000\u0000\u0000\u01d6\u01d8"+
		"\u0007\u0002\u0000\u0000\u01d7\u01d6\u0001\u0000\u0000\u0000\u01d7\u01d8"+
		"\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01dc"+
		"\u00030\u0018\u0000\u01da\u01db\u0005\u0019\u0000\u0000\u01db\u01dd\u0003"+
		".\u0017\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000"+
		"\u0000\u0000\u01dd\u01df\u0001\u0000\u0000\u0000\u01de\u01e0\u0007\u0003"+
		"\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e3\u0007\u0004"+
		"\u0000\u0000\u01e2\u01e4\u00030\u0018\u0000\u01e3\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e7\u0007\u0002\u0000\u0000\u01e6\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e8\u01ea\u0003.\u0017\u0000\u01e9\u01eb\u0007\u0003\u0000\u0000"+
		"\u01ea\u01e9\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ed\u0005\u0003\u0000\u0000"+
		"\u01ed\u01f6\u0001\u0000\u0000\u0000\u01ee\u01f1\u0003,\u0016\u0000\u01ef"+
		"\u01f0\u0005#\u0000\u0000\u01f0\u01f2\u0003\u001e\u000f\u0000\u01f1\u01ef"+
		"\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f4\u0005\u0003\u0000\u0000\u01f4\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f5\u01c6\u0001\u0000\u0000\u0000\u01f5\u01c8"+
		"\u0001\u0000\u0000\u0000\u01f5\u01d7\u0001\u0000\u0000\u0000\u01f5\u01ee"+
		"\u0001\u0000\u0000\u0000\u01f6\u001b\u0001\u0000\u0000\u0000\u01f7\u01fa"+
		"\u00030\u0018\u0000\u01f8\u01f9\u0005\u0011\u0000\u0000\u01f9\u01fb\u0003"+
		"$\u0012\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fb\u001d\u0001\u0000\u0000\u0000\u01fc\u020b\u00030\u0018"+
		"\u0000\u01fd\u020b\u00032\u0019\u0000\u01fe\u0200\u00030\u0018\u0000\u01ff"+
		"\u01fe\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		"\u0201\u0001\u0000\u0000\u0000\u0201\u0202\u0007\u0005\u0000\u0000\u0202"+
		"\u0203\u00030\u0018\u0000\u0203\u0208\u0007\u0006\u0000\u0000\u0204\u0205"+
		"\u0005\u0012\u0000\u0000\u0205\u0206\u0003*\u0015\u0000\u0206\u0207\u0005"+
		"\u0013\u0000\u0000\u0207\u0209\u0001\u0000\u0000\u0000\u0208\u0204\u0001"+
		"\u0000\u0000\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u020b\u0001"+
		"\u0000\u0000\u0000\u020a\u01fc\u0001\u0000\u0000\u0000\u020a\u01fd\u0001"+
		"\u0000\u0000\u0000\u020a\u01ff\u0001\u0000\u0000\u0000\u020b\u001f\u0001"+
		"\u0000\u0000\u0000\u020c\u020d\u00030\u0018\u0000\u020d\u020e\u0005#\u0000"+
		"\u0000\u020e\u0210\u0001\u0000\u0000\u0000\u020f\u020c\u0001\u0000\u0000"+
		"\u0000\u020f\u0210\u0001\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000"+
		"\u0000\u0211\u0216\u00030\u0018\u0000\u0212\u0213\u0005%\u0000\u0000\u0213"+
		"\u0214\u0003.\u0017\u0000\u0214\u0215\u0005&\u0000\u0000\u0215\u0217\u0001"+
		"\u0000\u0000\u0000\u0216\u0212\u0001\u0000\u0000\u0000\u0216\u0217\u0001"+
		"\u0000\u0000\u0000\u0217!\u0001\u0000\u0000\u0000\u0218\u0221\u00032\u0019"+
		"\u0000\u0219\u021e\u00030\u0018\u0000\u021a\u021b\u0005%\u0000\u0000\u021b"+
		"\u021c\u0003.\u0017\u0000\u021c\u021d\u0005&\u0000\u0000\u021d\u021f\u0001"+
		"\u0000\u0000\u0000\u021e\u021a\u0001\u0000\u0000\u0000\u021e\u021f\u0001"+
		"\u0000\u0000\u0000\u021f\u0221\u0001\u0000\u0000\u0000\u0220\u0218\u0001"+
		"\u0000\u0000\u0000\u0220\u0219\u0001\u0000\u0000\u0000\u0221#\u0001\u0000"+
		"\u0000\u0000\u0222\u0223\u00032\u0019\u0000\u0223%\u0001\u0000\u0000\u0000"+
		"\u0224\u0229\u0003$\u0012\u0000\u0225\u0226\u0007\u0007\u0000\u0000\u0226"+
		"\u0228\u0003$\u0012\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228\u022b"+
		"\u0001\u0000\u0000\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u0229\u022a"+
		"\u0001\u0000\u0000\u0000\u022a\'\u0001\u0000\u0000\u0000\u022b\u0229\u0001"+
		"\u0000\u0000\u0000\u022c\u0231\u0003\u0018\f\u0000\u022d\u022e\u0005/"+
		"\u0000\u0000\u022e\u0230\u0003\u0018\f\u0000\u022f\u022d\u0001\u0000\u0000"+
		"\u0000\u0230\u0233\u0001\u0000\u0000\u0000\u0231\u022f\u0001\u0000\u0000"+
		"\u0000\u0231\u0232\u0001\u0000\u0000\u0000\u0232)\u0001\u0000\u0000\u0000"+
		"\u0233\u0231\u0001\u0000\u0000\u0000\u0234\u0239\u0003\u001e\u000f\u0000"+
		"\u0235\u0236\u0005\u0019\u0000\u0000\u0236\u0238\u0003\u001e\u000f\u0000"+
		"\u0237\u0235\u0001\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000\u0000"+
		"\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000"+
		"\u023a+\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000\u0000\u0000\u023c"+
		"\u0241\u0003\u001c\u000e\u0000\u023d\u023e\u0005\u0019\u0000\u0000\u023e"+
		"\u0240\u0003\u001c\u000e\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240"+
		"\u0243\u0001\u0000\u0000\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241"+
		"\u0242\u0001\u0000\u0000\u0000\u0242-\u0001\u0000\u0000\u0000\u0243\u0241"+
		"\u0001\u0000\u0000\u0000\u0244\u0249\u00030\u0018\u0000\u0245\u0246\u0005"+
		"\u0019\u0000\u0000\u0246\u0248\u00030\u0018\u0000\u0247\u0245\u0001\u0000"+
		"\u0000\u0000\u0248\u024b\u0001\u0000\u0000\u0000\u0249\u0247\u0001\u0000"+
		"\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a/\u0001\u0000\u0000"+
		"\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024c\u024d\u00050\u0000\u0000"+
		"\u024d1\u0001\u0000\u0000\u0000\u024e\u024f\u0007\b\u0000\u0000\u024f"+
		"3\u0001\u0000\u0000\u0000U:AFZcms}\u0083\u0089\u0093\u0097\u009b\u00a5"+
		"\u00a9\u00ad\u00b2\u00b5\u00b9\u00bc\u00c0\u00c6\u00cc\u00d6\u00da\u00de"+
		"\u00e8\u00ec\u00f0\u00f9\u0100\u0106\u010f\u0113\u0117\u0120\u0126\u0128"+
		"\u0131\u013d\u0142\u0146\u014e\u015d\u0163\u0170\u017a\u017f\u0183\u0187"+
		"\u018c\u018f\u0193\u0196\u019a\u019f\u01a3\u01a7\u01b0\u01b7\u01bb\u01c1"+
		"\u01c8\u01d2\u01d7\u01dc\u01df\u01e3\u01e6\u01ea\u01f1\u01f5\u01fa\u01ff"+
		"\u0208\u020a\u020f\u0216\u021e\u0220\u0229\u0231\u0239\u0241\u0249";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}