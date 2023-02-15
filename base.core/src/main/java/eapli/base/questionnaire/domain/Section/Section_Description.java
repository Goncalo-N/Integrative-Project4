package eapli.base.questionnaire.domain.Section;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Section_Description implements ValueObject {

    private String description;

    protected Section_Description() {}

    public Section_Description(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section_Description that = (Section_Description) o;
        return Objects.equals(description, that.description);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return description;
    }
}
