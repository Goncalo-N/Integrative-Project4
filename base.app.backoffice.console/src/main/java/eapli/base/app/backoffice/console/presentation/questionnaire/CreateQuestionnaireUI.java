package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.customer.application.ListCustomer;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Gender;
import eapli.base.product.application.ListProduct;
import eapli.base.questionnaire.application.*;
import eapli.base.questionnaire.domain.Answer.Answer_Status;
import eapli.base.questionnaire.domain.Question.Question_Id;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.domain.Section.Section_Id;
import eapli.base.warehouse.application.ListLine;
import eapli.base.warehouse.application.ListProductOrder;
import eapli.base.warehouse.domain.Line;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.*;

public class CreateQuestionnaireUI extends AbstractUI {

    private final CreateQuestionnaireController controller = new CreateQuestionnaireController();
    private final CreateAnswerController answerController = new CreateAnswerController();
    private final ListSection listSection = new ListSection();
    private final ListQuestion listQuestion = new ListQuestion();

    @Override
    protected boolean doShow() {

        Questionnaire_Id id = new Questionnaire_Id(Console.readLine("Questionnaire Id:"));

        Questionnaire_Title title = new Questionnaire_Title(Console.readLine("Questionnaire Title:"));

        Questionnaire_Type questionnaire_type = Questionnaire_Type.valueOf(Console.readLine("Questionnaire Type: (HAVE_ORDERED_A_GIVEN_PRODUCT/ARE_OF_A_GENDER)"));

        Questionnaire_Condition product_ageGroup = new Questionnaire_Condition(0);

        List<Customer> customers = new ArrayList<>();

        if(questionnaire_type == HAVE_ORDERED_A_GIVEN_PRODUCT){
            ListProduct listProduct = new ListProduct();
            System.out.println(listProduct.listAllProducts());

            product_ageGroup = new Questionnaire_Condition(Console.readLong("This questionnaire will be for customers that have ordered which product?"));

            ListLine listLine = new ListLine();
            List<Line> lines = listLine.getLinesByProduct(product_ageGroup.getCondition());

            ListProductOrder listProductOrder = new ListProductOrder();
            customers = listProductOrder.getCustomersByLines(lines);
        }
        else if (questionnaire_type == ARE_OF_A_GENDER){
            List<String> listAgeGroup = new ArrayList<>();
            listAgeGroup.add("1. Male");
            listAgeGroup.add("2. Female");
            System.out.println(listAgeGroup);

            product_ageGroup = new Questionnaire_Condition(Console.readInteger("This questionnaire will be for customers that belong to which age group?"));

            Gender gender;
            if(product_ageGroup.getCondition() == 1){
                gender = Gender.Male;
            }
            else{
                gender = Gender.Female;
            }

            ListCustomer listCustomer = new ListCustomer();
            customers = listCustomer.getCustomersByGender(gender);
        }

        //Start Welcome Message
        Questionnaire_Welcome_Message welcome_message = new Questionnaire_Welcome_Message("");

        String option = Console.readLine("Would you like to have a Welcome Message in your questionnaire? (Y/N)");
        while (!option.equals("Y") && !option.equals("N"))
            option = Console.readLine("Wrong answer! Would you like to have a Welcome Message in your questionnaire? (Y/N)");

        if(option.equals("Y"))
            welcome_message = new Questionnaire_Welcome_Message(Console.readLine("Questionnaire Welcome Message:"));
        //End Welcome Message

        //Start Sections
        List<Section> sections = new ArrayList<>();

        Section section1;
        section1 = listSection.getSectionByID(new Section_Id(1));
        System.out.println("Section 1 was added to the questionnaire due to being mandatory: ");
        System.out.println(section1);
        sections.add(section1);

        Section section2;
        section2 = listSection.getSectionByID(new Section_Id(2));
        System.out.println(section2);
        option = Console.readLine("Would you like to add the section " + 2 + " to the questionnaire? (Y/N)");

        while (!option.equals("Y") && !option.equals("N"))
            option = Console.readLine("Would you like to add the section " + 2 + " to the questionnaire? (Y/N)");

        if(option.equals("Y")){
            Section section3 ;
            section3 = listSection.getSectionByID(new Section_Id(3));
            Section section4 ;
            section4 = listSection.getSectionByID(new Section_Id(4));
            Section section5;
            section5 = listSection.getSectionByID(new Section_Id(5));
            Section section6;
            section6 = listSection.getSectionByID(new Section_Id(6));
            sections.add(section2);
            sections.add(section3);
            sections.add(section4);
            sections.add(section5);
            sections.add(section6);

            System.out.println("Section 3 was added to the questionnaire due to selecting section 2.");
            System.out.println(section3);
            System.out.println("Section 4 was added to the questionnaire due to selecting section 2.");
            System.out.println(section4);
            System.out.println("Section 5 was added to the questionnaire due to selecting section 2.");
            System.out.println(section5);
            System.out.println("Section 6 was added to the questionnaire due to selecting section 2.");
            System.out.println(section6);
        }

        for(int i = 7; i < 9; i++){
            Section section;
            section = listSection.getSectionByID(new Section_Id(i));
            System.out.println(section);
            option = Console.readLine("Would you like to add the section " + i + " to the questionnaire? (Y/N)");

            while (!option.equals("Y") && !option.equals("N"))
                option = Console.readLine("Would you like to add the section " + i + " to the questionnaire? (Y/N)");

            if(option.equals("Y")){
                sections.add(section);
            }
        }

        //End Sections

        Questionnaire_Final_Message final_message = new Questionnaire_Final_Message(Console.readLine("Questionnaire Final Message:"));

        Questionnaire_Number_of_days number_of_days_it_will_be_performed = new Questionnaire_Number_of_days(Console.readInteger("Questionnaire Number of days it will be performed:"));

        try {
            this.controller.ExportQuestionnaireToFile(id,title,questionnaire_type,product_ageGroup,welcome_message,final_message,number_of_days_it_will_be_performed,sections);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.controller.createNewQuestionnaire(id,title,questionnaire_type,product_ageGroup,welcome_message,final_message,number_of_days_it_will_be_performed,sections);

            for(Customer c : customers){
                List<String> answers = new ArrayList<>();
                answerController.createNewAnswer(c,Answer_Status.NOT_ANSWERED,new Questionnaire(id,title,questionnaire_type,product_ageGroup,welcome_message,final_message,number_of_days_it_will_be_performed,sections),listSection.getSectionByID(new Section_Id(0)),listQuestion.getQuestionByID(new Question_Id(0)),answers);
            }
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Create New Questionnaire";
    }
}
