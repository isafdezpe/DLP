// Generated from src\parser\Lexicon.g4 by ANTLR 4.7.1
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
public class Lexicon extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_CONSTANT=1, REAL_CONSTANT=2, READ=3, WRITE=4, INT=5, FLOAT=6, IDENT=7, 
		PLUS=8, MINUS=9, EQUAL=10, PCOMA=11, WHITESPACE=12, LINE_COMMENT=13, MULTILINE_COMMENT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT_CONSTANT", "REAL_CONSTANT", "READ", "WRITE", "INT", "FLOAT", "IDENT", 
		"PLUS", "MINUS", "EQUAL", "PCOMA", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'read'", "'write'", "'int'", "'float'", null, "'+'", 
		"'-'", "'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT_CONSTANT", "REAL_CONSTANT", "READ", "WRITE", "INT", "FLOAT", 
		"IDENT", "PLUS", "MINUS", "EQUAL", "PCOMA", "WHITESPACE", "LINE_COMMENT", 
		"MULTILINE_COMMENT"
	};
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


	public Lexicon(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexicon.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2!\n\2\r\2\16\2\"\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b@\n\b\f\b\16\bC\13\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\6\rN\n\r\r\r\16\rO\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\7\16X\n\16\f\16\16\16[\13\16\3\16\5\16^\n\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\7\17h\n\17\f\17\16\17k\13\17\3\17\3\17\3\17\3\17\3\17"+
		"\4Yi\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\3\2\6\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2v"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3 \3\2\2\2\5$\3\2\2\2\7(\3\2\2"+
		"\2\t-\3\2\2\2\13\63\3\2\2\2\r\67\3\2\2\2\17=\3\2\2\2\21D\3\2\2\2\23F\3"+
		"\2\2\2\25H\3\2\2\2\27J\3\2\2\2\31M\3\2\2\2\33S\3\2\2\2\35c\3\2\2\2\37"+
		"!\t\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\4\3\2\2\2$%\5"+
		"\3\2\2%&\7\60\2\2&\'\5\3\2\2\'\6\3\2\2\2()\7t\2\2)*\7g\2\2*+\7c\2\2+,"+
		"\7f\2\2,\b\3\2\2\2-.\7y\2\2./\7t\2\2/\60\7k\2\2\60\61\7v\2\2\61\62\7g"+
		"\2\2\62\n\3\2\2\2\63\64\7k\2\2\64\65\7p\2\2\65\66\7v\2\2\66\f\3\2\2\2"+
		"\678\7h\2\289\7n\2\29:\7q\2\2:;\7c\2\2;<\7v\2\2<\16\3\2\2\2=A\t\3\2\2"+
		">@\t\4\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\20\3\2\2\2CA\3\2\2"+
		"\2DE\7-\2\2E\22\3\2\2\2FG\7/\2\2G\24\3\2\2\2HI\7?\2\2I\26\3\2\2\2JK\7"+
		"=\2\2K\30\3\2\2\2LN\t\5\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ"+
		"\3\2\2\2QR\b\r\2\2R\32\3\2\2\2ST\7\61\2\2TU\7\61\2\2UY\3\2\2\2VX\13\2"+
		"\2\2WV\3\2\2\2X[\3\2\2\2YZ\3\2\2\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\^\7"+
		"\17\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\f\2\2`a\3\2\2\2ab\b\16\2\2"+
		"b\34\3\2\2\2cd\7\61\2\2de\7,\2\2ei\3\2\2\2fh\13\2\2\2gf\3\2\2\2hk\3\2"+
		"\2\2ij\3\2\2\2ig\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7,\2\2mn\7\61\2\2no\3\2"+
		"\2\2op\b\17\2\2p\36\3\2\2\2\t\2\"AOY]i\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}