// Generated from D:/LEI21_22_S4_2DG_01/base.core/src/main/java/eapli/base/questionnaire/domain/LPROG\Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaire.domain.LPROG.questionnaire;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 */
	void enterExtra_info(QuestionnaireParser.Extra_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 */
	void exitExtra_info(QuestionnaireParser.Extra_infoContext ctx);
}