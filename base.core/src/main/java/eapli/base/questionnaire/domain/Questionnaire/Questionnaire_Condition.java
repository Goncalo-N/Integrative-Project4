package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Condition implements ValueObject {

    private long condition;

    protected Questionnaire_Condition() {}

    public Questionnaire_Condition(long condition) {
        this.condition = condition;
    }

    public long getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Condition that = (Questionnaire_Condition) o;
        return condition == that.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition);
    }

    @Override
    public String toString() {
        return "" + condition;
    }
}
