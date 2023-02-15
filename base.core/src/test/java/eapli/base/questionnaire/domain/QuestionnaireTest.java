package eapli.base.questionnaire.domain;

import eapli.base.questionnaire.domain.Question.*;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;
import static eapli.base.questionnaire.domain.Question.Question_Type.FREE_TEXT;
import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.ARE_OF_A_GENDER;

public class QuestionnaireTest {

    @Test(expected = AssertionError.class)
    public void checkIdNotNull() {
        System.out.println("checkIdNotNull");

        //Tests if Id is null
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id(""), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkIdNotMoreThan15() {
        System.out.println("checkIdNotMoreThan15");

        //Tests if Id has more than 15 characters
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("1234567890ABCDEFSAS"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkTitleNotNull() {
        System.out.println("checkTitleNotNull");

        //Tests if Title is null
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title(""), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkTitleNotMoreThan20() {
        System.out.println("checkTitleNotMoreThan20");

        //Tests if Title has more than 20 characters
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title("1234567890ABCasdasdasdDEFSAS"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkFinalMessageNotNull() {
        System.out.println("checkFinalMessageNotNull");

        //Tests if FinalMessage is null
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message(""), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkFinalMessageNotMoreThan30() {
        System.out.println("checkFinalMessageNotMoreThan30");

        //Tests if FinalMessage has more than 30 characters
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("1234567890AASFDASDASD1234213BCDEFSAS"), new Questionnaire_Number_of_days(3),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkNumber_of_days_it_will_be_performedNotNull() {
        System.out.println("checkNumber_of_days_it_will_be_performedNotNull");

        //Tests if Number_of_days_it_will_be_performed is null
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(0),sections);
    }

    @Test(expected = AssertionError.class)
    public void checkNumber_of_days_it_will_be_performedNotNegative() {
        System.out.println("checkNumber_of_days_it_will_be_performedNotNegative");

        //Tests if Number_of_days_it_will_be_performed is negative
        List<Question_Option> options = new ArrayList<>();
        options.add(new Question_Option("Option 1"));

        List<Question> content = new ArrayList<>();
        content.add(new Question(new Question_Id(1),new Question_Text("question"),new Question_Instruction("instruction"),FREE_TEXT,MANDATORY,new Question_Condition("condition"),options));

        List<Section> sections = new ArrayList<>();
        sections.add(new Section(new Section_Id(1),new Section_Title("Section Title"),new Section_Description("Section_description"),MANDATORY,new Section_Condition("Condition"),new Section_Repeatability("Repeatability"),content));

        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("123ABC"), new Questionnaire_Title("Title"), ARE_OF_A_GENDER, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome Message"), new Questionnaire_Final_Message("Final Message"), new Questionnaire_Number_of_days(-2),sections);
    }
}