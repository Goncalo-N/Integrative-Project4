package eapli.base.questionnaire.domain.Question;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Question_Condition implements ValueObject {

    private String condition;

    protected Question_Condition() {}

    public Question_Condition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Condition that = (Question_Condition) o;
        return Objects.equals(condition, that.condition);
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition);
    }

    @Override
    public String toString() {
        return condition;
    }
}
