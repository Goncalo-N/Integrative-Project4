package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Final_Message implements ValueObject {

    private String final_Message;

    protected Questionnaire_Final_Message() {}

    public Questionnaire_Final_Message(String final_Message) {
        checkFinal_message(final_Message);
        this.final_Message = final_Message;
    }

    private void checkFinal_message(String final_message)
    {
        if (StringUtils.isBlank(final_message))
            throw new AssertionError("Final_message cannot be blank.");
        if (final_message.length() > 30)
            throw new AssertionError("Final_message cannot have more than 30 characters.");
    }

    public String getFinal_Message() {
        return final_Message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Final_Message that = (Questionnaire_Final_Message) o;
        return Objects.equals(final_Message, that.final_Message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(final_Message);
    }

    @Override
    public String toString() {
        return final_Message;
    }
}
