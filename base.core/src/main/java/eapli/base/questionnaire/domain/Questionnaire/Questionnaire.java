package eapli.base.questionnaire.domain.Questionnaire;

import eapli.base.questionnaire.domain.Section.Section;
import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Questionnaire implements AggregateRoot<String> {

    @EmbeddedId
    private Questionnaire_Id id;

    @Embedded
    private Questionnaire_Title title;

    private Questionnaire_Type questionnaire_type;

    @Embedded
    private Questionnaire_Condition product_ageGroup;

    //Optional field
    @Embedded
    private Questionnaire_Welcome_Message welcome_message;

    @Embedded
    private Questionnaire_Final_Message final_message;

    @Embedded
    private Questionnaire_Number_of_days number_of_days_it_will_be_performed;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Section> sections;

    protected Questionnaire() {
    }

    public Questionnaire(Questionnaire_Id id, Questionnaire_Title title, Questionnaire_Type questionnaire_type, Questionnaire_Condition product_ageGroup, Questionnaire_Welcome_Message welcome_message, Questionnaire_Final_Message final_message, Questionnaire_Number_of_days number_of_days_it_will_be_performed, List<Section> sections) {
        checkSection(sections);

        this.id = id;
        this.title = title;
        this.questionnaire_type = questionnaire_type;
        this.product_ageGroup = product_ageGroup;
        this.welcome_message = welcome_message;
        this.final_message = final_message;
        this.number_of_days_it_will_be_performed = number_of_days_it_will_be_performed;
        this.sections = sections;
    }

    private void checkSection(List<Section> sections)
    {
        if (StringUtils.isBlank(String.valueOf(sections)))
            throw new AssertionError("Section cannot be blank.");
    }

    public Questionnaire_Id getId() {
        return id;
    }

    public void setId(Questionnaire_Id id) {
        this.id = id;
    }

    public Questionnaire_Title getTitle() {
        return title;
    }

    public void setTitle(Questionnaire_Title title) {
        this.title = title;
    }

    public Questionnaire_Type getQuestionnaire_type() {return questionnaire_type;}

    public void setQuestionnaire_type(Questionnaire_Type questionnaire_type) {this.questionnaire_type = questionnaire_type;}

    public Questionnaire_Condition getProduct_ageGroup() {return product_ageGroup;}

    public void setProduct_ageGroup(Questionnaire_Condition product_ageGroup) {this.product_ageGroup = product_ageGroup;}

    public Questionnaire_Welcome_Message getWelcome_message() {
        return welcome_message;
    }

    public void setWelcome_message(Questionnaire_Welcome_Message welcome_message) {this.welcome_message = welcome_message;}

    public Questionnaire_Final_Message getFinal_message() {
        return final_message;
    }

    public void setFinal_message(Questionnaire_Final_Message final_message) {
        this.final_message = final_message;
    }

    public Questionnaire_Number_of_days getNumber_of_days_it_will_be_performed() {return number_of_days_it_will_be_performed;}

    public void setNumber_of_days_it_will_be_performed(Questionnaire_Number_of_days number_of_days_it_will_be_performed) {this.number_of_days_it_will_be_performed = number_of_days_it_will_be_performed;}

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Questionnaire)) {
            return false;
        }

        final Questionnaire that = (Questionnaire) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire that = (Questionnaire) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && questionnaire_type == that.questionnaire_type && Objects.equals(product_ageGroup, that.product_ageGroup) && Objects.equals(welcome_message, that.welcome_message) && Objects.equals(final_message, that.final_message) && Objects.equals(number_of_days_it_will_be_performed, that.number_of_days_it_will_be_performed) && Objects.equals(sections, that.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, questionnaire_type, product_ageGroup, welcome_message, final_message, number_of_days_it_will_be_performed, sections);
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", title=" + title +
                ", questionnaire_type=" + questionnaire_type +
                ", product_ageGroup=" + product_ageGroup +
                ", welcome_message=" + welcome_message +
                ", final_message=" + final_message +
                ", number_of_days_it_will_be_performed=" + number_of_days_it_will_be_performed +
                ", sections=" + sections +
                '}';
    }
}
