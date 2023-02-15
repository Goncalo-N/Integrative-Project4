package eapli.base.questionnaire.application;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Question.Question_Id;
import eapli.base.questionnaire.domain.Question.Question_Option;
import eapli.base.questionnaire.domain.Questionnaire.*;
import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.domain.Section.Section_Id;
import eapli.base.questionnaire.repository.QuestionnaireRepository;
import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.questionnaire.domain.Answer.Answer_Status.ANSWERED;
import static eapli.base.questionnaire.domain.Question.Question_Type.*;
import static eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Type.HAVE_ORDERED_A_GIVEN_PRODUCT;

public class ListQuestionnaire {

    private final QuestionnaireRepository repository = PersistenceContext.repositories().questionnaireRepository();
    private final CreateAnswerController answerController = new CreateAnswerController();
    private final ListAnswer listAnswer = new ListAnswer();

    public Iterable<Questionnaire> listAllQuestionnaires() {
        return this.repository.findAll();
    }

    public List<Questionnaire> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>();

        for (Questionnaire q : listAllQuestionnaires()) {
            Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id(q.getId().getId()),
                    new Questionnaire_Title(q.getTitle().getTitle()),
                    q.getQuestionnaire_type(),
                    new Questionnaire_Condition(q.getProduct_ageGroup().getCondition()),
                    new Questionnaire_Welcome_Message(q.getWelcome_message().getWelcome_message()),
                    new Questionnaire_Final_Message(q.getFinal_message().getFinal_Message()),
                    new Questionnaire_Number_of_days(q.getNumber_of_days_it_will_be_performed().getNumber_of_days_it_will_be_performed()),
                    q.getSections());

