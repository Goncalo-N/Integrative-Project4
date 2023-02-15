package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.framework.actions.Action;

public class AnswerQuestionnaireAction implements Action {

    @Override
    public boolean execute() {
        return new AnswerQuestionnaireUI().show();
    }
}
