package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.base.questionnaire.domain.Question.*;
import eapli.base.questionnaire.repository.QuestionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;
import static eapli.base.questionnaire.domain.Obligatoriness.OPTIONAL;
import static eapli.base.questionnaire.domain.Question.Question_Type.*;

public class QuestionBootstrapper {
    private static final Logger LOGGER = LogManager.getLogger(QuestionBootstrapper.class);

    public boolean execute() {

        List<Question_Option> options = new ArrayList<>();
        register(new Question_Id(0),new Question_Text("1"), new Question_Instruction(""), FREE_TEXT, MANDATORY, new Question_Condition(""),options);

        //Section 1
        options = new ArrayList<>();
        options.add(new Question_Option("Male"));
        options.add(new Question_Option("Female"));
        options.add(new Question_Option("Other/Not specified"));
        register(new Question_Id(1),new Question_Text("What is your gender?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""),options);

        options = new ArrayList<>();
        options.add(new Question_Option("18-24"));
        options.add(new Question_Option("15-34"));
        options.add(new Question_Option("35-44"));
        options.add(new Question_Option("45-54"));
        options.add(new Question_Option("55-64"));
        options.add(new Question_Option("65-74"));
        options.add(new Question_Option("75+"));
        options.add(new Question_Option("Other/Not specified"));
        register(new Question_Id(2),new Question_Text("What´s your age?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY,new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Europe"));
        options.add(new Question_Option("America"));
        options.add(new Question_Option("Asia"));
        options.add(new Question_Option("Africa"));
        options.add(new Question_Option("Oceania"));
        options.add(new Question_Option("Antarctica"));
        register(new Question_Id(3),new Question_Text("Where do you live?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        //Section 2
        options = new ArrayList<>();
        options.add(new Question_Option("Skin Care"));
        options.add(new Question_Option("Hair Care"));
        options.add(new Question_Option("Make-Up"));
        register(new Question_Id(4),new Question_Text("What cosmetic products do you normally buy?"), new Question_Instruction(""), MULTIPLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        //Section 3
        options = new ArrayList<>();
        options.add(new Question_Option("Normal"));
        options.add(new Question_Option("Dry"));
        options.add(new Question_Option("Oily"));
        options.add(new Question_Option("Combination Skin"));
        register(new Question_Id(5),new Question_Text("What is your type of skin?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("1 time a Day"));
        options.add(new Question_Option("2-4 times a Day"));
        options.add(new Question_Option("5+ times a Day"));
        options.add(new Question_Option("Weekly"));
        options.add(new Question_Option("Never"));
        register(new Question_Id(6),new Question_Text("How often do you use facial creams?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Salesperson´s recommendation"));
        options.add(new Question_Option("Products Ingredients"));
        options.add(new Question_Option("Availability"));
        options.add(new Question_Option("Quality"));
        options.add(new Question_Option("Friend´s Recommendation"));
        options.add(new Question_Option("Price"));
        options.add(new Question_Option("No testing on animals"));
        options.add(new Question_Option("Convenience"));
        options.add(new Question_Option("Brand"));
        options.add(new Question_Option("Packaging"));
        options.add(new Question_Option("Other (please specify)"));
        register(new Question_Id(7),new Question_Text("Which factors do you consider relevant to buy a facial cream?"), new Question_Instruction(""), MULTIPLE_CHOICE_WITH_INPUT_VALUE, OPTIONAL, new Question_Condition(""), options);

        //Section 4
        options = new ArrayList<>();
        options.add(new Question_Option("Straight"));
        options.add(new Question_Option("Wavy"));
        options.add(new Question_Option("Curly"));
        options.add(new Question_Option("Coily"));
        register(new Question_Id(8),new Question_Text("What is your type of hair?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("1 time a Day"));
        options.add(new Question_Option("2-4 times a Day"));
        options.add(new Question_Option("5+ times a Day"));
        options.add(new Question_Option("Weekly"));
        options.add(new Question_Option("Never"));
        register(new Question_Id(9),new Question_Text("How often do you use hair products?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Salesperson´s recommendation"));
        options.add(new Question_Option("Products Ingredients"));
        options.add(new Question_Option("Availability"));
        options.add(new Question_Option("Quality"));
        options.add(new Question_Option("Friend´s Recommendation"));
        options.add(new Question_Option("Price"));
        options.add(new Question_Option("No testing on animals"));
        options.add(new Question_Option("Convenience"));
        options.add(new Question_Option("Brand"));
        options.add(new Question_Option("Packaging"));
        options.add(new Question_Option("Other (please specify)"));
        register(new Question_Id(10),new Question_Text("Which factors do you consider relevant to buy a hair product?"), new Question_Instruction(""), MULTIPLE_CHOICE_WITH_INPUT_VALUE, OPTIONAL, new Question_Condition(""), options);

        //Section 5
        options = new ArrayList<>();
        options.add(new Question_Option("Bronzer"));
        options.add(new Question_Option("Concealer"));
        options.add(new Question_Option("Contour Powder or Creams"));
        options.add(new Question_Option("Eyelash Glue"));
        options.add(new Question_Option("Eyebrow Pencils"));
        options.add(new Question_Option("Eye Primer"));
        options.add(new Question_Option("Face Powder"));
        options.add(new Question_Option("Face Primer"));
        options.add(new Question_Option("Foundation"));
        options.add(new Question_Option("Highlight"));
        options.add(new Question_Option("Lipgloss"));
        options.add(new Question_Option("Lip-balms, liners, primers and sticks"));
        options.add(new Question_Option("Highlight"));
        options.add(new Question_Option("Makeup remover"));
        options.add(new Question_Option("Mascara"));
        options.add(new Question_Option("Nail polish"));
        options.add(new Question_Option("Rouge, blush or blusher"));
        options.add(new Question_Option("Setting Spray"));

        register(new Question_Id(11),new Question_Text("What is your type of make-up?"), new Question_Instruction(""), MULTIPLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("1 time a Day"));
        options.add(new Question_Option("2-4 times a Day"));
        options.add(new Question_Option("5+ times a Day"));
        options.add(new Question_Option("Weekly"));
        options.add(new Question_Option("Never"));
        register(new Question_Id(12),new Question_Text("How often do you use make-up?"), new Question_Instruction(""), SINGLE_CHOICE, MANDATORY, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Salesperson´s recommendation"));
        options.add(new Question_Option("Products Ingredients"));
        options.add(new Question_Option("Availability"));
        options.add(new Question_Option("Quality"));
        options.add(new Question_Option("Friend´s Recommendation"));
        options.add(new Question_Option("Price"));
        options.add(new Question_Option("No testing on animals"));
        options.add(new Question_Option("Convenience"));
        options.add(new Question_Option("Brand"));
        options.add(new Question_Option("Packaging"));
        options.add(new Question_Option("Other (please specify)"));
        register(new Question_Id(13),new Question_Text("Which factors do you consider relevant to buy a make-up product?"), new Question_Instruction(""), MULTIPLE_CHOICE_WITH_INPUT_VALUE, OPTIONAL, new Question_Condition(""), options);

        //Section 6
        options = new ArrayList<>();
        options.add(new Question_Option("Yes"));
        options.add(new Question_Option("No"));
        register(new Question_Id(14),new Question_Text("Are you willing to try new skin products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Yes"));
        options.add(new Question_Option("No"));
        register(new Question_Id(15),new Question_Text("Are you willing to try new hair products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Yes"));
        options.add(new Question_Option("No"));
        register(new Question_Id(16),new Question_Text("Are you willing to try new make-up products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("0-10$"));
        options.add(new Question_Option("11-25$"));
        options.add(new Question_Option("26-40$"));
        options.add(new Question_Option("41-60$"));
        options.add(new Question_Option("61$+"));
        register(new Question_Id(17),new Question_Text("How much are you available to spend in new skin products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("0-10$"));
        options.add(new Question_Option("11-25$"));
        options.add(new Question_Option("26-40$"));
        options.add(new Question_Option("41-60$"));
        options.add(new Question_Option("61$+"));
        register(new Question_Id(18),new Question_Text("How much are you available to spend in new hair products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("0-10$"));
        options.add(new Question_Option("11-25$"));
        options.add(new Question_Option("26-40$"));
        options.add(new Question_Option("41-60$"));
        options.add(new Question_Option("61$+"));
        register(new Question_Id(19),new Question_Text("How much are you available to spend in new make-up products?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        //Section 7
        options = new ArrayList<>();
        options.add(new Question_Option("Cheapest products are as good as expensive"));
        options.add(new Question_Option("I spend too much money on cosmetics"));
        options.add(new Question_Option("I find the range of products and brands available confusing"));
        options.add(new Question_Option("The only guaranty of qualitiee is a recognisable brand"));
        options.add(new Question_Option("I always like the same brands out of habit"));
        options.add(new Question_Option("I love trying new products"));
        register(new Question_Id(20),new Question_Text("Do you agree with the following statements?"), new Question_Instruction(""), SCALING_OPTIONS, MANDATORY, new Question_Condition(""), options);

        //Section 8
        options = new ArrayList<>();
        options.add(new Question_Option("Worker"));
        options.add(new Question_Option("Employee"));
        options.add(new Question_Option("Self-employed"));
        options.add(new Question_Option("Unemployed"));
        register(new Question_Id(21),new Question_Text("What is your working status?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Married"));
        options.add(new Question_Option("Single"));
        options.add(new Question_Option("Divorced"));
        options.add(new Question_Option("Widowed"));
        register(new Question_Id(22),new Question_Text("What is your marital status?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("Yes"));
        options.add(new Question_Option("No"));
        register(new Question_Id(23),new Question_Text("Do you have any children?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        options = new ArrayList<>();
        options.add(new Question_Option("1"));
        options.add(new Question_Option("2"));
        options.add(new Question_Option("3"));
        options.add(new Question_Option("4"));
        options.add(new Question_Option("5"));
        options.add(new Question_Option("5+"));
        register(new Question_Id(24),new Question_Text("How many children do you have?"), new Question_Instruction(""), SINGLE_CHOICE, OPTIONAL, new Question_Condition(""), options);

        return true;
    }

    private void register(Question_Id question_id, Question_Text question, Question_Instruction instruction, Question_Type type, Obligatoriness obligatoriness, Question_Condition condition, List<Question_Option> options) {

        try {
            QuestionRepository repository = PersistenceContext.repositories().questionRepository();

            final Question newQuestion = new Question(question_id,question,instruction,type,obligatoriness,condition,options);

            repository.save(newQuestion);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