            questionnaires.add(questionnaire);
        }
        return questionnaires;
    }

    public Questionnaire getQuestionnaireByID(Questionnaire_Id questionnaireID) {
        List<Section> sections = new ArrayList<>();
        Questionnaire questionnaire = new Questionnaire(new Questionnaire_Id("BDS3"),new Questionnaire_Title("Skin products"), HAVE_ORDERED_A_GIVEN_PRODUCT, new Questionnaire_Condition(1),new Questionnaire_Welcome_Message("Welcome!"), new Questionnaire_Final_Message("Thank you for answering!"), new Questionnaire_Number_of_days(1),sections);

        for (Questionnaire q : listAllQuestionnaires()) {
            if (q.getId().getId().equals(questionnaireID.getId())) {
                questionnaire.setId(q.getId());
                questionnaire.setTitle(q.getTitle());
                questionnaire.setQuestionnaire_type(q.getQuestionnaire_type());
                questionnaire.setProduct_ageGroup(q.getProduct_ageGroup());
                questionnaire.setWelcome_message(q.getWelcome_message());
                questionnaire.setFinal_message(q.getFinal_message());
                questionnaire.setNumber_of_days_it_will_be_performed(q.getNumber_of_days_it_will_be_performed());
                questionnaire.setSections(q.getSections());
            }
        }
        return questionnaire;
    }

    public void QuestionnaireEstrutura(Questionnaire_Id id, Customer customer){
        Questionnaire questionnaire = getQuestionnaireByID(id);

        System.out.println("--------------------Questionnaire " + questionnaire.getId() + "--------------------");

        System.out.println(questionnaire.getWelcome_message());

        System.out.println(questionnaire.getTitle());

        int i = 1;
        for(Section s : questionnaire.getSections()){

            int erro = 0;

            if(s.getSection_id().getSection_id() == 3 || s.getSection_id().getSection_id() == 4 || s.getSection_id().getSection_id() == 5) {
                Answer answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(2), new Question_Id(4));

                for(String temp: answer.getAnswers()){
                    if (s.getSection_id().getSection_id() == 3 && temp.equals("Skin Care")) {
                        erro = 0;
                        break;
                    }
                    else if (s.getSection_id().getSection_id() == 4 && temp.equals("Hair Care")) {
                        erro = 0;
                        break;
                    }
                    else if (s.getSection_id().getSection_id() == 5 && temp.equals("Make-Up")) {
                        erro = 0;
                        break;
                    }
                    else{
                        erro = 1;
                    }
                }
            }

            if(erro == 0) {

                System.out.println("---------------Section " + s.getSection_id().getSection_id() + "---------------");

                System.out.println(s.getSection_title().getTitle());

                for (Question q : s.getContent()) {

                    int erro2 = 0;

                    if(q.getQuestion_id().getQuestion_id() == 7 || q.getQuestion_id().getQuestion_id() == 10 || q.getQuestion_id().getQuestion_id() == 13
                            || q.getQuestion_id().getQuestion_id() == 14 || q.getQuestion_id().getQuestion_id() == 15 || q.getQuestion_id().getQuestion_id() == 16
                            || q.getQuestion_id().getQuestion_id() == 17 || q.getQuestion_id().getQuestion_id() == 18 || q.getQuestion_id().getQuestion_id() == 19
                            || q.getQuestion_id().getQuestion_id() == 24) {
                        Answer answer = new Answer(ANSWERED);

                        if(q.getQuestion_id().getQuestion_id() == 7)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(3), new Question_Id(6));

                        if(q.getQuestion_id().getQuestion_id() == 10)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(4), new Question_Id(9));

                        if(q.getQuestion_id().getQuestion_id() == 13)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(5), new Question_Id(12));

                        if(q.getQuestion_id().getQuestion_id() == 14 || q.getQuestion_id().getQuestion_id() == 15 || q.getQuestion_id().getQuestion_id() == 16)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(2), new Question_Id(4));

                        if(q.getQuestion_id().getQuestion_id() == 17)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(6), new Question_Id(14));

                        if(q.getQuestion_id().getQuestion_id() == 18)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(6), new Question_Id(15));

                        if(q.getQuestion_id().getQuestion_id() == 19)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(6), new Question_Id(16));

                        if(q.getQuestion_id().getQuestion_id() == 24)
                            answer = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(8), new Question_Id(23));

                        Answer answer2 = listAnswer.getAnswerBySection(customer, questionnaire.getId(), new Section_Id(2), new Question_Id(4));

                        if(answer.getId() == 0){
                            erro2 = 1;
                        }
                        else {
                            for (String temp : answer.getAnswers()) {

                                if (q.getQuestion_id().getQuestion_id() == 7 || q.getQuestion_id().getQuestion_id() == 10 || q.getQuestion_id().getQuestion_id() == 13
                                        || q.getQuestion_id().getQuestion_id() == 17 || q.getQuestion_id().getQuestion_id() == 18 || q.getQuestion_id().getQuestion_id() == 19
                                        || q.getQuestion_id().getQuestion_id() == 24) {
                                    if ((q.getQuestion_id().getQuestion_id() == 7 || q.getQuestion_id().getQuestion_id() == 10 || q.getQuestion_id().getQuestion_id() == 13)
                                            && temp.equals("Never")) {
                                        erro2 = 1;
                                        break;
                                    } else if (q.getQuestion_id().getQuestion_id() == 17 || q.getQuestion_id().getQuestion_id() == 18 || q.getQuestion_id().getQuestion_id() == 19) {
                                        for (String temp2 : answer2.getAnswers()) {
                                            if (q.getQuestion_id().getQuestion_id() == 17 && temp2.equals("Skin Care")) {
                                                if (temp.equals("No")) {
                                                    erro2 = 1;
                                                    break;
                                                }
                                            } else if (q.getQuestion_id().getQuestion_id() == 18 && temp2.equals("Hair Care")) {
                                                if (temp.equals("No")) {
                                                    erro2 = 1;
                                                    break;
                                                }
                                            } else if (q.getQuestion_id().getQuestion_id() == 19 && temp2.equals("Make-Up")) {
                                                if (temp.equals("No")) {
                                                    erro2 = 1;
                                                    break;
                                                }
                                            }
                                        }
                                    } else if (q.getQuestion_id().getQuestion_id() == 24 && temp.equals("No")) {
                                        erro2 = 1;
                                        break;
                                    } else {
                                        erro2 = 0;
                                    }
                                }

                                if (q.getQuestion_id().getQuestion_id() == 14 || q.getQuestion_id().getQuestion_id() == 15 || q.getQuestion_id().getQuestion_id() == 16) {
                                    if (q.getQuestion_id().getQuestion_id() == 14 && temp.equals("Skin Care")) {
                                        erro2 = 0;
                                        break;
                                    } else if (q.getQuestion_id().getQuestion_id() == 15 && temp.equals("Hair Care")) {
                                        erro2 = 0;
                                        break;
                                    } else if (q.getQuestion_id().getQuestion_id() == 16 && temp.equals("Make-Up")) {
                                        erro2 = 0;
                                        break;
                                    } else {
                                        erro2 = 1;
                                    }
                                }
                            }
                        }
                    }

                    if(erro2 == 0){

                        System.out.println(i + ". " + q.getQuestion());

                        List<String> answers = new ArrayList<>();

                        if (q.getType() == FREE_TEXT) {

                            String answer = Console.readLine("");
                            answers.add(answer);
                        } else if (q.getType() == NUMERIC) {

                            int answer = Console.readInteger("");
                            answers.add(String.valueOf(answer));
                        } else if (q.getType() == SINGLE_CHOICE) {

                            for (Question_Option o : q.getOptions()) {
                                System.out.println("- " + o.getOption());
                            }

                            String answer = Console.readLine("");
                            answers.add(answer);
                        } else if (q.getType() == SINGLE_CHOICE_WITH_INPUT_VALUE) {

                            for (Question_Option o : q.getOptions()) {
                                System.out.println("- " + o.getOption());
                            }

                            String answer = Console.readLine("");
                            answers.add(answer);

                            if (answer.equals(q.getOptions().get(q.getOptions().size() - 1).getOption())) {
                                answer = Console.readLine("");
                            }
                        } else if (q.getType() == MULTIPLE_CHOICE) {

                            for (Question_Option o : q.getOptions()) {
                                System.out.println("- " + o.getOption());
                            }

                            int option = Console.readInteger("How many options would you like to select?");

                            String answer;

                            for (int j = 0; j < option; j++) {
                                answer = Console.readLine("");
                                answers.add(answer);
                            }
                        } else if (q.getType() == MULTIPLE_CHOICE_WITH_INPUT_VALUE) {

                            for (Question_Option o : q.getOptions()) {
                                System.out.println("- " + o.getOption());
                            }

                            int option = Console.readInteger("How many options would you like to select?");

                            String answer;

                            for (int j = 0; j < option; j++) {
                                answer = Console.readLine("");
                                answers.add(answer);

                                if (answer.equals(q.getOptions().get(q.getOptions().size() - 1).getOption())) {
                                    answer = Console.readLine("");
                                }
                            }
                        }

                        //else if(q.getType() == SORTING_OPTIONS){
                        //}

                        else if (q.getType() == SCALING_OPTIONS) {

                            for (Question_Option o : q.getOptions()) {
                                System.out.println("- " + o.getOption());
                                String answer = Console.readLine("Strongly Agree/ Agree / Neutral / Disagree / Strongly Disagree");
                                answers.add(answer);
                            }
                        }

                        answerController.createNewAnswer(customer, ANSWERED, questionnaire, s, q, answers);
                        i++;
                    }
                }
            }
        }
        System.out.println(questionnaire.getFinal_message());
    }
}
