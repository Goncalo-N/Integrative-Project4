package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Id implements ValueObject {

    private String id;

    protected Questionnaire_Id(){}

    public Questionnaire_Id(String id) {
        checkId(id);
        this.id = id;
    }

    private void checkId(String id)
    {
        if (id.equals(""))
            throw new AssertionError("ID cannot be blank.");
        if (id.length() > 15)
            throw new AssertionError("ID cannot have more than 15 characters.");
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Id that = (Questionnaire_Id) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {return id;}
}
