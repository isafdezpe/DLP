// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INT_CONSTANT=12, REAL_CONSTANT=13, CHAR_CONSTANT=14, 
		IDENT=15, LINE_COMMENT=16, MULTILINE_COMMENT=17, WHITESPACE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'struct'", "'{'", "'}'", "'int'", "'float'", 
			"'char'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0089\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rO\n\r\r\r\16\rP\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17^\n\17\3\20\3\20\7\20b\n\20"+
		"\f\20\16\20e\13\20\3\21\3\21\3\21\3\21\7\21k\n\21\f\21\16\21n\13\21\3"+
		"\21\5\21q\n\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22y\n\22\f\22\16\22|\13"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u0084\n\23\r\23\16\23\u0085\3\23"+
		"\3\23\4lz\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\3\2\b\3\2\62;\4\2\13\f\17\17\4\2C\\c|\6"+
		"\2\62;C\\aac|\3\3\f\f\5\2\13\f\17\17\"\"\2\u008e\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3"+
		"\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17:\3"+
		"\2\2\2\21>\3\2\2\2\23D\3\2\2\2\25I\3\2\2\2\27K\3\2\2\2\31N\3\2\2\2\33"+
		"R\3\2\2\2\35]\3\2\2\2\37_\3\2\2\2!f\3\2\2\2#t\3\2\2\2%\u0083\3\2\2\2\'"+
		"(\7x\2\2()\7c\2\2)*\7t\2\2*\4\3\2\2\2+,\7<\2\2,\6\3\2\2\2-.\7=\2\2.\b"+
		"\3\2\2\2/\60\7u\2\2\60\61\7v\2\2\61\62\7t\2\2\62\63\7w\2\2\63\64\7e\2"+
		"\2\64\65\7v\2\2\65\n\3\2\2\2\66\67\7}\2\2\67\f\3\2\2\289\7\177\2\29\16"+
		"\3\2\2\2:;\7k\2\2;<\7p\2\2<=\7v\2\2=\20\3\2\2\2>?\7h\2\2?@\7n\2\2@A\7"+
		"q\2\2AB\7c\2\2BC\7v\2\2C\22\3\2\2\2DE\7e\2\2EF\7j\2\2FG\7c\2\2GH\7t\2"+
		"\2H\24\3\2\2\2IJ\7]\2\2J\26\3\2\2\2KL\7_\2\2L\30\3\2\2\2MO\t\2\2\2NM\3"+
		"\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\32\3\2\2\2RS\5\31\r\2ST\7\60\2\2"+
		"TU\5\31\r\2U\34\3\2\2\2VW\7)\2\2WX\n\3\2\2X^\7)\2\2YZ\7)\2\2Z[\7^\2\2"+
		"[\\\7p\2\2\\^\7)\2\2]V\3\2\2\2]Y\3\2\2\2^\36\3\2\2\2_c\t\4\2\2`b\t\5\2"+
		"\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d \3\2\2\2ec\3\2\2\2fg\7\61"+
		"\2\2gh\7\61\2\2hl\3\2\2\2ik\13\2\2\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3"+
		"\2\2\2mp\3\2\2\2nl\3\2\2\2oq\t\6\2\2po\3\2\2\2qr\3\2\2\2rs\b\21\2\2s\""+
		"\3\2\2\2tu\7\61\2\2uv\7,\2\2vz\3\2\2\2wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2"+
		"z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7,\2\2~\177\7\61\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\b\22\2\2\u0081$\3\2\2\2\u0082\u0084\t\7\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\23\2\2\u0088&\3\2\2\2\n\2P]clp"+
		"z\u0085\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}