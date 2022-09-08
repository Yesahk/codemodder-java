package io.pixee.dsl.java;

// Generated from DSL.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MATCH=5, REPLACE=6, WITH=7, COLON=8, EQ=9, 
		INSERT=10, INTO=11, DATA=12, FLOW=13, BEFORE=14, AFTER=15, AND=16, OR=17, 
		WHERE=18, CURLY_BRACKET_OPEN=19, CURLY_BRACKET_CLOSE=20, InsertIntoDataFlow=21, 
		Identifier=22, RuleIdentifier=23, Variable=24, RuleId=25, WHITESPACE=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MATCH", "REPLACE", "WITH", "COLON", 
			"EQ", "INSERT", "INTO", "DATA", "FLOW", "BEFORE", "AFTER", "AND", "OR", 
			"WHERE", "CURLY_BRACKET_OPEN", "CURLY_BRACKET_CLOSE", "InsertIntoDataFlow", 
			"Identifier", "RuleIdentifier", "VALID_ID_START", "VALID_ID_CHAR", "VALID_RULE_ID_CHAR", 
			"Variable", "RuleId", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'rule'", "'('", "')'", "'match'", "'replace'", "'with'", 
			"':'", "'='", "'insert'", "'into'", "'data'", "'flow'", "'before'", "'after'", 
			"'and'", "'or'", "'where'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MATCH", "REPLACE", "WITH", "COLON", "EQ", 
			"INSERT", "INTO", "DATA", "FLOW", "BEFORE", "AFTER", "AND", "OR", "WHERE", 
			"CURLY_BRACKET_OPEN", "CURLY_BRACKET_CLOSE", "InsertIntoDataFlow", "Identifier", 
			"RuleIdentifier", "Variable", "RuleId", "WHITESPACE"
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


	public DSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DSL.g4"; }

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
		"\u0004\u0000\u001a\u00c2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0098\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u009c\b\u0015\n\u0015\f\u0015\u009f\t\u0015"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u00a3\b\u0016\n\u0016\f\u0016\u00a6"+
		"\t\u0016\u0001\u0017\u0003\u0017\u00a9\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u00ad\b\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u00b1\b"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0004\u001c\u00bd"+
		"\b\u001c\u000b\u001c\f\u001c\u00be\u0001\u001c\u0001\u001c\u0000\u0000"+
		"\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00001\u00003\u00005\u00187\u00199\u001a\u0001\u0000\u0003\u0003\u0000"+
		"AZ__az\u0002\u0000--09\u0003\u0000\t\n\r\r  \u00c4\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001"+
		"\u0000\u0000\u0000\u0003=\u0001\u0000\u0000\u0000\u0005B\u0001\u0000\u0000"+
		"\u0000\u0007D\u0001\u0000\u0000\u0000\tF\u0001\u0000\u0000\u0000\u000b"+
		"L\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000\u0000\u000fY\u0001\u0000"+
		"\u0000\u0000\u0011[\u0001\u0000\u0000\u0000\u0013]\u0001\u0000\u0000\u0000"+
		"\u0015d\u0001\u0000\u0000\u0000\u0017i\u0001\u0000\u0000\u0000\u0019n"+
		"\u0001\u0000\u0000\u0000\u001bs\u0001\u0000\u0000\u0000\u001dz\u0001\u0000"+
		"\u0000\u0000\u001f\u0080\u0001\u0000\u0000\u0000!\u0084\u0001\u0000\u0000"+
		"\u0000#\u0087\u0001\u0000\u0000\u0000%\u008d\u0001\u0000\u0000\u0000\'"+
		"\u008f\u0001\u0000\u0000\u0000)\u0091\u0001\u0000\u0000\u0000+\u0099\u0001"+
		"\u0000\u0000\u0000-\u00a0\u0001\u0000\u0000\u0000/\u00a8\u0001\u0000\u0000"+
		"\u00001\u00ac\u0001\u0000\u0000\u00003\u00b0\u0001\u0000\u0000\u00005"+
		"\u00b2\u0001\u0000\u0000\u00007\u00b5\u0001\u0000\u0000\u00009\u00bc\u0001"+
		"\u0000\u0000\u0000;<\u0005.\u0000\u0000<\u0002\u0001\u0000\u0000\u0000"+
		"=>\u0005r\u0000\u0000>?\u0005u\u0000\u0000?@\u0005l\u0000\u0000@A\u0005"+
		"e\u0000\u0000A\u0004\u0001\u0000\u0000\u0000BC\u0005(\u0000\u0000C\u0006"+
		"\u0001\u0000\u0000\u0000DE\u0005)\u0000\u0000E\b\u0001\u0000\u0000\u0000"+
		"FG\u0005m\u0000\u0000GH\u0005a\u0000\u0000HI\u0005t\u0000\u0000IJ\u0005"+
		"c\u0000\u0000JK\u0005h\u0000\u0000K\n\u0001\u0000\u0000\u0000LM\u0005"+
		"r\u0000\u0000MN\u0005e\u0000\u0000NO\u0005p\u0000\u0000OP\u0005l\u0000"+
		"\u0000PQ\u0005a\u0000\u0000QR\u0005c\u0000\u0000RS\u0005e\u0000\u0000"+
		"S\f\u0001\u0000\u0000\u0000TU\u0005w\u0000\u0000UV\u0005i\u0000\u0000"+
		"VW\u0005t\u0000\u0000WX\u0005h\u0000\u0000X\u000e\u0001\u0000\u0000\u0000"+
		"YZ\u0005:\u0000\u0000Z\u0010\u0001\u0000\u0000\u0000[\\\u0005=\u0000\u0000"+
		"\\\u0012\u0001\u0000\u0000\u0000]^\u0005i\u0000\u0000^_\u0005n\u0000\u0000"+
		"_`\u0005s\u0000\u0000`a\u0005e\u0000\u0000ab\u0005r\u0000\u0000bc\u0005"+
		"t\u0000\u0000c\u0014\u0001\u0000\u0000\u0000de\u0005i\u0000\u0000ef\u0005"+
		"n\u0000\u0000fg\u0005t\u0000\u0000gh\u0005o\u0000\u0000h\u0016\u0001\u0000"+
		"\u0000\u0000ij\u0005d\u0000\u0000jk\u0005a\u0000\u0000kl\u0005t\u0000"+
		"\u0000lm\u0005a\u0000\u0000m\u0018\u0001\u0000\u0000\u0000no\u0005f\u0000"+
		"\u0000op\u0005l\u0000\u0000pq\u0005o\u0000\u0000qr\u0005w\u0000\u0000"+
		"r\u001a\u0001\u0000\u0000\u0000st\u0005b\u0000\u0000tu\u0005e\u0000\u0000"+
		"uv\u0005f\u0000\u0000vw\u0005o\u0000\u0000wx\u0005r\u0000\u0000xy\u0005"+
		"e\u0000\u0000y\u001c\u0001\u0000\u0000\u0000z{\u0005a\u0000\u0000{|\u0005"+
		"f\u0000\u0000|}\u0005t\u0000\u0000}~\u0005e\u0000\u0000~\u007f\u0005r"+
		"\u0000\u0000\u007f\u001e\u0001\u0000\u0000\u0000\u0080\u0081\u0005a\u0000"+
		"\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0083\u0005d\u0000\u0000\u0083"+
		" \u0001\u0000\u0000\u0000\u0084\u0085\u0005o\u0000\u0000\u0085\u0086\u0005"+
		"r\u0000\u0000\u0086\"\u0001\u0000\u0000\u0000\u0087\u0088\u0005w\u0000"+
		"\u0000\u0088\u0089\u0005h\u0000\u0000\u0089\u008a\u0005e\u0000\u0000\u008a"+
		"\u008b\u0005r\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c$\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005{\u0000\u0000\u008e&\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005}\u0000\u0000\u0090(\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0003\u0013\t\u0000\u0092\u0093\u0003\u0015\n\u0000\u0093\u0094"+
		"\u0003\u0017\u000b\u0000\u0094\u0097\u0003\u0019\f\u0000\u0095\u0098\u0003"+
		"\u001b\r\u0000\u0096\u0098\u0003\u001d\u000e\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098*\u0001\u0000\u0000"+
		"\u0000\u0099\u009d\u0003/\u0017\u0000\u009a\u009c\u00031\u0018\u0000\u009b"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e"+
		",\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a4"+
		"\u0003/\u0017\u0000\u00a1\u00a3\u00033\u0019\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5.\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a9\u0007\u0000\u0000"+
		"\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a90\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ad\u0003/\u0017\u0000\u00ab\u00ad\u000209\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad2\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b1\u0003/\u0017\u0000\u00af\u00b1\u0007\u0001"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000"+
		"\u0000\u0000\u00b14\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005$\u0000\u0000"+
		"\u00b3\u00b4\u0003+\u0015\u0000\u00b46\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0003-\u0016\u0000\u00b6\u00b7\u0005:\u0000\u0000\u00b7\u00b8\u0003-"+
		"\u0016\u0000\u00b8\u00b9\u0005/\u0000\u0000\u00b9\u00ba\u0003-\u0016\u0000"+
		"\u00ba8\u0001\u0000\u0000\u0000\u00bb\u00bd\u0007\u0002\u0000\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0006\u001c\u0000\u0000\u00c1"+
		":\u0001\u0000\u0000\u0000\b\u0000\u0097\u009d\u00a4\u00a8\u00ac\u00b0"+
		"\u00be\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}