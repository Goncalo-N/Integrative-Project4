package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customer.application.ListCustomer;
import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.application.ListQuestion;
import eapli.base.questionnaire.application.ListQuestionnaire;
import eapli.base.questionnaire.application.ListSection;
import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Answer.Answer_Status;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Question.Question_Id;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.domain.Section.Section_Id;
import eapli.base.questionnaire.repository.AnswerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AnswerBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(AnswerBootstrapper.class);

    public boolean execute() {

        ListQuestion listQuestion = new ListQuestion();
        Question question0 = listQuestion.getQuestionByID(new Question_Id(0));
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

        ListSection listSection = new ListSection();
        Section section0 = listSection.getSectionByID(new Section_Id(0));
        Section section1 = listSection.getSectionByID(new Section_Id(1));
        Section section2 = listSection.getSectionByID(new Section_Id(2));
        Section section3 = listSection.getSectionByID(new Section_Id(3));
        Section section4 = listSection.getSectionByID(new Section_Id(4));
        Section section5 = listSection.getSectionByID(new Section_Id(5));
        Section section6 = listSection.getSectionByID(new Section_Id(6));
        Section section7 = listSection.getSectionByID(new Section_Id(7));
        Section section8 = listSection.getSectionByID(new Section_Id(8));

        ListQuestionnaire listQuestionnaire = new ListQuestionnaire();
        Questionnaire questionnaire1 = listQuestionnaire.getQuestionnaireByID(new Questionnaire_Id("ABC1"));
        Questionnaire questionnaire2 = listQuestionnaire.getQuestionnaireByID(new Questionnaire_Id("BDS3"));

        ListCustomer listCustomer = new ListCustomer();
        Customer customer1 = listCustomer.getCustomerByID(1);
        Customer customer2 = listCustomer.getCustomerByID(2);
        Customer customer3 = listCustomer.getCustomerByID(3);
        Customer customer4 = listCustomer.getCustomerByID(4);
        Customer customer5 = listCustomer.getCustomerByID(5);

        List<String> answers = new ArrayList<>();
        register(customer1,Answer_Status.NOT_ANSWERED,questionnaire1,section0,question0,answers);
        register(customer1,Answer_Status.NOT_ANSWERED,questionnaire2,section0,question0,answers);
        register(customer2,Answer_Status.NOT_ANSWERED,questionnaire2,section0,question0,answers);
        register(customer3,Answer_Status.NOT_ANSWERED,questionnaire2,section0,question0,answers);
        register(customer4,Answer_Status.NOT_ANSWERED,questionnaire2,section0,question0,answers);
        register(customer5,Answer_Status.NOT_ANSWERED,questionnaire2,section0,question0,answers);

        //Section 1
        answers.add("Female");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section1,question1,answers); // Question 1
        answers = new ArrayList<>();
        answers.add("18-24");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section1,question2,answers); // Question 2
        answers = new ArrayList<>();
        answers.add("Europe");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section1,question3,answers); // Question 3

        answers = new ArrayList<>();
        answers.add("Male");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section1,question1,answers); // Question 1
        answers = new ArrayList<>();
        answers.add("15-34");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section1,question2,answers); // Question 2
        answers = new ArrayList<>();
        answers.add("America");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section1,question3,answers); // Question 3

        answers = new ArrayList<>();
        answers.add("Other/Not specified");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section1,question1,answers); // Question 1
        answers = new ArrayList<>();
        answers.add("35-44");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section1,question2,answers); // Question 2
        answers = new ArrayList<>();
        answers.add("America");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section1,question3,answers); // Question 3

        answers = new ArrayList<>();
        answers.add("Other/Not specified");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section1,question1,answers); // Question 1
        answers = new ArrayList<>();
        answers.add("18-24");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section1,question2,answers); // Question 2
        answers = new ArrayList<>();
        answers.add("Antarctica");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section1,question3,answers); // Question 3

        //Section 2
        answers = new ArrayList<>();
        answers.add("Skin Care");
        answers.add("Make-Up");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section2,question4,answers); // Question 4

        answers = new ArrayList<>();
        answers.add("Hair Care");
        answers.add("Make-Up");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section2,question4,answers); // Question 4

        answers = new ArrayList<>();
        answers.add("Skin Care");
        answers.add("Hair Care");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section2,question4,answers); // Question 4

        answers = new ArrayList<>();
        answers.add("Make-Up");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section2,question4,answers); // Question 4

        //Section 3
        answers = new ArrayList<>();
        answers.add("Dry");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section3,question5,answers); // Question 5
        answers = new ArrayList<>();
        answers.add("1 time a Day");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section3,question6,answers); // Question 6
        answers = new ArrayList<>();
        answers.add("Quality");
        answers.add("Price");
        answers.add("Brand");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section3,question7,answers); // Question 7

        answers = new ArrayList<>();
        answers.add("Dry");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section3,question5,answers); // Question 5
        answers = new ArrayList<>();
        answers.add("Weekly");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section3,question6,answers); // Question 6
        answers = new ArrayList<>();
        answers.add("Convenience");
        answers.add("Packaging");
        answers.add("Brand");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section3,question7,answers); // Question 7

        //Section 4
        answers = new ArrayList<>();
        answers.add("Wavy");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section4,question8,answers); // Question 8
        answers = new ArrayList<>();
        answers.add("5+ times a Day");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section4,question9,answers); // Question 9
        answers = new ArrayList<>();
        answers.add("Quality");
        answers.add("Availability");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section4,question10,answers); // Question 10

        answers = new ArrayList<>();
        answers.add("Wavy");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section4,question8,answers); // Question 8
        answers = new ArrayList<>();
        answers.add("Weekly");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section4,question9,answers); // Question 9
        answers = new ArrayList<>();
        answers.add("Price");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section4,question10,answers); // Question 10

        //Section 5
        answers = new ArrayList<>();
        answers.add("Bronzer");
        answers.add("Concealer");
        answers.add("Eyebrow Pencils");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section5,question11,answers); // Question 11
        answers = new ArrayList<>();
        answers.add("Weekly");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section5,question12,answers); // Question 12
        answers = new ArrayList<>();
        answers.add("Friend´s Recommendation");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section5,question13,answers); // Question 13

        answers = new ArrayList<>();
        answers.add("Mascara");
        answers.add("Concealer");
        answers.add("Setting Spray");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section5,question11,answers); // Question 11
        answers = new ArrayList<>();
        answers.add("Never");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section5,question12,answers); // Question 12

        answers = new ArrayList<>();
        answers.add("Highlight");
        answers.add("Lip-balms, liners, primers and sticks");
        answers.add("Eyebrow Pencils");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section5,question11,answers); // Question 11
        answers = new ArrayList<>();
        answers.add("2-4 times a Day");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section5,question12,answers); // Question 12
        answers = new ArrayList<>();
        answers.add("Friend´s Recommendation");
        answers.add("Quality");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section5,question13,answers); // Question 13

        //Section 6
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section6,question14,answers); // Question 14
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section6,question16,answers); // Question 16
        answers = new ArrayList<>();
        answers.add("11-25$");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section6,question17,answers); // Question 17
        answers = new ArrayList<>();
        answers.add("26-40$");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section6,question19,answers); // Question 19

        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section6,question15,answers); // Question 15
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section6,question16,answers); // Question 16
        answers = new ArrayList<>();
        answers.add("26-40$");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section6,question18,answers); // Question 18
        answers = new ArrayList<>();
        answers.add("26-40$");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section6,question19,answers); // Question 19

        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section6,question14,answers); // Question 14
        answers = new ArrayList<>();
        answers.add("No");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section6,question15,answers); // Question 15
        answers = new ArrayList<>();
        answers.add("61$+");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section6,question17,answers); // Question 17

        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section6,question16,answers); // Question 16
        answers = new ArrayList<>();
        answers.add("41-60$");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section6,question19,answers); // Question 19

        //Section 7
        answers = new ArrayList<>();
        answers.add("Agree");
        answers.add("Strongly Disagree");
        answers.add("Neutral");
        answers.add("Agree");
        answers.add("Agree");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section7,question20,answers); // Question 20

        answers = new ArrayList<>();
        answers.add("Disagree");
        answers.add("Neutral");
        answers.add("Disagree");
        answers.add("Strongly Disagree");
        answers.add("Strongly Agree");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section7,question20,answers); // Question 20

        answers = new ArrayList<>();
        answers.add("Strongly Agree");
        answers.add("Neutral");
        answers.add("Neutral");
        answers.add("Agree");
        answers.add("Disagree");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section7,question20,answers); // Question 20

        answers = new ArrayList<>();
        answers.add("Agree");
        answers.add("Disagree");
        answers.add("Strongly Agree");
        answers.add("Disagree");
        answers.add("Strongly Disagree");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section7,question20,answers); // Question 20

        //Section 8
        answers = new ArrayList<>();
        answers.add("Worker");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section8,question21,answers); // Question 21
        answers = new ArrayList<>();
        answers.add("Married");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section8,question22,answers); // Question 22
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section8,question23,answers); // Question 23
        answers = new ArrayList<>();
        answers.add("5");
        register(customer2,Answer_Status.ANSWERED,questionnaire1,section8,question24,answers); // Question 24

        answers = new ArrayList<>();
        answers.add("Worker");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section8,question21,answers); // Question 21
        answers = new ArrayList<>();
        answers.add("Widowed");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section8,question22,answers); // Question 22
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section8,question23,answers); // Question 23
        answers = new ArrayList<>();
        answers.add("2");
        register(customer3,Answer_Status.ANSWERED,questionnaire1,section8,question24,answers); // Question 24

        answers = new ArrayList<>();
        answers.add("Employee");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section8,question21,answers); // Question 21
        answers = new ArrayList<>();
        answers.add("Widowed");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section8,question22,answers); // Question 22
        answers = new ArrayList<>();
        answers.add("Yes");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section8,question23,answers); // Question 23
        answers = new ArrayList<>();
        answers.add("4");
        register(customer4,Answer_Status.ANSWERED,questionnaire1,section8,question24,answers); // Question 24

        answers = new ArrayList<>();
        answers.add("Unemployed");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section8,question21,answers); // Question 21
        answers = new ArrayList<>();
        answers.add("Single");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section8,question22,answers); // Question 22
        answers = new ArrayList<>();
        answers.add("No");
        register(customer5,Answer_Status.ANSWERED,questionnaire1,section8,question23,answers); // Question 23

        return true;
    }

    private void register(Customer customer, Answer_Status status, Questionnaire questionnaire, Section section, Question question, List<String> answers) {

        try {
            AnswerRepository repository = PersistenceContext.repositories().answerRepository();

            final Answer newAnswer = new Answer(customer,status,questionnaire,section,question,answers);

            repository.save(newAnswer);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
