package eapli.base.questionnaire.domain.Question;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Question_Option implements ValueObject{

    private String option;

    protected Question_Option() {}

    public Question_Option(String option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Option option1 = (Question_Option) o;
        return Objects.equals(option, option1.option);
    }

    public String getOption() {
        return option;
    }

    @Override
    public int hashCode() {
        return Objects.hash(option);
    }

    @Override
    public String toString() {
        return option;
    }
}
