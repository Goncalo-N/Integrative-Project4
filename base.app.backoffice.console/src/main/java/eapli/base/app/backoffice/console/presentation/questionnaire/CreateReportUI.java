package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.questionnaire.application.CreateReportController;
import eapli.base.questionnaire.application.ListQuestionnaire;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Id;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class CreateReportUI extends AbstractUI {

    private final ListQuestionnaire listQuestionnaire = new ListQuestionnaire();
    private final CreateReportController createReportController = new CreateReportController();

    @Override
    protected boolean doShow() {

        List<Questionnaire> questionnaires = listQuestionnaire.getAllQuestionnaires();

        for(Questionnaire q : questionnaires)
            System.out.println("Id:" + q.getId() + "    Title:" + q.getTitle());

        Questionnaire_Id id = new Questionnaire_Id(Console.readLine("Select the Questionnaire you would like to get a report from:"));

        createReportController.createReport(id);

        return true;
    }

    @Override
    public String headline() {
        return "Create a Report";
    }
}
