// Generated from D:/LEI21_22_S4_2DG_01/base.core/src/main/java/eapli/base/questionnaire/domain/LPROG\Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaire.domain.LPROG.questionnaire;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TITLE=2, QUESTIONNAIRE_TYPE=3, QUESTIONNAIRE_TYPE_CONDITION=4, WELCOME_MESSAGE=5, 
		FINAL_MESSAGE=6, NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED=7, SECTION_ID=8, 
		SECTION_TITLE=9, SECTION_DESCRIPTION=10, OBLIGATORINESS=11, REPEATABILITY=12, 
		QUESTION_ID=13, QUESTION_TEXT=14, INSTRUCTION=15, TYPE=16, OPTION=17, 
		INPUT_VALUE=18, STRING=19, INT=20, WS=21;
	public static final int
		RULE_questionnaire = 0, RULE_section = 1, RULE_question = 2, RULE_extra_info = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"questionnaire", "section", "question", "extra_info"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "TITLE", "QUESTIONNAIRE_TYPE", "QUESTIONNAIRE_TYPE_CONDITION", 
			"WELCOME_MESSAGE", "FINAL_MESSAGE", "NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED", 
			"SECTION_ID", "SECTION_TITLE", "SECTION_DESCRIPTION", "OBLIGATORINESS", 
			"REPEATABILITY", "QUESTION_ID", "QUESTION_TEXT", "INSTRUCTION", "TYPE", 
			"OPTION", "INPUT_VALUE", "STRING", "INT", "WS"
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
	public String getGrammarFileName() { return "Questionnaire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionnaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QuestionnaireContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public TerminalNode TITLE() { return getToken(QuestionnaireParser.TITLE, 0); }
		public TerminalNode QUESTIONNAIRE_TYPE() { return getToken(QuestionnaireParser.QUESTIONNAIRE_TYPE, 0); }
		public TerminalNode QUESTIONNAIRE_TYPE_CONDITION() { return getToken(QuestionnaireParser.QUESTIONNAIRE_TYPE_CONDITION, 0); }
		public TerminalNode WELCOME_MESSAGE() { return getToken(QuestionnaireParser.WELCOME_MESSAGE, 0); }
		public TerminalNode FINAL_MESSAGE() { return getToken(QuestionnaireParser.FINAL_MESSAGE, 0); }
		public TerminalNode NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED() { return getToken(QuestionnaireParser.NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(ID);
			setState(9);
			match(TITLE);
			setState(10);
			match(QUESTIONNAIRE_TYPE);
			setState(11);
			match(QUESTIONNAIRE_TYPE_CONDITION);
			setState(12);
			match(WELCOME_MESSAGE);
			setState(13);
			match(FINAL_MESSAGE);
			setState(14);
			match(NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED);
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15);
				section();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SECTION_ID );
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SECTION_ID() { return getToken(QuestionnaireParser.SECTION_ID, 0); }
		public TerminalNode SECTION_TITLE() { return getToken(QuestionnaireParser.SECTION_TITLE, 0); }
		public TerminalNode SECTION_DESCRIPTION() { return getToken(QuestionnaireParser.SECTION_DESCRIPTION, 0); }
		public TerminalNode OBLIGATORINESS() { return getToken(QuestionnaireParser.OBLIGATORINESS, 0); }
		public TerminalNode REPEATABILITY() { return getToken(QuestionnaireParser.REPEATABILITY, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(SECTION_ID);
			setState(21);
			match(SECTION_TITLE);
			setState(22);
			match(SECTION_DESCRIPTION);
			setState(23);
			match(OBLIGATORINESS);
			setState(24);
			match(REPEATABILITY);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				question();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION_ID );
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION_ID() { return getToken(QuestionnaireParser.QUESTION_ID, 0); }
		public TerminalNode QUESTION_TEXT() { return getToken(QuestionnaireParser.QUESTION_TEXT, 0); }
		public TerminalNode INSTRUCTION() { return getToken(QuestionnaireParser.INSTRUCTION, 0); }
		public TerminalNode TYPE() { return getToken(QuestionnaireParser.TYPE, 0); }
		public TerminalNode OBLIGATORINESS() { return getToken(QuestionnaireParser.OBLIGATORINESS, 0); }
		public Extra_infoContext extra_info() {
			return getRuleContext(Extra_infoContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(QUESTION_ID);
			setState(31);
			match(QUESTION_TEXT);
			setState(32);
			match(INSTRUCTION);
			setState(33);
			match(TYPE);
			setState(34);
			match(OBLIGATORINESS);
			setState(35);
			extra_info();
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

	public static class Extra_infoContext extends ParserRuleContext {
		public List<TerminalNode> OPTION() { return getTokens(QuestionnaireParser.OPTION); }
		public TerminalNode OPTION(int i) {
			return getToken(QuestionnaireParser.OPTION, i);
		}
		public TerminalNode INPUT_VALUE() { return getToken(QuestionnaireParser.INPUT_VALUE, 0); }
		public Extra_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extra_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExtra_info(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExtra_info(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitExtra_info(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Extra_infoContext extra_info() throws RecognitionException {
		Extra_infoContext _localctx = new Extra_infoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_extra_info);
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37);
					match(OPTION);
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OPTION );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPTION) {
					{
					{
					setState(42);
					match(OPTION);
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				match(INPUT_VALUE);
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

	public static final String _serializedATN =
		"\u0004\u0001\u00154\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001\u001b\b\u0001"+
		"\u000b\u0001\f\u0001\u001c\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003\'\b\u0003"+
		"\u000b\u0003\f\u0003(\u0001\u0003\u0005\u0003,\b\u0003\n\u0003\f\u0003"+
		"/\t\u0003\u0001\u0003\u0003\u00032\b\u0003\u0001\u0003\u0000\u0000\u0004"+
		"\u0000\u0002\u0004\u0006\u0000\u00004\u0000\b\u0001\u0000\u0000\u0000"+
		"\u0002\u0014\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000"+
		"\u00061\u0001\u0000\u0000\u0000\b\t\u0005\u0001\u0000\u0000\t\n\u0005"+
		"\u0002\u0000\u0000\n\u000b\u0005\u0003\u0000\u0000\u000b\f\u0005\u0004"+
		"\u0000\u0000\f\r\u0005\u0005\u0000\u0000\r\u000e\u0005\u0006\u0000\u0000"+
		"\u000e\u0010\u0005\u0007\u0000\u0000\u000f\u0011\u0003\u0002\u0001\u0000"+
		"\u0010\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000"+
		"\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000"+
		"\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0015\u0005\b\u0000\u0000\u0015"+
		"\u0016\u0005\t\u0000\u0000\u0016\u0017\u0005\n\u0000\u0000\u0017\u0018"+
		"\u0005\u000b\u0000\u0000\u0018\u001a\u0005\f\u0000\u0000\u0019\u001b\u0003"+
		"\u0004\u0002\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0005"+
		"\r\u0000\u0000\u001f \u0005\u000e\u0000\u0000 !\u0005\u000f\u0000\u0000"+
		"!\"\u0005\u0010\u0000\u0000\"#\u0005\u000b\u0000\u0000#$\u0003\u0006\u0003"+
		"\u0000$\u0005\u0001\u0000\u0000\u0000%\'\u0005\u0011\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)2\u0001\u0000\u0000\u0000*,\u0005\u0011\u0000"+
		"\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u000002\u0005\u0012\u0000\u00001&\u0001\u0000\u0000\u0000"+
		"1-\u0001\u0000\u0000\u00002\u0007\u0001\u0000\u0000\u0000\u0005\u0012"+
		"\u001c(-1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}