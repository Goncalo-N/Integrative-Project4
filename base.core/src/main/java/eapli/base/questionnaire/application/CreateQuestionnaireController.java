package eapli.base.questionnaire.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Question.Question_Option;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.repository.QuestionnaireRepository;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CreateQuestionnaireController {

    private final QuestionnaireRepository repository = PersistenceContext.repositories().questionnaireRepository();

    public void createNewQuestionnaire(Questionnaire_Id id, Questionnaire_Title title, Questionnaire_Type questionnaire_type, Questionnaire_Condition product_ageGroup, Questionnaire_Welcome_Message welcome_message, Questionnaire_Final_Message final_message, Questionnaire_Number_of_days number_of_days_it_will_be_performed, List<Section> sections) {
        final Questionnaire newQuestionnaire = new Questionnaire(id,title,questionnaire_type,product_ageGroup,welcome_message,final_message,number_of_days_it_will_be_performed,sections);

        this.repository.save(newQuestionnaire);
    }

    public void ExportQuestionnaireToFile(Questionnaire_Id id, Questionnaire_Title title, Questionnaire_Type questionnaire_type, Questionnaire_Condition product_ageGroup, Questionnaire_Welcome_Message welcome_message, Questionnaire_Final_Message final_message, Questionnaire_Number_of_days number_of_days_it_will_be_performed, List<Section> sections) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("Questionnaire" + id + ".txt");

        // Questionnaire------------------------------------------------------------------------------------------------
        out.println("Questionnaire_ID=" + id);
        out.println("Questionnaire_Title=" + title);
        out.println("Questionnaire_Type=" + questionnaire_type);
        out.println("Questionnaire_Type_Condition=" + product_ageGroup);

        // Optional
        if(welcome_message != null)
            out.println("Questionnaire_Welcome_Message=" + welcome_message);

        out.println("Questionnaire_Final_Message=" + final_message);
        out.println("Questionnaire_Number_Of_Days_It_Will_Be_Performed=" + number_of_days_it_will_be_performed);

        // Section------------------------------------------------------------------------------------------------------
        for(Section section: sections){

            out.println("Section_ID=" + section.getSection_id());
            out.println("Section_Title=" + section.getSection_title());

            // Optional
            if(section.getSection_description() != null)
                out.println("Section_Description=" + section.getSection_description());

            out.println("Obligatoriness=" + section.getObligatoriness());

            // Optional
            if(section.getRepeatability() != null)
                out.println("Section_repeatability=" + section.getRepeatability());

            //Question--------------------------------------------------------------------------------------------------
            for (Question question: section.getContent()){

                out.println("Question_ID=" + question.getQuestion_id());
                out.println("Question=" + question.getQuestion());

                // Optional
                if(question.getInstruction() != null)
                    out.println("Question_Instruction=" + question.getInstruction());

                out.println("Question_Type=" + question.getType());
                out.println("Obligatoriness=" + question.getObligatoriness());

                List<Question_Option> options = question.getOptions();

                for(Question_Option option: options)
                    out.println("Extra_Info_Option=" + option);
            }
        }

        out.close();
    }
}
