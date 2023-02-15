package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Title implements ValueObject {

    private String title;

    protected Questionnaire_Title() {}

    public Questionnaire_Title(String title) {
        checkQuestionnaire_Title(title);
        this.title = title;
    }

    private void checkQuestionnaire_Title(String title)
    {
        if (StringUtils.isBlank(title))
            throw new AssertionError("Questionnaire_Title cannot be blank.");
        if (title.length() > 20)
            throw new AssertionError("Questionnaire_Title cannot have more than 20 characters.");
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Title that = (Questionnaire_Title) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
