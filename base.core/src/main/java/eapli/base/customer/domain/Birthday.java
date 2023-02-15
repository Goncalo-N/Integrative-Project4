package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Birthday implements ValueObject {

    private int day;
    private int month;
    private int year;

    public Birthday() {
    }

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return Objects.equals(day, birthday.day) && Objects.equals(month, birthday.month) && Objects.equals(year, birthday.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}
