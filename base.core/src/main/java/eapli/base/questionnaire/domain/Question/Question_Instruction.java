package eapli.base.questionnaire.domain.Question;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Question_Instruction implements ValueObject {

    private String instruction;

    protected Question_Instruction() {}

    public Question_Instruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Instruction that = (Question_Instruction) o;
        return Objects.equals(instruction, that.instruction);
    }

    public String getInstruction() {
        return instruction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instruction);
    }

    @Override
    public String toString() {
        return instruction;
    }
}
