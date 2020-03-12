// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;
	import ast.VarDefinition.VarScope;

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
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(73);
				match(T__7);
				setState(74);
				((DefVarsContext)_localctx).IDENT = match(IDENT);
				setState(75);
				match(T__6);
				setState(76);
				((DefVarsContext)_localctx).type = type();
				setState(77);
				match(T__3);
				 _localctx.list.add(new VarDefinition(((DefVarsContext)_localctx).IDENT,((DefVarsContext)_localctx).type.ast,VarScope.LOCAL)); 
				}
				}
				setState(84);
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
			setState(85);
			match(T__7);
			setState(86);
			((DefVarContext)_localctx).IDENT = match(IDENT);
			setState(87);
			match(T__6);
			setState(88);
			((DefVarContext)_localctx).type = type();
			setState(89);
			match(T__3);
			 ((DefVarContext)_localctx).ast =  new VarDefinition(((DefVarContext)_localctx).IDENT,((DefVarContext)_localctx).type.ast,VarScope.GLOBAL); 
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
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				((DefFieldsContext)_localctx).IDENT = match(IDENT);
				setState(93);
				match(T__6);
				setState(94);
				((DefFieldsContext)_localctx).type = type();
				setState(95);
				match(T__3);
				 _localctx.list.add(new StructField(((DefFieldsContext)_localctx).IDENT,((DefFieldsContext)_localctx).type.ast)); 
				}
				}
				setState(100); 
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
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(T__8);
				 ((TypeContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__9);
				 ((TypeContext)_localctx).ast =  new RealType(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(T__10);
				 ((TypeContext)_localctx).ast =  new CharType(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				((TypeContext)_localctx).IDENT = match(IDENT);
				 ((TypeContext)_localctx).ast =  new VarType(((TypeContext)_localctx).IDENT); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(T__11);
				setState(111);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(112);
				match(T__12);
				setState(113);
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
		public List<VarDefinition> list = new ArrayList<VarDefinition>();
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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(118);
				((ParamsContext)_localctx).param = param();
				 _localctx.list.add(((ParamsContext)_localctx).param.ast); 
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(120);
					match(T__13);
					setState(121);
					((ParamsContext)_localctx).param = param();
					 _localctx.list.add(((ParamsContext)_localctx).param.ast); 
					}
					}
					setState(128);
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
		public VarDefinition ast;
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
			setState(131);
			((ParamContext)_localctx).IDENT = match(IDENT);
			setState(132);
			match(T__6);
			setState(133);
			((ParamContext)_localctx).type = type();
			 ((ParamContext)_localctx).ast =  new VarDefinition(((ParamContext)_localctx).IDENT,((ParamContext)_localctx).type.ast,VarScope.LOCAL); 
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
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__24) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(136);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(143);
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
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				expr(0);
				setState(145);
				match(T__14);
				setState(146);
				expr(0);
				setState(147);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Assignment(_localctx.expr(0),_localctx.expr(1)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__15);
				setState(151);
				((SentenceContext)_localctx).expr = expr(0);
				setState(152);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Read(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(T__16);
				setState(156);
				((SentenceContext)_localctx).expr = expr(0);
				setState(157);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Print(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(T__17);
				setState(161);
				((SentenceContext)_localctx).expr = expr(0);
				setState(162);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Printsp(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(T__17);
				setState(166);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Printsp(null); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(T__18);
				setState(169);
				((SentenceContext)_localctx).expr = expr(0);
				setState(170);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(173);
				match(T__18);
				setState(174);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(null); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(176);
				match(T__19);
				setState(177);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(new VoidConstant()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(179);
				match(T__19);
				setState(180);
				((SentenceContext)_localctx).expr = expr(0);
				setState(181);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(184);
				match(T__20);
				setState(185);
				match(T__4);
				setState(186);
				((SentenceContext)_localctx).expr = expr(0);
				setState(187);
				match(T__5);
				setState(188);
				match(T__1);
				setState(189);
				sentences();
				setState(190);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new IfElse(((SentenceContext)_localctx).expr.ast, _localctx.sentences(0).list, null); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(193);
				match(T__20);
				setState(194);
				match(T__4);
				setState(195);
				((SentenceContext)_localctx).expr = expr(0);
				setState(196);
				match(T__5);
				setState(197);
				match(T__1);
				setState(198);
				sentences();
				setState(199);
				match(T__2);
				setState(200);
				match(T__21);
				setState(201);
				match(T__1);
				setState(202);
				sentences();
				setState(203);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new IfElse(((SentenceContext)_localctx).expr.ast, _localctx.sentences(0).list, _localctx.sentences(1).list); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(206);
				match(T__22);
				setState(207);
				match(T__4);
				setState(208);
				((SentenceContext)_localctx).expr = expr(0);
				setState(209);
				match(T__5);
				setState(210);
				match(T__1);
				setState(211);
				((SentenceContext)_localctx).sentences = sentences();
				setState(212);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new While(((SentenceContext)_localctx).expr.ast, ((SentenceContext)_localctx).sentences.list); 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(215);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(216);
				match(T__4);
				setState(217);
				((SentenceContext)_localctx).args = args();
				setState(218);
				match(T__5);
				setState(219);
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
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(225);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 2:
				{
				setState(227);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(229);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 4:
				{
				setState(231);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new CharConstant(((ExprContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 5:
				{
				setState(233);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(234);
				match(T__4);
				setState(235);
				((ExprContext)_localctx).args = args();
				setState(236);
				match(T__5);
				 ((ExprContext)_localctx).ast =  new FuncInvocationExpression(((ExprContext)_localctx).IDENT,((ExprContext)_localctx).args.list); 
				}
				break;
			case 6:
				{
				setState(239);
				match(T__24);
				setState(240);
				match(T__25);
				setState(241);
				((ExprContext)_localctx).type = type();
				setState(242);
				match(T__26);
				setState(243);
				match(T__4);
				setState(244);
				((ExprContext)_localctx).expr = expr(0);
				setState(245);
				match(T__5);
				 ((ExprContext)_localctx).ast =  new CastExpression(((ExprContext)_localctx).type.ast,((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 7:
				{
				setState(248);
				match(T__4);
				setState(249);
				((ExprContext)_localctx).expr = expr(0);
				setState(250);
				match(T__5);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 8:
				{
				setState(253);
				((ExprContext)_localctx).op = match(T__35);
				setState(254);
				((ExprContext)_localctx).expr = expr(3);
				 ((ExprContext)_localctx).ast =  new UnaryExpression(((ExprContext)_localctx).op,((ExprContext)_localctx).expr.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(294);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(260);
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
						setState(261);
						((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(265);
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
						setState(266);
						((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(270);
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
						setState(271);
						((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).ast =  new ComparableExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(275);
						((ExprContext)_localctx).op = match(T__36);
						setState(276);
						((ExprContext)_localctx).expr = expr(3);
						 ((ExprContext)_localctx).ast =  new LogicalExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(280);
						((ExprContext)_localctx).op = match(T__37);
						setState(281);
						((ExprContext)_localctx).expr = expr(2);
						 ((ExprContext)_localctx).ast =  new LogicalExpression(_localctx.expr(0),((ExprContext)_localctx).op,_localctx.expr(1)); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(284);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(285);
						match(T__23);
						setState(286);
						((ExprContext)_localctx).IDENT = match(IDENT);
						 ((ExprContext)_localctx).ast =  new FieldAccessExpression(_localctx.expr(0),((ExprContext)_localctx).IDENT); 
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(289);
						match(T__11);
						setState(290);
						((ExprContext)_localctx).expr = expr(0);
						setState(291);
						match(T__12);
						 ((ExprContext)_localctx).ast =  new IndexExpression(_localctx.expr(0),_localctx.expr(1)); 
						}
						break;
					}
					} 
				}
				setState(298);
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
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__24) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(299);
				((ArgsContext)_localctx).expr = expr(0);
				 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(301);
					match(T__13);
					setState(302);
					((ArgsContext)_localctx).expr = expr(0);
					 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
					}
					}
					setState(309);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u013b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3$\n\3\f\3"+
		"\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5S\n\5\f\5\16\5V\13\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\6\7e\n\7\r\7\16\7f\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bw\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t\177\n\t\f\t\16\t\u0082\13\t\5\t\u0084\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008e\n\13\f\13\16\13\u0091\13\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0104\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0129\n\r\f\r\16"+
		"\r\u012c\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0134\n\16\f\16\16\16"+
		"\u0137\13\16\5\16\u0139\n\16\3\16\2\3\30\17\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\2\5\3\2\36\37\3\2 !\4\2\34\35\"%\2\u0156\2\34\3\2\2\2\4%\3\2\2"+
		"\2\6I\3\2\2\2\bT\3\2\2\2\nW\3\2\2\2\fd\3\2\2\2\16v\3\2\2\2\20\u0083\3"+
		"\2\2\2\22\u0085\3\2\2\2\24\u008f\3\2\2\2\26\u00e0\3\2\2\2\30\u0103\3\2"+
		"\2\2\32\u0138\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2\36\37\7\2\2\3\37\3\3"+
		"\2\2\2 !\5\6\4\2!\"\b\3\1\2\"$\3\2\2\2# \3\2\2\2$\'\3\2\2\2%#\3\2\2\2"+
		"%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2()\5\n\6\2)*\b\4\1\2*J\3\2\2\2+,\7\3\2"+
		"\2,-\7,\2\2-.\7\4\2\2./\5\f\7\2/\60\7\5\2\2\60\61\7\6\2\2\61\62\b\4\1"+
		"\2\62J\3\2\2\2\63\64\7,\2\2\64\65\7\7\2\2\65\66\5\20\t\2\66\67\7\b\2\2"+
		"\678\7\t\2\289\5\16\b\29:\7\4\2\2:;\5\b\5\2;<\5\24\13\2<=\7\5\2\2=>\b"+
		"\4\1\2>J\3\2\2\2?@\7,\2\2@A\7\7\2\2AB\5\20\t\2BC\7\b\2\2CD\7\4\2\2DE\5"+
		"\b\5\2EF\5\24\13\2FG\7\5\2\2GH\b\4\1\2HJ\3\2\2\2I(\3\2\2\2I+\3\2\2\2I"+
		"\63\3\2\2\2I?\3\2\2\2J\7\3\2\2\2KL\7\n\2\2LM\7,\2\2MN\7\t\2\2NO\5\16\b"+
		"\2OP\7\6\2\2PQ\b\5\1\2QS\3\2\2\2RK\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2"+
		"\2U\t\3\2\2\2VT\3\2\2\2WX\7\n\2\2XY\7,\2\2YZ\7\t\2\2Z[\5\16\b\2[\\\7\6"+
		"\2\2\\]\b\6\1\2]\13\3\2\2\2^_\7,\2\2_`\7\t\2\2`a\5\16\b\2ab\7\6\2\2bc"+
		"\b\7\1\2ce\3\2\2\2d^\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r\3\2\2\2"+
		"hi\7\13\2\2iw\b\b\1\2jk\7\f\2\2kw\b\b\1\2lm\7\r\2\2mw\b\b\1\2no\7,\2\2"+
		"ow\b\b\1\2pq\7\16\2\2qr\7)\2\2rs\7\17\2\2st\5\16\b\2tu\b\b\1\2uw\3\2\2"+
		"\2vh\3\2\2\2vj\3\2\2\2vl\3\2\2\2vn\3\2\2\2vp\3\2\2\2w\17\3\2\2\2xy\5\22"+
		"\n\2y\u0080\b\t\1\2z{\7\20\2\2{|\5\22\n\2|}\b\t\1\2}\177\3\2\2\2~z\3\2"+
		"\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083x\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\21\3\2\2\2\u0085\u0086\7,\2\2\u0086\u0087\7\t\2\2\u0087\u0088\5\16\b"+
		"\2\u0088\u0089\b\n\1\2\u0089\23\3\2\2\2\u008a\u008b\5\26\f\2\u008b\u008c"+
		"\b\13\1\2\u008c\u008e\3\2\2\2\u008d\u008a\3\2\2\2\u008e\u0091\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\25\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0093\5\30\r\2\u0093\u0094\7\21\2\2\u0094\u0095\5\30\r"+
		"\2\u0095\u0096\7\6\2\2\u0096\u0097\b\f\1\2\u0097\u00e1\3\2\2\2\u0098\u0099"+
		"\7\22\2\2\u0099\u009a\5\30\r\2\u009a\u009b\7\6\2\2\u009b\u009c\b\f\1\2"+
		"\u009c\u00e1\3\2\2\2\u009d\u009e\7\23\2\2\u009e\u009f\5\30\r\2\u009f\u00a0"+
		"\7\6\2\2\u00a0\u00a1\b\f\1\2\u00a1\u00e1\3\2\2\2\u00a2\u00a3\7\24\2\2"+
		"\u00a3\u00a4\5\30\r\2\u00a4\u00a5\7\6\2\2\u00a5\u00a6\b\f\1\2\u00a6\u00e1"+
		"\3\2\2\2\u00a7\u00a8\7\24\2\2\u00a8\u00a9\7\6\2\2\u00a9\u00e1\b\f\1\2"+
		"\u00aa\u00ab\7\25\2\2\u00ab\u00ac\5\30\r\2\u00ac\u00ad\7\6\2\2\u00ad\u00ae"+
		"\b\f\1\2\u00ae\u00e1\3\2\2\2\u00af\u00b0\7\25\2\2\u00b0\u00b1\7\6\2\2"+
		"\u00b1\u00e1\b\f\1\2\u00b2\u00b3\7\26\2\2\u00b3\u00b4\7\6\2\2\u00b4\u00e1"+
		"\b\f\1\2\u00b5\u00b6\7\26\2\2\u00b6\u00b7\5\30\r\2\u00b7\u00b8\7\6\2\2"+
		"\u00b8\u00b9\b\f\1\2\u00b9\u00e1\3\2\2\2\u00ba\u00bb\7\27\2\2\u00bb\u00bc"+
		"\7\7\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\b\2\2\u00be\u00bf\7\4\2\2"+
		"\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\5\2\2\u00c1\u00c2\b\f\1\2\u00c2\u00e1"+
		"\3\2\2\2\u00c3\u00c4\7\27\2\2\u00c4\u00c5\7\7\2\2\u00c5\u00c6\5\30\r\2"+
		"\u00c6\u00c7\7\b\2\2\u00c7\u00c8\7\4\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00ca"+
		"\7\5\2\2\u00ca\u00cb\7\30\2\2\u00cb\u00cc\7\4\2\2\u00cc\u00cd\5\24\13"+
		"\2\u00cd\u00ce\7\5\2\2\u00ce\u00cf\b\f\1\2\u00cf\u00e1\3\2\2\2\u00d0\u00d1"+
		"\7\31\2\2\u00d1\u00d2\7\7\2\2\u00d2\u00d3\5\30\r\2\u00d3\u00d4\7\b\2\2"+
		"\u00d4\u00d5\7\4\2\2\u00d5\u00d6\5\24\13\2\u00d6\u00d7\7\5\2\2\u00d7\u00d8"+
		"\b\f\1\2\u00d8\u00e1\3\2\2\2\u00d9\u00da\7,\2\2\u00da\u00db\7\7\2\2\u00db"+
		"\u00dc\5\32\16\2\u00dc\u00dd\7\b\2\2\u00dd\u00de\7\6\2\2\u00de\u00df\b"+
		"\f\1\2\u00df\u00e1\3\2\2\2\u00e0\u0092\3\2\2\2\u00e0\u0098\3\2\2\2\u00e0"+
		"\u009d\3\2\2\2\u00e0\u00a2\3\2\2\2\u00e0\u00a7\3\2\2\2\u00e0\u00aa\3\2"+
		"\2\2\u00e0\u00af\3\2\2\2\u00e0\u00b2\3\2\2\2\u00e0\u00b5\3\2\2\2\u00e0"+
		"\u00ba\3\2\2\2\u00e0\u00c3\3\2\2\2\u00e0\u00d0\3\2\2\2\u00e0\u00d9\3\2"+
		"\2\2\u00e1\27\3\2\2\2\u00e2\u00e3\b\r\1\2\u00e3\u00e4\7,\2\2\u00e4\u0104"+
		"\b\r\1\2\u00e5\u00e6\7)\2\2\u00e6\u0104\b\r\1\2\u00e7\u00e8\7*\2\2\u00e8"+
		"\u0104\b\r\1\2\u00e9\u00ea\7+\2\2\u00ea\u0104\b\r\1\2\u00eb\u00ec\7,\2"+
		"\2\u00ec\u00ed\7\7\2\2\u00ed\u00ee\5\32\16\2\u00ee\u00ef\7\b\2\2\u00ef"+
		"\u00f0\b\r\1\2\u00f0\u0104\3\2\2\2\u00f1\u00f2\7\33\2\2\u00f2\u00f3\7"+
		"\34\2\2\u00f3\u00f4\5\16\b\2\u00f4\u00f5\7\35\2\2\u00f5\u00f6\7\7\2\2"+
		"\u00f6\u00f7\5\30\r\2\u00f7\u00f8\7\b\2\2\u00f8\u00f9\b\r\1\2\u00f9\u0104"+
		"\3\2\2\2\u00fa\u00fb\7\7\2\2\u00fb\u00fc\5\30\r\2\u00fc\u00fd\7\b\2\2"+
		"\u00fd\u00fe\b\r\1\2\u00fe\u0104\3\2\2\2\u00ff\u0100\7&\2\2\u0100\u0101"+
		"\5\30\r\5\u0101\u0102\b\r\1\2\u0102\u0104\3\2\2\2\u0103\u00e2\3\2\2\2"+
		"\u0103\u00e5\3\2\2\2\u0103\u00e7\3\2\2\2\u0103\u00e9\3\2\2\2\u0103\u00eb"+
		"\3\2\2\2\u0103\u00f1\3\2\2\2\u0103\u00fa\3\2\2\2\u0103\u00ff\3\2\2\2\u0104"+
		"\u012a\3\2\2\2\u0105\u0106\f\b\2\2\u0106\u0107\t\2\2\2\u0107\u0108\5\30"+
		"\r\t\u0108\u0109\b\r\1\2\u0109\u0129\3\2\2\2\u010a\u010b\f\7\2\2\u010b"+
		"\u010c\t\3\2\2\u010c\u010d\5\30\r\b\u010d\u010e\b\r\1\2\u010e\u0129\3"+
		"\2\2\2\u010f\u0110\f\6\2\2\u0110\u0111\t\4\2\2\u0111\u0112\5\30\r\7\u0112"+
		"\u0113\b\r\1\2\u0113\u0129\3\2\2\2\u0114\u0115\f\4\2\2\u0115\u0116\7\'"+
		"\2\2\u0116\u0117\5\30\r\5\u0117\u0118\b\r\1\2\u0118\u0129\3\2\2\2\u0119"+
		"\u011a\f\3\2\2\u011a\u011b\7(\2\2\u011b\u011c\5\30\r\4\u011c\u011d\b\r"+
		"\1\2\u011d\u0129\3\2\2\2\u011e\u011f\f\f\2\2\u011f\u0120\7\32\2\2\u0120"+
		"\u0121\7,\2\2\u0121\u0129\b\r\1\2\u0122\u0123\f\13\2\2\u0123\u0124\7\16"+
		"\2\2\u0124\u0125\5\30\r\2\u0125\u0126\7\17\2\2\u0126\u0127\b\r\1\2\u0127"+
		"\u0129\3\2\2\2\u0128\u0105\3\2\2\2\u0128\u010a\3\2\2\2\u0128\u010f\3\2"+
		"\2\2\u0128\u0114\3\2\2\2\u0128\u0119\3\2\2\2\u0128\u011e\3\2\2\2\u0128"+
		"\u0122\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\31\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\5\30\r\2\u012e\u0135"+
		"\b\16\1\2\u012f\u0130\7\20\2\2\u0130\u0131\5\30\r\2\u0131\u0132\b\16\1"+
		"\2\u0132\u0134\3\2\2\2\u0133\u012f\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0138"+
		"\u012d\3\2\2\2\u0138\u0139\3\2\2\2\u0139\33\3\2\2\2\20%ITfv\u0080\u0083"+
		"\u008f\u00e0\u0103\u0128\u012a\u0135\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}