package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.application.ListQuestion;
import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Question.Question_Id;
import eapli.base.questionnaire.domain.Section.*;
import eapli.base.questionnaire.repository.SectionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;
import static eapli.base.questionnaire.domain.Obligatoriness.OPTIONAL;

public class SectionBootstrapper {
    private static final Logger LOGGER = LogManager.getLogger(SectionBootstrapper.class);

    public boolean execute() {

        ListQuestion listQuestion = new ListQuestion();
        Question question1 = listQuestion.getQuestionByID(new Question_Id(1));
        Question question2 = listQuestion.getQuestionByID(new Question_Id(2));
        Question question3 = listQuestion.getQuestionByID(new Question_Id(3));
        Question question4 = listQuestion.getQuestionByID(new Question_Id(4));
        Question question5 = listQuestion.getQuestionByID(new Question_Id(5));
        Question question6 = listQuestion.getQuestionByID(new Question_Id(6));
        Question question7 = listQuestion.getQuestionByID(new Question_Id(7));
        Question question8 = listQuestion.getQuestionByID(new Question_Id(8));
        Question question9 = listQuestion.getQuestionByID(new Question_Id(9));
        Question question10 = listQuestion.getQuestionByID(new Question_Id(10));
        Question question11 = listQuestion.getQuestionByID(new Question_Id(11));
        Question question12 = listQuestion.getQuestionByID(new Question_Id(12));
        Question question13 = listQuestion.getQuestionByID(new Question_Id(13));
        Question question14 = listQuestion.getQuestionByID(new Question_Id(14));
        Question question15 = listQuestion.getQuestionByID(new Question_Id(15));
        Question question16 = listQuestion.getQuestionByID(new Question_Id(16));
        Question question17 = listQuestion.getQuestionByID(new Question_Id(17));
        Question question18 = listQuestion.getQuestionByID(new Question_Id(18));
        Question question19 = listQuestion.getQuestionByID(new Question_Id(19));
        Question question20 = listQuestion.getQuestionByID(new Question_Id(20));
        Question question21 = listQuestion.getQuestionByID(new Question_Id(21));
        Question question22 = listQuestion.getQuestionByID(new Question_Id(22));
        Question question23 = listQuestion.getQuestionByID(new Question_Id(23));
        Question question24 = listQuestion.getQuestionByID(new Question_Id(24));

        List<Question> content = new ArrayList<>();
        register(new Section_Id(0),new Section_Title("1"), new Section_Description(""), MANDATORY, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 1
        content = new ArrayList<>();
        content.add(question1);
        content.add(question2);
        content.add(question3);
        register(new Section_Id(1),new Section_Title("About You"), new Section_Description(""), MANDATORY, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 2
        content = new ArrayList<>();
        content.add(question4);
        register(new Section_Id(2),new Section_Title("Cosmetics Products"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 3
        content = new ArrayList<>();
        content.add(question5);
        content.add(question6);
        content.add(question7);
        register(new Section_Id(3),new Section_Title("Skin Care"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 4
        content = new ArrayList<>();
        content.add(question8);
        content.add(question9);
        content.add(question10);
        register(new Section_Id(4),new Section_Title("Hair Care"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 5
        content = new ArrayList<>();
        content.add(question11);
        content.add(question12);
        content.add(question13);
        register(new Section_Id(5),new Section_Title("Make-Up"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 6
        content = new ArrayList<>();
        content.add(question14);
        content.add(question15);
        content.add(question16);
        content.add(question17);
        content.add(question18);
        content.add(question19);
        register(new Section_Id(6),new Section_Title("Cosmetics Products"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 7
        content = new ArrayList<>();
        content.add(question20);
        register(new Section_Id(7),new Section_Title("Your Opinion"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        //Section 8
        content = new ArrayList<>();
        content.add(question21);
        content.add(question22);
        content.add(question23);
        content.add(question24);
        register(new Section_Id(8),new Section_Title("About You Again"), new Section_Description(""), OPTIONAL, new Section_Condition(""), new Section_Repeatability(""), content);

        return true;
    }

    private void register(Section_Id section_id, Section_Title section_title, Section_Description section_description, Obligatoriness obligatoriness, Section_Condition condition, Section_Repeatability repeatability, List<Question> content) {

        try {
            SectionRepository repository = PersistenceContext.repositories().sectionRepository();

            final Section newSection = new Section(section_id,section_title,section_description,obligatoriness,condition,repeatability,content);

            repository.save(newSection);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
