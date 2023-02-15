/*package eapli.base.questionnaire.domain.Answer;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Embeddable
public class Answer_Id implements ValueObject {

    private long answer_id;

    protected Answer_Id() {}

    public Answer_Id(long answer_id) {
        checkAnswer_id(answer_id);
        this.answer_id = answer_id;
    }

    public long getAnswer_id() {
        return answer_id;
    }

    private void checkAnswer_id(long answer_id)
    {
        if (StringUtils.isBlank(String.valueOf(answer_id)))
            throw new AssertionError("Answer_id cannot be blank.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer_Id answer_id1 = (Answer_Id) o;
        return answer_id == answer_id1.answer_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer_id);
    }

    @Override
    public String toString() {return "" + answer_id;}
}*/
