package eapli.base.questionnaire.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.base.questionnaire.domain.Question.*;
import eapli.base.questionnaire.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;
import static eapli.base.questionnaire.domain.Question.Question_Type.MULTIPLE_CHOICE;

public class ListQuestion {

    private final QuestionRepository repository = PersistenceContext.repositories().questionRepository();

    public Iterable<Question> listAllQuestions() {
        return this.repository.findAll();
    }

    public Question getQuestionByID(Question_Id questionID) {
        List<Question_Option> options = new ArrayList<>();
        Question question = new Question(new Question_Id(1), new Question_Text("abc"), new Question_Instruction(""),MULTIPLE_CHOICE, MANDATORY, new Question_Condition(""),options);
        for (Question q : listAllQuestions()) {
            if (q.getQuestion_id().getQuestion_id() == questionID.getQuestion_id()) {
                question.setQuestion_id(q.getQuestion_id());
                question.setQuestion(q.getQuestion());
                question.setInstruction(q.getInstruction());
                question.setType(q.getType());
                question.setObligatoriness(q.getObligatoriness());
                question.setCondition(q.getCondition());
                question.setOptions(q.getOptions());
            }
        }
        return question;
    }
}
