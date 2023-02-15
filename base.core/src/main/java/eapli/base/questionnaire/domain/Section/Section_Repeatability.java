package eapli.base.questionnaire.domain.Section;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Section_Repeatability implements ValueObject {

    private String repeatability;

    protected Section_Repeatability() {}

    public Section_Repeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section_Repeatability that = (Section_Repeatability) o;
        return Objects.equals(repeatability, that.repeatability);
    }

    public String getRepeatability() {
        return repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(repeatability);
    }

    @Override
    public String toString() {
        return repeatability;
    }
}
