package eapli.base.questionnaire.domain.Question;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Question_Text implements ValueObject {

    private String text;

    protected Question_Text() {}

    public Question_Text(String text) {
        checkQuestionText(text);
        this.text = text;
    }

    private void checkQuestionText(String text)
    {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("Question text cannot be blank.");
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Text that = (Question_Text) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
