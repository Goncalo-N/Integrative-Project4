// Generated from D:/LEI21_22_S4_2DG_01/base.core/src/main/java/eapli/base/questionnaire/domain/LPROG\Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaire.domain.LPROG.questionnaire;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link QuestionnaireVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class QuestionnaireBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements QuestionnaireVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSection(QuestionnaireParser.SectionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuestion(QuestionnaireParser.QuestionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExtra_info(QuestionnaireParser.Extra_infoContext ctx) { return visitChildren(ctx); }
}