package eapli.base.questionnaire.domain.LPROG.questionnaire;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor<visitLines> extends QuestionnaireBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<String, Double>();

    @Override
    public Double visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx) {
        int ID = Integer.parseInt(ctx.ID().getText());
        String TITLE = ctx.TITLE().getText();
        String QUESTIONNAIRE_TYPE = ctx.QUESTIONNAIRE_TYPE().getText();
        String QUESTIONNAIRE_TYPE_CONDITION = ctx.QUESTIONNAIRE_TYPE_CONDITION().getText();
        String WELCOME_MESSAGE = ctx.WELCOME_MESSAGE().getText();
        String FINAL_MESSAGE = ctx.FINAL_MESSAGE().getText();
        int NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED = Integer.parseInt(ctx.NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED().getText());

        System.out.println("--------------------Questionnaire " + ID + "--------------------");

        System.out.println(WELCOME_MESSAGE);

        System.out.println(TITLE);

        System.out.println(FINAL_MESSAGE);

        return (double) Integer.parseInt(ctx.ID().getText());
    }

    @Override
    public Double visitSection(QuestionnaireParser.SectionContext ctx) {
        int SECTION_ID = Integer.parseInt(ctx.SECTION_ID().getText());
        String SECTION_TITLE = ctx.SECTION_TITLE().getText();
        String SECTION_DESCRIPTION = ctx.SECTION_DESCRIPTION().getText();
        String OBLIGATORINESS = ctx.OBLIGATORINESS().getText();
        String REPEATABILITY = ctx.REPEATABILITY().getText();

        return Double.valueOf(ctx.SECTION_ID().getText());
    }

    @Override
    public Double visitQuestion(QuestionnaireParser.QuestionContext ctx) {
        int QUESTION_ID = Integer.parseInt(ctx.QUESTION_ID().getText());
        String QUESTION_TEXT = ctx.QUESTION_TEXT().getText();
        String INSTRUCTION = ctx.INSTRUCTION().getText();
        String TYPE = ctx.TYPE().getText();

        return Double.valueOf(ctx.QUESTION_ID().getText());
    }

    @Override
    public Double visitExtra_info(QuestionnaireParser.Extra_infoContext ctx) {
        String INPUT_VALUE = ctx.INPUT_VALUE().getText();

        return Double.valueOf(ctx.INPUT_VALUE().getText());
    }
}
