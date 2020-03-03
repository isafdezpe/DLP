// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, IDENT=42, LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, WHITESPACE=45;
	public static final int
		RULE_start = 0, RULE_definitions = 1, RULE_definition = 2, RULE_defVars = 3, 
		RULE_defVar = 4, RULE_defFields = 5, RULE_type = 6, RULE_params = 7, RULE_param = 8, 
		RULE_sentences = 9, RULE_sentence = 10, RULE_expr = 11, RULE_args = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definitions", "definition", "defVars", "defVar", "defFields", 
			"type", "params", "param", "sentences", "sentence", "expr", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'('", "')'", "':'", "'var'", 
			"'int'", "'float'", "'char'", "'['", "']'", "','", "'='", "'read'", "'print'", 
			"'printsp'", "'println'", "'return'", "'if'", "'else'", "'while'", "'.'", 
			"'cast'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "'<='", "'>='", "'=='", 
			"'!='", "'!'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((StartContext)_localctx).definitions = definitions();
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).definitions.list); 
			setState(28);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();;
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(30);
				((DefinitionsContext)_localctx).definition = definition();
				 _localctx.list.add(((DefinitionsContext)_localctx).definition.ast); 
				}
				}
				setState(37);
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

	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public DefVarContext defVar;
		public Token IDENT;
		public DefFieldsContext defFields;
		public ParamsContext params;
		public TypeContext type;
		public DefVarsContext defVars;
		public SentencesContext sentences;
		public DefVarContext defVar() {
			return getRuleContext(DefVarContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DefFieldsContext defFields() {
			return getRuleContext(DefFieldsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVarsContext defVars() {
			return getRuleContext(DefVarsContext.class,0);
		}
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				((DefinitionContext)_localctx).defVar = defVar();
				 ((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).defVar.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(T__0);
				setState(42);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(43);
				match(T__1);
				setState(44);
				((DefinitionContext)_localctx).defFields = defFields();
				setState(45);
				match(T__2);
				setState(46);
				match(T__3);
				 ((DefinitionContext)_localctx).ast =  new StructDefinition(new VarType(((DefinitionContext)_localctx).IDENT),((DefinitionContext)_localctx).defFields.list); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(50);
				match(T__4);
				setState(51);
				((DefinitionContext)_localctx).params = params();
				setState(52);
				match(T__5);
				setState(53);
				match(T__6);
				setState(54);
				((DefinitionContext)_localctx).type = type();
				setState(55);
				match(T__1);
				setState(56);
				((DefinitionContext)_localctx).defVars = defVars();
				setState(57);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(58);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new FunDefinition(((DefinitionContext)_localctx).IDENT,((DefinitionContext)_localctx).params.list,((DefinitionContext)_localctx).type.ast,((DefinitionContext)_localctx).defVars.list,((DefinitionContext)_localctx).sentences.list); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(62);
				match(T__4);
				setState(63);
				((DefinitionContext)_localctx).params = params();
				setState(64);
				match(T__5);
				setState(65);
				match(T__1);
				setState(66);
				((DefinitionContext)_localctx).defVars = defVars();
				setState(67);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(68);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new FunDefinition(((DefinitionContext)_localctx).IDENT,((DefinitionContext)_localctx).params.list,new VoidType(),((DefinitionContext)_localctx).defVars.list,((DefinitionContext)_localctx).sentences.list); 
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

	public static class DefVarsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();;
		public DefVarContext defVar;
		public List<DefVarContext> defVar() {
			return getRuleContexts(DefVarContext.class);
		}
		public DefVarContext defVar(int i) {
			return getRuleContext(DefVarContext.class,i);
		}
		public DefVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVars; }
	}

	public final DefVarsContext defVars() throws RecognitionException {
		DefVarsContext _localctx = new DefVarsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(73);
				((DefVarsContext)_localctx).defVar = defVar();
				 _localctx.list.add(((DefVarsContext)_localctx).defVar.ast); 
				}
				}
				setState(80);
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

	public static class DefVarContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVar; }
	}

	public final DefVarContext defVar() throws RecognitionException {
		DefVarContext _localctx = new DefVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__7);
			setState(82);
			((DefVarContext)_localctx).IDENT = match(IDENT);
			setState(83);
			match(T__6);
			setState(84);
			((DefVarContext)_localctx).type = type();
			setState(85);
			match(T__3);
			 ((DefVarContext)_localctx).ast =  new VarDefinition(((DefVarContext)_localctx).IDENT,((DefVarContext)_localctx).type.ast); 
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

	public static class DefFieldsContext extends ParserRuleContext {
		public List<StructField> list = new ArrayList<StructField>();;
		public Token IDENT;
		public TypeContext type;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public DefFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFields; }
	}

	public final DefFieldsContext defFields() throws RecognitionException {
		DefFieldsContext _localctx = new DefFieldsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				((DefFieldsContext)_localctx).IDENT = match(IDENT);
				setState(89);
				match(T__6);
				setState(90);
				((DefFieldsContext)_localctx).type = type();
				setState(91);
				match(T__3);
				 _localctx.list.add(new StructField(((DefFieldsContext)_localctx).IDENT,((DefFieldsContext)_localctx).type.ast)); 
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token IDENT;
		public Token INT_CONSTANT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(T__8);
				 ((TypeContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__9);
				 ((TypeContext)_localctx).ast =  new RealType(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(T__10);
				 ((TypeContext)_localctx).ast =  new CharType(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				((TypeContext)_localctx).IDENT = match(IDENT);
				 ((TypeContext)_localctx).ast =  new VarType(((TypeContext)_localctx).IDENT); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				match(T__11);
				setState(107);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(108);
				match(T__12);
				setState(109);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(new IntConstant(((TypeContext)_localctx).INT_CONSTANT),((TypeContext)_localctx).type.ast); 
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

	public static class ParamsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public ParamContext param;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(114);
				((ParamsContext)_localctx).param = param();
				 _localctx.list.add(((ParamsContext)_localctx).param.ast); 
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(116);
					match(T__13);
					setState(117);
					((ParamsContext)_localctx).param = param();
					 _localctx.list.add(((ParamsContext)_localctx).param.ast); 
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParamContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((ParamContext)_localctx).IDENT = match(IDENT);
			setState(128);
			match(T__6);
			setState(129);
			((ParamContext)_localctx).type = type();
			 ((ParamContext)_localctx).ast =  new VarDefinition(((ParamContext)_localctx).IDENT,((ParamContext)_localctx).type.ast); 
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

	public static class SentencesContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenceContext sentence;
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
	}

	public final SentencesContext sentences() throws RecognitionException {
		SentencesContext _localctx = new SentencesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__24) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(132);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(139);
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

	public static class SentenceContext extends ParserRuleContext {
		public Sentence ast;
		public ExprContext expr;
		public SentencesContext sentences;
		public Token IDENT;
		public ArgsContext args;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<SentencesContext> sentences() {
			return getRuleContexts(SentencesContext.class);
		}
		public SentencesContext sentences(int i) {
			return getRuleContext(SentencesContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentence);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				expr(0);
				setState(141);
				match(T__14);
				setState(142);
				expr(0);
				setState(143);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Assignment(_localctx.expr(0),_localctx.expr(1)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__15);
				setState(147);
				((SentenceContext)_localctx).expr = expr(0);
				setState(148);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Read(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(T__16);
				setState(152);
				((SentenceContext)_localctx).expr = expr(0);
				setState(153);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Print(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(T__17);
				setState(157);
				((SentenceContext)_localctx).expr = expr(0);
				setState(158);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Printsp(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				match(T__18);
				setState(162);
				((SentenceContext)_localctx).expr = expr(0);
				setState(163);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(T__18);
				setState(167);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(null); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(169);
				match(T__19);
				setState(170);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(null); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(172);
				match(T__19);
				setState(173);
				((SentenceContext)_localctx).expr = expr(0);
				setState(174);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(177);
				match(T__20);
				setState(178);
				match(T__4);
				setState(179);
				((SentenceContext)_localctx).expr = expr(0);
				setState(180);
				match(T__5);
				setState(181);
				match(T__1);
				setState(182);
				sentences();
				setState(183);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new IfElse(((SentenceContext)_localctx).expr.ast, _localctx.sentences(0).list, null); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(186);
				match(T__20);
				setState(187);
				match(T__4);
				setState(188);
				((SentenceContext)_localctx).expr = expr(0);
				setState(189);
				match(T__5);
				setState(190);
				match(T__1);
				setState(191);
				sentences();
				setState(192);
				match(T__2);
				setState(193);
				match(T__21);
				setState(194);
				match(T__1);
				setState(195);
				sentences();
				setState(196);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new IfElse(((SentenceContext)_localctx).expr.ast, _localctx.sentences(0).list, _localctx.sentences(1).list); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(199);
				match(T__22);
				setState(200);
				match(T__4);
				setState(201);
				((SentenceContext)_localctx).expr = expr(0);
				setState(202);
				match(T__5);
				setState(203);
				match(T__1);
				setState(204);
				((SentenceContext)_localctx).sentences = sentences();
				setState(205);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new While(((SentenceContext)_localctx).expr.ast, ((SentenceContext)_localctx).sentences.list); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(208);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(209);
				match(T__4);
				setState(210);
				((SentenceContext)_localctx).args = args();
				setState(211);
				match(T__5);
				setState(212);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new FuncInvocation(((SentenceContext)_localctx).IDENT, ((SentenceContext)_localctx).args.list); 
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

	public static class ExprContext extends ParserRuleContext {
		public Expression ast;
		public Token IDENT;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public ArgsContext args;
		public TypeContext type;
		public ExprContext expr;
		public Token op;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(218);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 2:
				{
				setState(220);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(222);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 4:
				{
				setState(224);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new CharConstant(((ExprContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 5:
				{
				setState(226);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(227);
				match(T__4);
				setState(228);
				((ExprContext)_localctx).args = args();
				setState(229);
				match(T__5);
				 ((ExprContext)_localctx).ast =  new FuncInvocationExpression(((ExprContext)_localctx).IDENT,((ExprContext)_localctx).args.list); 
				}
				break;
			case 6:
				{
				setState(232);
				match(T__24);
				setState(233);
				match(T__25);
				setState(234);
				((ExprContext)_localctx).type = type();
				setState(235);
				match(T__26);
				setState(236);
				match(T__4);
				setState(237);
				((ExprContext)_localctx).expr = expr(0);
				setState(238);
				match(T__5);
				 ((ExprContext)_localctx).ast =  new CastExpression(((ExprContext)_localctx).type.ast,((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 7:
				{
				setState(241);
				match(T__4);
				setState(242);
				((ExprContext)_localctx).expr = expr(0);
				setState(243);
				match(T__5);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 8:
				{
				setState(246);
				((ExprContext)_localctx).op = match(T__35);
				setState(247);
				((ExprContext)_localctx).expr = expr(3);
				 ((ExprContext)_localctx).ast =  new UnaryExpression(((ExprContext)_localctx).op,((ExprContext)_localctx).expr.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(253);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(258);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(263);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).ast =  new ComparableExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(268);
						((ExprContext)_localctx).op = match(T__36);
						setState(269);
						((ExprContext)_localctx).expr = expr(3);
						 ((ExprContext)_localctx).ast =  new LogicalExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(273);
						((ExprContext)_localctx).op = match(T__37);
						setState(274);
						((ExprContext)_localctx).expr = expr(2);
						 ((ExprContext)_localctx).ast =  new LogicalExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(278);
						match(T__23);
						setState(279);
						((ExprContext)_localctx).IDENT = match(IDENT);
						 ((ExprContext)_localctx).ast =  new FieldAccessExpression(((ExprContext)_localctx).expr.ast,((ExprContext)_localctx).IDENT); 
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(282);
						match(T__11);
						setState(283);
						((ExprContext)_localctx).expr = expr(0);
						setState(284);
						match(T__12);
						 ((ExprContext)_localctx).ast =  new IndexExpression(_localctx.expr(0),_localctx.expr(1)); 
						}
						break;
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(292);
			((ArgsContext)_localctx).expr = expr(0);
			 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(294);
				match(T__13);
				setState(295);
				((ArgsContext)_localctx).expr = expr(0);
				 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3$\n\3\f\3"+
		"\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4J\n\4\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\6\7a\n\7\r\7\16\7b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\7\t{\n\t\f\t\16\t~\13\t\5\t\u0080\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\7\13\u008a\n\13\f\13\16\13\u008d\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00da"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00fd\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u0122\n\r\f\r\16\r\u0125\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u012d\n\16\f\16\16\16\u0130\13\16\3\16\2\3\30\17\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\2\5\3\2\36\37\3\2 !\4\2\34\35\"%\2\u014b\2\34"+
		"\3\2\2\2\4%\3\2\2\2\6I\3\2\2\2\bP\3\2\2\2\nS\3\2\2\2\f`\3\2\2\2\16r\3"+
		"\2\2\2\20\177\3\2\2\2\22\u0081\3\2\2\2\24\u008b\3\2\2\2\26\u00d9\3\2\2"+
		"\2\30\u00fc\3\2\2\2\32\u0126\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2\36\37"+
		"\7\2\2\3\37\3\3\2\2\2 !\5\6\4\2!\"\b\3\1\2\"$\3\2\2\2# \3\2\2\2$\'\3\2"+
		"\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2()\5\n\6\2)*\b\4\1\2*J\3"+
		"\2\2\2+,\7\3\2\2,-\7,\2\2-.\7\4\2\2./\5\f\7\2/\60\7\5\2\2\60\61\7\6\2"+
		"\2\61\62\b\4\1\2\62J\3\2\2\2\63\64\7,\2\2\64\65\7\7\2\2\65\66\5\20\t\2"+
		"\66\67\7\b\2\2\678\7\t\2\289\5\16\b\29:\7\4\2\2:;\5\b\5\2;<\5\24\13\2"+
		"<=\7\5\2\2=>\b\4\1\2>J\3\2\2\2?@\7,\2\2@A\7\7\2\2AB\5\20\t\2BC\7\b\2\2"+
		"CD\7\4\2\2DE\5\b\5\2EF\5\24\13\2FG\7\5\2\2GH\b\4\1\2HJ\3\2\2\2I(\3\2\2"+
		"\2I+\3\2\2\2I\63\3\2\2\2I?\3\2\2\2J\7\3\2\2\2KL\5\n\6\2LM\b\5\1\2MO\3"+
		"\2\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\t\3\2\2\2RP\3\2\2\2ST"+
		"\7\n\2\2TU\7,\2\2UV\7\t\2\2VW\5\16\b\2WX\7\6\2\2XY\b\6\1\2Y\13\3\2\2\2"+
		"Z[\7,\2\2[\\\7\t\2\2\\]\5\16\b\2]^\7\6\2\2^_\b\7\1\2_a\3\2\2\2`Z\3\2\2"+
		"\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\r\3\2\2\2de\7\13\2\2es\b\b\1\2fg\7\f"+
		"\2\2gs\b\b\1\2hi\7\r\2\2is\b\b\1\2jk\7,\2\2ks\b\b\1\2lm\7\16\2\2mn\7)"+
		"\2\2no\7\17\2\2op\5\16\b\2pq\b\b\1\2qs\3\2\2\2rd\3\2\2\2rf\3\2\2\2rh\3"+
		"\2\2\2rj\3\2\2\2rl\3\2\2\2s\17\3\2\2\2tu\5\22\n\2u|\b\t\1\2vw\7\20\2\2"+
		"wx\5\22\n\2xy\b\t\1\2y{\3\2\2\2zv\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}\u0080\3\2\2\2~|\3\2\2\2\177t\3\2\2\2\177\u0080\3\2\2\2\u0080\21\3"+
		"\2\2\2\u0081\u0082\7,\2\2\u0082\u0083\7\t\2\2\u0083\u0084\5\16\b\2\u0084"+
		"\u0085\b\n\1\2\u0085\23\3\2\2\2\u0086\u0087\5\26\f\2\u0087\u0088\b\13"+
		"\1\2\u0088\u008a\3\2\2\2\u0089\u0086\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\25\3\2\2\2\u008d\u008b\3\2\2"+
		"\2\u008e\u008f\5\30\r\2\u008f\u0090\7\21\2\2\u0090\u0091\5\30\r\2\u0091"+
		"\u0092\7\6\2\2\u0092\u0093\b\f\1\2\u0093\u00da\3\2\2\2\u0094\u0095\7\22"+
		"\2\2\u0095\u0096\5\30\r\2\u0096\u0097\7\6\2\2\u0097\u0098\b\f\1\2\u0098"+
		"\u00da\3\2\2\2\u0099\u009a\7\23\2\2\u009a\u009b\5\30\r\2\u009b\u009c\7"+
		"\6\2\2\u009c\u009d\b\f\1\2\u009d\u00da\3\2\2\2\u009e\u009f\7\24\2\2\u009f"+
		"\u00a0\5\30\r\2\u00a0\u00a1\7\6\2\2\u00a1\u00a2\b\f\1\2\u00a2\u00da\3"+
		"\2\2\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5\5\30\r\2\u00a5\u00a6\7\6\2\2\u00a6"+
		"\u00a7\b\f\1\2\u00a7\u00da\3\2\2\2\u00a8\u00a9\7\25\2\2\u00a9\u00aa\7"+
		"\6\2\2\u00aa\u00da\b\f\1\2\u00ab\u00ac\7\26\2\2\u00ac\u00ad\7\6\2\2\u00ad"+
		"\u00da\b\f\1\2\u00ae\u00af\7\26\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7"+
		"\6\2\2\u00b1\u00b2\b\f\1\2\u00b2\u00da\3\2\2\2\u00b3\u00b4\7\27\2\2\u00b4"+
		"\u00b5\7\7\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7\b\2\2\u00b7\u00b8\7"+
		"\4\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\7\5\2\2\u00ba\u00bb\b\f\1\2\u00bb"+
		"\u00da\3\2\2\2\u00bc\u00bd\7\27\2\2\u00bd\u00be\7\7\2\2\u00be\u00bf\5"+
		"\30\r\2\u00bf\u00c0\7\b\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c2\5\24\13\2"+
		"\u00c2\u00c3\7\5\2\2\u00c3\u00c4\7\30\2\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6"+
		"\5\24\13\2\u00c6\u00c7\7\5\2\2\u00c7\u00c8\b\f\1\2\u00c8\u00da\3\2\2\2"+
		"\u00c9\u00ca\7\31\2\2\u00ca\u00cb\7\7\2\2\u00cb\u00cc\5\30\r\2\u00cc\u00cd"+
		"\7\b\2\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf\5\24\13\2\u00cf\u00d0\7\5\2\2"+
		"\u00d0\u00d1\b\f\1\2\u00d1\u00da\3\2\2\2\u00d2\u00d3\7,\2\2\u00d3\u00d4"+
		"\7\7\2\2\u00d4\u00d5\5\32\16\2\u00d5\u00d6\7\b\2\2\u00d6\u00d7\7\6\2\2"+
		"\u00d7\u00d8\b\f\1\2\u00d8\u00da\3\2\2\2\u00d9\u008e\3\2\2\2\u00d9\u0094"+
		"\3\2\2\2\u00d9\u0099\3\2\2\2\u00d9\u009e\3\2\2\2\u00d9\u00a3\3\2\2\2\u00d9"+
		"\u00a8\3\2\2\2\u00d9\u00ab\3\2\2\2\u00d9\u00ae\3\2\2\2\u00d9\u00b3\3\2"+
		"\2\2\u00d9\u00bc\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00d2\3\2\2\2\u00da"+
		"\27\3\2\2\2\u00db\u00dc\b\r\1\2\u00dc\u00dd\7,\2\2\u00dd\u00fd\b\r\1\2"+
		"\u00de\u00df\7)\2\2\u00df\u00fd\b\r\1\2\u00e0\u00e1\7*\2\2\u00e1\u00fd"+
		"\b\r\1\2\u00e2\u00e3\7+\2\2\u00e3\u00fd\b\r\1\2\u00e4\u00e5\7,\2\2\u00e5"+
		"\u00e6\7\7\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8\7\b\2\2\u00e8\u00e9\b"+
		"\r\1\2\u00e9\u00fd\3\2\2\2\u00ea\u00eb\7\33\2\2\u00eb\u00ec\7\34\2\2\u00ec"+
		"\u00ed\5\16\b\2\u00ed\u00ee\7\35\2\2\u00ee\u00ef\7\7\2\2\u00ef\u00f0\5"+
		"\30\r\2\u00f0\u00f1\7\b\2\2\u00f1\u00f2\b\r\1\2\u00f2\u00fd\3\2\2\2\u00f3"+
		"\u00f4\7\7\2\2\u00f4\u00f5\5\30\r\2\u00f5\u00f6\7\b\2\2\u00f6\u00f7\b"+
		"\r\1\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9\u00fa\5\30\r\5\u00fa"+
		"\u00fb\b\r\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00db\3\2\2\2\u00fc\u00de\3\2"+
		"\2\2\u00fc\u00e0\3\2\2\2\u00fc\u00e2\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc"+
		"\u00ea\3\2\2\2\u00fc\u00f3\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fd\u0123\3\2"+
		"\2\2\u00fe\u00ff\f\b\2\2\u00ff\u0100\t\2\2\2\u0100\u0101\5\30\r\t\u0101"+
		"\u0102\b\r\1\2\u0102\u0122\3\2\2\2\u0103\u0104\f\7\2\2\u0104\u0105\t\3"+
		"\2\2\u0105\u0106\5\30\r\b\u0106\u0107\b\r\1\2\u0107\u0122\3\2\2\2\u0108"+
		"\u0109\f\6\2\2\u0109\u010a\t\4\2\2\u010a\u010b\5\30\r\7\u010b\u010c\b"+
		"\r\1\2\u010c\u0122\3\2\2\2\u010d\u010e\f\4\2\2\u010e\u010f\7\'\2\2\u010f"+
		"\u0110\5\30\r\5\u0110\u0111\b\r\1\2\u0111\u0122\3\2\2\2\u0112\u0113\f"+
		"\3\2\2\u0113\u0114\7(\2\2\u0114\u0115\5\30\r\4\u0115\u0116\b\r\1\2\u0116"+
		"\u0122\3\2\2\2\u0117\u0118\f\f\2\2\u0118\u0119\7\32\2\2\u0119\u011a\7"+
		",\2\2\u011a\u0122\b\r\1\2\u011b\u011c\f\13\2\2\u011c\u011d\7\16\2\2\u011d"+
		"\u011e\5\30\r\2\u011e\u011f\7\17\2\2\u011f\u0120\b\r\1\2\u0120\u0122\3"+
		"\2\2\2\u0121\u00fe\3\2\2\2\u0121\u0103\3\2\2\2\u0121\u0108\3\2\2\2\u0121"+
		"\u010d\3\2\2\2\u0121\u0112\3\2\2\2\u0121\u0117\3\2\2\2\u0121\u011b\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\31\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\5\30\r\2\u0127\u012e\b\16"+
		"\1\2\u0128\u0129\7\20\2\2\u0129\u012a\5\30\r\2\u012a\u012b\b\16\1\2\u012b"+
		"\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\33\3\2\2\2\u0130\u012e\3\2\2\2\17%IPbr"+
		"|\177\u008b\u00d9\u00fc\u0121\u0123\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}