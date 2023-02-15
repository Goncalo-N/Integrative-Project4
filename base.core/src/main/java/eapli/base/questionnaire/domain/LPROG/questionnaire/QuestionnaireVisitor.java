// Generated from D:/LEI21_22_S4_2DG_01/base.core/src/main/java/eapli/base/questionnaire/domain/LPROG\Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaire.domain.LPROG.questionnaire;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionnaireParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionnaireVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra_info(QuestionnaireParser.Extra_infoContext ctx);
}