package hdl0_compiler.antlr_generated_sources;
// Generated from hw.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class hwParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, BITSTRING=16, 
		WHITESPACE=17, COMMENT=18, COMMENT2=19;
	public static final int
		RULE_start = 0, RULE_defdecl = 1, RULE_updatedecl = 2, RULE_simInp = 3, 
		RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "defdecl", "updatedecl", "simInp", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'hardware:'", "'inputs:'", "'outputs:'", "'latches:'", "'updates:'", 
			"'siminputs:'", "'def:'", "'('", "','", "')'", "' = '", "'/'", "'*'", 
			"'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "BITSTRING", "WHITESPACE", "COMMENT", "COMMENT2"
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
	public String getGrammarFileName() { return "hw.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public hwParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public Token name;
		public Token ID;
		public List<Token> ins = new ArrayList<Token>();
		public List<Token> outs = new ArrayList<Token>();
		public List<Token> ls = new ArrayList<Token>();
		public DefdeclContext defdecl;
		public List<DefdeclContext> defs = new ArrayList<DefdeclContext>();
		public UpdatedeclContext updatedecl;
		public List<UpdatedeclContext> up = new ArrayList<UpdatedeclContext>();
		public SimInpContext simInp;
		public List<SimInpContext> simin = new ArrayList<SimInpContext>();
		public TerminalNode EOF() { return getToken(hwParser.EOF, 0); }
		public List<TerminalNode> ID() { return getTokens(hwParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(hwParser.ID, i);
		}
		public List<DefdeclContext> defdecl() {
			return getRuleContexts(DefdeclContext.class);
		}
		public DefdeclContext defdecl(int i) {
			return getRuleContext(DefdeclContext.class,i);
		}
		public List<UpdatedeclContext> updatedecl() {
			return getRuleContexts(UpdatedeclContext.class);
		}
		public UpdatedeclContext updatedecl(int i) {
			return getRuleContext(UpdatedeclContext.class,i);
		}
		public List<SimInpContext> simInp() {
			return getRuleContexts(SimInpContext.class);
		}
		public SimInpContext simInp(int i) {
			return getRuleContext(SimInpContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(T__0);
			setState(11);
			((StartContext)_localctx).name = match(ID);
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(12);
				match(T__1);
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(13);
					((StartContext)_localctx).ID = match(ID);
					((StartContext)_localctx).ins.add(((StartContext)_localctx).ID);
					}
					}
					setState(16); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
			}

			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(20);
				match(T__2);
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(21);
					((StartContext)_localctx).ID = match(ID);
					((StartContext)_localctx).outs.add(((StartContext)_localctx).ID);
					}
					}
					setState(24); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
			}

			setState(28);
			match(T__3);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				((StartContext)_localctx).ID = match(ID);
				((StartContext)_localctx).ls.add(((StartContext)_localctx).ID);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(34);
				((StartContext)_localctx).defdecl = defdecl();
				((StartContext)_localctx).defs.add(((StartContext)_localctx).defdecl);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(T__4);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				((StartContext)_localctx).updatedecl = updatedecl();
				((StartContext)_localctx).up.add(((StartContext)_localctx).updatedecl);
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(46);
			match(T__5);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				((StartContext)_localctx).simInp = simInp();
				((StartContext)_localctx).simin.add(((StartContext)_localctx).simInp);
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(52);
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
	public static class DefdeclContext extends ParserRuleContext {
		public Token f;
		public Token ID;
		public List<Token> xs = new ArrayList<Token>();
		public ExprContext e;
		public List<TerminalNode> ID() { return getTokens(hwParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(hwParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterDefdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitDefdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitDefdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefdeclContext defdecl() throws RecognitionException {
		DefdeclContext _localctx = new DefdeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__6);
			setState(55);
			((DefdeclContext)_localctx).f = match(ID);
			setState(56);
			match(T__7);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(57);
				((DefdeclContext)_localctx).ID = match(ID);
				((DefdeclContext)_localctx).xs.add(((DefdeclContext)_localctx).ID);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(58);
					match(T__8);
					setState(59);
					((DefdeclContext)_localctx).ID = match(ID);
					((DefdeclContext)_localctx).xs.add(((DefdeclContext)_localctx).ID);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
			match(T__9);
			setState(68);
			match(T__10);
			setState(69);
			((DefdeclContext)_localctx).e = expr(0);
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
	public static class UpdatedeclContext extends ParserRuleContext {
		public Token write;
		public ExprContext e;
		public TerminalNode ID() { return getToken(hwParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UpdatedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updatedecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterUpdatedecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitUpdatedecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitUpdatedecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdatedeclContext updatedecl() throws RecognitionException {
		UpdatedeclContext _localctx = new UpdatedeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_updatedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((UpdatedeclContext)_localctx).write = match(ID);
			setState(72);
			match(T__10);
			setState(73);
			((UpdatedeclContext)_localctx).e = expr(0);
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
	public static class SimInpContext extends ParserRuleContext {
		public Token in;
		public Token str;
		public TerminalNode ID() { return getToken(hwParser.ID, 0); }
		public TerminalNode BITSTRING() { return getToken(hwParser.BITSTRING, 0); }
		public SimInpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simInp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterSimInp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitSimInp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitSimInp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimInpContext simInp() throws RecognitionException {
		SimInpContext _localctx = new SimInpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simInp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((SimInpContext)_localctx).in = match(ID);
			setState(76);
			match(T__10);
			setState(77);
			((SimInpContext)_localctx).str = match(BITSTRING);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UseDefContext extends ExprContext {
		public Token f;
		public ExprContext expr;
		public List<ExprContext> es = new ArrayList<ExprContext>();
		public TerminalNode ID() { return getToken(hwParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UseDefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterUseDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitUseDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitUseDef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SignalContext extends ExprContext {
		public Token x;
		public TerminalNode ID() { return getToken(hwParser.ID, 0); }
		public SignalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitSignal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitSignal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends ExprContext {
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DisjunctionContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DisjunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends ExprContext {
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConjunctionContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConjunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hwListener ) ((hwListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hwVisitor ) return ((hwVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80);
				match(T__11);
				setState(81);
				((NegationContext)_localctx).e = expr(6);
				}
				break;
			case 2:
				{
				_localctx = new UseDefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				((UseDefContext)_localctx).f = match(ID);
				setState(83);
				match(T__7);
				setState(84);
				((UseDefContext)_localctx).expr = expr(0);
				((UseDefContext)_localctx).es.add(((UseDefContext)_localctx).expr);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(85);
					match(T__8);
					setState(86);
					((UseDefContext)_localctx).expr = expr(0);
					((UseDefContext)_localctx).es.add(((UseDefContext)_localctx).expr);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(T__9);
				}
				break;
			case 3:
				{
				_localctx = new SignalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				((SignalContext)_localctx).x = match(ID);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(T__7);
				setState(96);
				((ParenthesisContext)_localctx).e = expr(0);
				setState(97);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new ExprContext(_parentctx, _parentState));
						((ConjunctionContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(103);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__12) {
							{
							setState(102);
							match(T__12);
							}
						}

						setState(105);
						((ConjunctionContext)_localctx).e2 = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new ExprContext(_parentctx, _parentState));
						((DisjunctionContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(107);
						match(T__13);
						setState(108);
						((DisjunctionContext)_localctx).e2 = expr(5);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013s\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u000f\b\u0000\u000b"+
		"\u0000\f\u0000\u0010\u0003\u0000\u0013\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0017\b\u0000\u000b\u0000\f\u0000\u0018\u0003\u0000\u001b"+
		"\b\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001f\b\u0000\u000b\u0000"+
		"\f\u0000 \u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000\'\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000+\b\u0000\u000b\u0000\f\u0000,\u0001\u0000"+
		"\u0001\u0000\u0004\u00001\b\u0000\u000b\u0000\f\u00002\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001=\b\u0001\n\u0001\f\u0001@\t\u0001\u0003\u0001B\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004X\b\u0004\n\u0004\f\u0004[\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004d\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"h\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"n\b\u0004\n\u0004\f\u0004q\t\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000"+
		"\u0002\u0004\u0006\b\u0000\u0000~\u0000\n\u0001\u0000\u0000\u0000\u0002"+
		"6\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006K\u0001"+
		"\u0000\u0000\u0000\bc\u0001\u0000\u0000\u0000\n\u000b\u0005\u0001\u0000"+
		"\u0000\u000b\u0012\u0005\u000f\u0000\u0000\f\u000e\u0005\u0002\u0000\u0000"+
		"\r\u000f\u0005\u000f\u0000\u0000\u000e\r\u0001\u0000\u0000\u0000\u000f"+
		"\u0010\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010"+
		"\u0011\u0001\u0000\u0000\u0000\u0011\u0013\u0001\u0000\u0000\u0000\u0012"+
		"\f\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u001a"+
		"\u0001\u0000\u0000\u0000\u0014\u0016\u0005\u0003\u0000\u0000\u0015\u0017"+
		"\u0005\u000f\u0000\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u0014"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0005\u0004\u0000\u0000\u001d\u001f"+
		"\u0005\u000f\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000"+
		"\u0000!%\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"(*\u0005\u0005\u0000\u0000)+\u0003\u0004\u0002\u0000*)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0005\u0006\u0000\u0000/1\u0003"+
		"\u0006\u0003\u00000/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000045\u0005\u0000\u0000\u00015\u0001\u0001\u0000\u0000\u000067\u0005"+
		"\u0007\u0000\u000078\u0005\u000f\u0000\u00008A\u0005\b\u0000\u00009>\u0005"+
		"\u000f\u0000\u0000:;\u0005\t\u0000\u0000;=\u0005\u000f\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000"+
		"\u0000A9\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CD\u0005\n\u0000\u0000DE\u0005\u000b\u0000\u0000EF\u0003\b"+
		"\u0004\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0005\u000f\u0000\u0000"+
		"HI\u0005\u000b\u0000\u0000IJ\u0003\b\u0004\u0000J\u0005\u0001\u0000\u0000"+
		"\u0000KL\u0005\u000f\u0000\u0000LM\u0005\u000b\u0000\u0000MN\u0005\u0010"+
		"\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0006\u0004\uffff\uffff"+
		"\u0000PQ\u0005\f\u0000\u0000Qd\u0003\b\u0004\u0006RS\u0005\u000f\u0000"+
		"\u0000ST\u0005\b\u0000\u0000TY\u0003\b\u0004\u0000UV\u0005\t\u0000\u0000"+
		"VX\u0003\b\u0004\u0000WU\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\n\u0000\u0000]d\u0001\u0000"+
		"\u0000\u0000^d\u0005\u000f\u0000\u0000_`\u0005\b\u0000\u0000`a\u0003\b"+
		"\u0004\u0000ab\u0005\n\u0000\u0000bd\u0001\u0000\u0000\u0000cO\u0001\u0000"+
		"\u0000\u0000cR\u0001\u0000\u0000\u0000c^\u0001\u0000\u0000\u0000c_\u0001"+
		"\u0000\u0000\u0000do\u0001\u0000\u0000\u0000eg\n\u0005\u0000\u0000fh\u0005"+
		"\r\u0000\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000in\u0003\b\u0004\u0006jk\n\u0004\u0000\u0000kl\u0005"+
		"\u000e\u0000\u0000ln\u0003\b\u0004\u0005me\u0001\u0000\u0000\u0000mj\u0001"+
		"\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\t\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0012\u0018\u001a %,2>AYcgmo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}