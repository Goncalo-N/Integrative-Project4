package eapli.base.questionnaire.application;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Answer.Answer_Status;
import eapli.base.questionnaire.domain.Question.Question_Id;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.*;
import eapli.base.questionnaire.repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

public class ListAnswer {

    private final AnswerRepository repository = PersistenceContext.repositories().answerRepository();

    public Iterable<Answer> listAllAnswers() {
        return this.repository.findAll();
    }

    public List<Answer> getallAnswersByQuestionnaire(Questionnaire_Id id) {
        List<Answer> answers = new ArrayList<>();

        for (Answer a : listAllAnswers()) {
            if (a.getQuestionnaire().getId().getId().equals(id.getId()) && a.getSection().getSection_id().getSection_id() != 0) {
                Answer answer = new Answer(a.getId(),a.getCustomer(),a.getStatus(),a.getQuestionnaire(),a.getSection(),a.getQuestion(),a.getAnswers());

                answers.add(answer);
            }
        }
        return answers;
    }

    public List<Questionnaire> getAnswerByCustomer(Customer customer) {
        List<Questionnaire> questionnaires = new ArrayList<>();

        for (Answer a : listAllAnswers()) {
            if (a.getCustomer().getId().equals(customer.getId()) && a.getSection().getSection_id().getSection_id() == 0
                    && a.getStatus() == Answer_Status.NOT_ANSWERED) {
                Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id(a.getQuestionnaire().getId().getId()),
                        new Questionnaire_Title(a.getQuestionnaire().getTitle().getTitle()),
                        a.getQuestionnaire().getQuestionnaire_type(),
                        new Questionnaire_Condition(a.getQuestionnaire().getProduct_ageGroup().getCondition()),
                        new Questionnaire_Welcome_Message(a.getQuestionnaire().getWelcome_message().getWelcome_message()),
                        new Questionnaire_Final_Message(a.getQuestionnaire().getFinal_message().getFinal_Message()),
                        new Questionnaire_Number_of_days(a.getQuestionnaire().getNumber_of_days_it_will_be_performed().getNumber_of_days_it_will_be_performed()),
                        a.getQuestionnaire().getSections());

                questionnaires.add(questionnaire);
            }
        }
        return questionnaires;
    }

    public Answer getAnswerByCustomerToRemove(Customer customer, Questionnaire_Id id) {
        Answer answer = new Answer(Answer_Status.NOT_ANSWERED);

        for (Answer a : listAllAnswers()) {

            if (a.getCustomer().getId().equals(customer.getId()) && a.getStatus().equals(Answer_Status.NOT_ANSWERED)
            && a.getQuestionnaire().getId().getId().equals(id.getId())) {
                answer.setId(a.getId());
                answer.setStatus(a.getStatus());
                answer.setCustomer(a.getCustomer());
                answer.setQuestionnaire(a.getQuestionnaire());
                answer.setSection(a.getSection());
                answer.setQuestion(a.getQuestion());
                answer.setAnswers(a.getAnswers());
            }
        }
        return answer;
    }

    public Answer getAnswerBySection(Customer customer, Questionnaire_Id questionnaireId, Section_Id section_id, Question_Id question_id) {

        Answer answer = new Answer(Answer_Status.NOT_ANSWERED);

        for (Answer a : listAllAnswers()) {
            if (a.getCustomer().getId().equals(customer.getId())
                    && a.getQuestionnaire().getId().getId().equals(questionnaireId.getId())
                    && a.getSection().getSection_id().getSection_id() == section_id.getSection_id()
                    && a.getQuestion().getQuestion_id().getQuestion_id() == question_id.getQuestion_id()) {

                answer.setId(a.getId());
                answer.setStatus(a.getStatus());
                answer.setCustomer(a.getCustomer());
                answer.setQuestionnaire(a.getQuestionnaire());
                answer.setSection(a.getSection());
                answer.setQuestion(a.getQuestion());
                answer.setAnswers(a.getAnswers());
                break;
            }
            else{
                answer.setId(0);
            }
        }
        return answer;
    }

    public List<Answer> getAnswerByQuestion(Questionnaire_Id questionnaireId, Section_Id section_id, Question_Id question_id) {

        List<Answer> answers = new ArrayList<>();

        for (Answer a : listAllAnswers()) {
            if (a.getQuestionnaire().getId().getId().equals(questionnaireId.getId())
                    && a.getSection().getSection_id().getSection_id() == section_id.getSection_id()
                    && a.getQuestion().getQuestion_id().getQuestion_id() == question_id.getQuestion_id()) {

                Answer answer = new Answer(a.getId(), a.getCustomer(), a.getStatus(), a.getQuestionnaire(), a.getSection(), a.getQuestion(), a.getAnswers());

                answers.add(answer);
            }
        }
        return answers;
    }
}
