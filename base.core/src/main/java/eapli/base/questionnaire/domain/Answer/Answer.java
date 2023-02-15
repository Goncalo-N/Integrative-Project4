package eapli.base.questionnaire.domain.Answer;

import eapli.base.customer.domain.Customer;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Answer implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answer_id;

    @OneToOne
    private Customer customer;

    private Answer_Status status;

    @OneToOne
    private Questionnaire questionnaire;

    @OneToOne
    private Section section;

    @OneToOne
    private Question question;

    @ElementCollection
    private List<String> answers;

    protected Answer() {}

    public Answer(Answer_Status status) {
        this.status = status;
    }

    public Answer(Customer customer, Answer_Status status, Questionnaire questionnaire, Section section, Question question, List<String> answers) {
        checkAnswer_Status(status);

        this.customer = customer;
        this.status = status;
        this.questionnaire = questionnaire;
        this.section = section;
        this.question = question;
        this.answers = answers;
    }

    public Answer(long answer_id, Customer customer, Answer_Status status, Questionnaire questionnaire, Section section, Question question, List<String> answers) {
        checkAnswer_Status(status);

        this.answer_id = answer_id;
        this.customer = customer;
        this.status = status;
        this.questionnaire = questionnaire;
        this.section = section;
        this.question = question;
        this.answers = answers;
    }

    private void checkAnswer_Status(Answer_Status status)
    {
        if (StringUtils.isBlank(String.valueOf(status)))
            throw new AssertionError("Answer_Status cannot be blank.");
    }

    public long getId() {
        return answer_id;
    }

    public void setId(long answer_id) {
        this.answer_id = answer_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Answer_Status getStatus() {
        return status;
    }

    public void setStatus(Answer_Status status) {
        this.status = status;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answer_id, answer.answer_id) && Objects.equals(customer, answer.customer) && status == answer.status && Objects.equals(questionnaire, answer.questionnaire) && Objects.equals(section, answer.section) && Objects.equals(question, answer.question) && Objects.equals(answers, answer.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer_id, customer, status, questionnaire, section, question, answers);
    }

    @Override
    public String identity() {
        return String.valueOf(this.answer_id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Answer)) {
            return false;
        }

        final Answer that = (Answer) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", customer=" + customer +
                ", status=" + status +
                ", questionnaire=" + questionnaire +
                ", section=" + section +
                ", question=" + question +
                ", answers=" + answers +
                '}';
    }
}
