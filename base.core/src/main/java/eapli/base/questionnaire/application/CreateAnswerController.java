package eapli.base.questionnaire.application;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Answer.Answer_Status;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.repository.AnswerRepository;

import java.util.List;

public class CreateAnswerController {

    private final AnswerRepository repository = PersistenceContext.repositories().answerRepository();

    public void createNewAnswer(Customer customer, Answer_Status status, Questionnaire questionnaire, Section section, Question question,List<String> answers) {
        final Answer newAnswer = new Answer(customer,status,questionnaire,section,question,answers);

        this.repository.save(newAnswer);
    }

    public void removeAnswer(Answer answer) {
        final Answer newAnswer = new Answer(answer.getId(),answer.getCustomer(),Answer_Status.ANSWERED,answer.getQuestionnaire(),answer.getSection(),answer.getQuestion(),answer.getAnswers());

        this.repository.save(newAnswer);
    }
}
