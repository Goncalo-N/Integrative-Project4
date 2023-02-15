package eapli.base.questionnaire.domain.Section;

import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Section implements AggregateRoot<String> {

    @EmbeddedId
    private Section_Id section_id;

    @Embedded
    private Section_Title section_title;

    //Optional field
    @Embedded
    private Section_Description section_description;

    private Obligatoriness obligatoriness;

    //Optional field, comes from obligatoriness
    @Embedded
    private Section_Condition condition;

    //Optional field
    @Embedded
    private Section_Repeatability repeatability;

    @ManyToMany(cascade= CascadeType.ALL)
    private List<Question> content;

    protected Section() {
    }

    public Section(Section_Id section_id, Section_Title section_title, Section_Description section_description, Obligatoriness obligatoriness, Section_Condition condition, Section_Repeatability repeatability, List<Question> content) {
        checkObligatoriness(obligatoriness);
        checkContent(content);

        this.section_id = section_id;
        this.section_title = section_title;
        this.section_description = section_description;
        this.obligatoriness = obligatoriness;
        this.condition = condition;
        this.repeatability = repeatability;
        this.content = content;
    }

    private void checkObligatoriness(Obligatoriness obligatoriness)
    {
        if (StringUtils.isBlank(String.valueOf(obligatoriness)))
            throw new IllegalArgumentException("Obligatoriness cannot be blank.");
    }

    private void checkContent(List<Question> content)
    {
        if (StringUtils.isBlank(String.valueOf(content)))
            throw new AssertionError("Content cannot be blank.");
    }

    public Section_Id getSection_id() {return section_id;}

    public void setSection_id(Section_Id section_id) {
        this.section_id = section_id;
    }

    public Section_Title getSection_title() {
        return section_title;
    }

    public void setSection_title(Section_Title section_title) {
        this.section_title = section_title;
    }

    public Section_Description getSection_description() {
        return section_description;
    }

    public void setSection_description(Section_Description section_description) {this.section_description = section_description;}

    public Obligatoriness getObligatoriness() {
        return obligatoriness;
    }

    public void setObligatoriness(Obligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    public Section_Condition getCondition() {
        return condition;
    }

    public void setCondition(Section_Condition condition) {
        this.condition = condition;
    }

    public Section_Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Section_Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    public List<Question> getContent() {
        return content;
    }

    public void setContent(List<Question> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Section " + section_id + '\n' +
                ", title='" + section_title + '\'' +
                ", description='" + section_description + '\'' +
                ", obligatoriness=" + obligatoriness +
                ", condition='" + condition + '\'' +
                ", repeatability='" + repeatability + '\'' +
                ", questions: " + "\n" + content;
    }

    @Override
    public String identity() {
        return String.valueOf(this.section_id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Section)) {
            return false;
        }

        final Section that = (Section) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return section_id == section.section_id && Objects.equals(section_title, section.section_title) && Objects.equals(section_description, section.section_description) && obligatoriness == section.obligatoriness && Objects.equals(condition, section.condition) && Objects.equals(repeatability, section.repeatability) && Objects.equals(content, section.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section_id, section_title, section_description, obligatoriness, condition, repeatability, content);
    }
}
