package eapli.base.questionnaire.domain.Answer;

import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Customer;
import eapli.base.questionnaire.domain.Question.*;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.customer.domain.Gender.Male;
import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;
import static eapli.base.questionnaire.domain.Question.Question_Type.FREE_TEXT;
import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.ARE_OF_A_GENDER;

public class AnswerTest {

    /*@Test(expected = AssertionError.class)
    public void checkAnswerStatusNotNull() {
        System.out.println("checkAnswerStatusNotNull");

        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("asd", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

        //Tests if AnswerStatus is null
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Question question = new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options);

        Section section = new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content);

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("abc"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(3),sections);

        List<String> answers = new ArrayList<>();

        Answer answer = new Answer(customer,null,questionnaire,section,question,answers);
    }*/
}