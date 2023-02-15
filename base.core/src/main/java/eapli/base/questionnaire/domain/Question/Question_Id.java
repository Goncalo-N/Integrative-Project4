package eapli.base.questionnaire.domain.Question;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Question_Id implements ValueObject {

    private long question_id;

    protected Question_Id() {}

    public Question_Id(long question_id) {
        checkQuestion_id(question_id);
        this.question_id = question_id;
    }

    private void checkQuestion_id(long question_id)
    {
        if (StringUtils.isBlank(String.valueOf(question_id)))
            throw new AssertionError("Question_id cannot be blank.");
    }

    public long getQuestion_id() {
        return question_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Id that = (Question_Id) o;
        return question_id == that.question_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question_id);
    }

    @Override
    public String toString() {
        return "" + question_id;
    }
}
