package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.customer.application.ListCustomer;
import eapli.base.customer.domain.Customer;
import eapli.base.questionnaire.application.*;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Id;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;

import java.util.List;

public class AnswerQuestionnaireUI extends AbstractUI {

    private final ListQuestionnaire listQuestionnaire = new ListQuestionnaire();
    private final ListCustomer listCustomer = new ListCustomer();
    private final ListAnswer listAnswer = new ListAnswer();
    private final CreateAnswerController createAnswerController = new CreateAnswerController();

    @Override
    protected boolean doShow() {

        //List<Questionnaire> questionnaires = listAnswer.getAnswerByCustomer(listCustomer.getCustomerByName(new LoginUI().getUserName()));

        Customer customer = listCustomer.getCustomerByName("antonioSilva");
        List<Questionnaire> questionnaires = listAnswer.getAnswerByCustomer(customer);

        for(Questionnaire q : questionnaires)
            System.out.println("Id:" + q.getId() + "    Title:" + q.getTitle());

        Questionnaire_Id id = new Questionnaire_Id(Console.readLine("Select the Questionnaire you would like to answer:"));

        listQuestionnaire.QuestionnaireEstrutura(id,customer);

        createAnswerController.removeAnswer(listAnswer.getAnswerByCustomerToRemove(customer,id));

        return true;
    }

    @Override
    public String headline() {
        return "Answer a Questionnaire";
    }
}
