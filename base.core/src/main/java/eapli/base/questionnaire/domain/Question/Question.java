package eapli.base.questionnaire.domain.Question;

import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Question implements AggregateRoot<String> {

    @EmbeddedId
    private Question_Id question_id;

    @Embedded
    private Question_Text question;

    //Optional field
    @Embedded
    private Question_Instruction instruction;

    private Question_Type type;

    private Obligatoriness obligatoriness;

    //Optional field, comes from obligatoriness
    @Embedded
    private Question_Condition condition;

    @ElementCollection
    private List<Question_Option> options;

    protected Question() {
    }

    public Question(Question_Id question_id, Question_Text question, Question_Instruction instruction, Question_Type type, Obligatoriness obligatoriness, Question_Condition condition, List<Question_Option> options) {
        checkType(type);
        checkObligatoriness(obligatoriness);

        this.question_id = question_id;
        this.question = question;
        this.instruction = instruction;
        this.type = type;
        this.obligatoriness = obligatoriness;
        this.condition = condition;
        this.options = options;
    }

    private void checkType(Question_Type type)
    {
        if (StringUtils.isBlank(String.valueOf(type)))
            throw new IllegalArgumentException("Type cannot be blank.");
    }

    private void checkObligatoriness(Obligatoriness obligatoriness)
    {
        if (StringUtils.isBlank(String.valueOf(obligatoriness)))
            throw new IllegalArgumentException("Obligatoriness cannot be blank.");
    }

    public Question_Id getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Question_Id question_id) {
        this.question_id = question_id;
    }

    public Question_Text getQuestion() {
        return question;
    }

    public void setQuestion(Question_Text question) {
        this.question = question;
    }

    public Question_Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Question_Instruction instruction) {
        this.instruction = instruction;
    }

    public Question_Type getType() {
        return type;
    }

    public void setType(Question_Type type) {
        this.type = type;
    }

    public Obligatoriness getObligatoriness() {
        return obligatoriness;
    }

    public void setObligatoriness(Obligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    public Question_Condition getCondition() {
        return condition;
    }

    public void setCondition(Question_Condition condition) {
        this.condition = condition;
    }

    public List<Question_Option> getOptions() {return options;}

    public void setOptions(List<Question_Option> options) {this.options = options;}

    @Override
    public String toString() {
        List<String> listOptions = new ArrayList<>();

        for (int i = 0; i < options.size(); i++){
            String string2 = "   " + i + ". " + options.get(i) + "\n";
            listOptions.add(string2);
        }

        return question_id + ". " + question + "\n" + listOptions;
    }

    @Override
    public String identity() {
        return String.valueOf(this.question_id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Question)) {
            return false;
        }

        final Question that = (Question) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question_id == question1.question_id && Objects.equals(question, question1.question) && Objects.equals(instruction, question1.instruction) && type == question1.type && obligatoriness == question1.obligatoriness && Objects.equals(condition, question1.condition) && Objects.equals(options, question1.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question_id, question, instruction, type, obligatoriness, condition, options);
    }
}
