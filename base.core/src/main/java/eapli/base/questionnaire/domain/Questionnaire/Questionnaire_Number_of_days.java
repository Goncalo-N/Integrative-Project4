package eapli.base.questionnaire.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Questionnaire_Number_of_days implements ValueObject {

    private int number_of_days_it_will_be_performed;

    protected Questionnaire_Number_of_days() {}

    public Questionnaire_Number_of_days(int number_of_days_it_will_be_performed) {
        checkNumber_of_days_it_will_be_performed(number_of_days_it_will_be_performed);
        this.number_of_days_it_will_be_performed = number_of_days_it_will_be_performed;
    }

    private void checkNumber_of_days_it_will_be_performed(int number_of_days_it_will_be_performed)
    {
        if (number_of_days_it_will_be_performed == 0)
            throw new AssertionError("Number_of_days_it_will_be_performed cannot be blank.");
        if (number_of_days_it_will_be_performed < 0)
            throw new AssertionError("Number_of_days_it_will_be_performed cannot be negative.");
    }

    public int getNumber_of_days_it_will_be_performed() {
        return number_of_days_it_will_be_performed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire_Number_of_days that = (Questionnaire_Number_of_days) o;
        return number_of_days_it_will_be_performed == that.number_of_days_it_will_be_performed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_of_days_it_will_be_performed);
    }

    @Override
    public String toString() {
        return "" + number_of_days_it_will_be_performed;
    }
}
