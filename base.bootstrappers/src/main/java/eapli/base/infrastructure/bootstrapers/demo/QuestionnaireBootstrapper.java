package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.application.ListSection;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.domain.Section.Section_Id;
import eapli.base.questionnaire.repository.QuestionnaireRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.ARE_OF_A_GENDER;
import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.HAVE_ORDERED_A_GIVEN_PRODUCT;

public class QuestionnaireBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(QuestionnaireBootstrapper.class);

    public boolean execute() {

        ListSection listSection = new ListSection();
        Section section1 = listSection.getSectionByID(new Section_Id(1));
        Section section2 = listSection.getSectionByID(new Section_Id(2));
        Section section3 = listSection.getSectionByID(new Section_Id(3));
        Section section4 = listSection.getSectionByID(new Section_Id(4));
        Section section5 = listSection.getSectionByID(new Section_Id(5));
        Section section6 = listSection.getSectionByID(new Section_Id(6));
        Section section7 = listSection.getSectionByID(new Section_Id(7));
        Section section8 = listSection.getSectionByID(new Section_Id(8));

        //Questionnaire 1
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);
        sections.add(section4);
        sections.add(section5);
        sections.add(section6);
        sections.add(section7);
        sections.add(section8);

        register(new Questionnaire_Id("ABC1"),new Questionnaire_Title("Everything About You"), ARE_OF_A_GENDER, new Questionnaire_Condition(2), new Questionnaire_Welcome_Message("Welcomew!"), new Questionnaire_Final_Message("Thank youd for answering!"), new Questionnaire_Number_of_days(3),sections);

        //Questionnaire 2
        sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);
        sections.add(section4);
        sections.add(section5);
        sections.add(section6);

        register(new Questionnaire_Id("BDS3"),new Questionnaire_Title("Skin products"), HAVE_ORDERED_A_GIVEN_PRODUCT, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome!"), new Questionnaire_Final_Message("Thank you for answering!"), new Questionnaire_Number_of_days(1),sections);

        return true;
    }

    private void register(Questionnaire_Id id, Questionnaire_Title title, Questionnaire_Type questionnaire_type, Questionnaire_Condition product_ageGroup, Questionnaire_Welcome_Message welcome_message, Questionnaire_Final_Message final_message, Questionnaire_Number_of_days number_of_days_it_will_be_performed, List<Section> sections) {

        try {
            QuestionnaireRepository repository = PersistenceContext.repositories().questionnaireRepository();

            final Questionnaire newQuestionnaire = new Questionnaire(id,title,questionnaire_type,product_ageGroup,welcome_message,final_message,number_of_days_it_will_be_performed,sections);

            repository.save(newQuestionnaire);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
