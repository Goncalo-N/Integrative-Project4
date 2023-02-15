package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Welcome_Message implements ValueObject {

    private String welcome_message;

    protected Questionnaire_Welcome_Message() {}

    public Questionnaire_Welcome_Message(String welcome_message) {
        this.welcome_message = welcome_message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Welcome_Message that = (Questionnaire_Welcome_Message) o;
        return Objects.equals(welcome_message, that.welcome_message);
    }

    public String getWelcome_message() {
        return welcome_message;
    }

    @Override
    public int hashCode() {
        return Objects.hash(welcome_message);
    }

    @Override
    public String toString() {
        return welcome_message;
    }
}
