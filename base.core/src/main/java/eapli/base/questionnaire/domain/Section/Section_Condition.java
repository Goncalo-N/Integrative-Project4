package eapli.base.questionnaire.domain.Section;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Section_Condition implements ValueObject {

    private String condition;

    protected Section_Condition() {}

    public Section_Condition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section_Condition that = (Section_Condition) o;
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
