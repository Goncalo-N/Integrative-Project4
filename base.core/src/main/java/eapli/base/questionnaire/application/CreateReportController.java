package eapli.base.questionnaire.application;

import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.domain.Question.Question_Option;
import eapli.base.questionnaire.domain.Question.Question_Type;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire_Id;
import eapli.base.questionnaire.domain.Section.Section;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CreateReportController {

    private final ListAnswer listAnswer = new ListAnswer();
    private final ListQuestionnaire listQuestionnaire = new ListQuestionnaire();

    public void createReport(Questionnaire_Id id){
        Questionnaire questionnaire = listQuestionnaire.getQuestionnaireByID(id);

        System.out.println("--------------------Questionnaire " + questionnaire.getId() + "--------------------");

        System.out.println(questionnaire.getTitle());

        List<Answer> questionnaire_Answers = listAnswer.getallAnswersByQuestionnaire(id);

        int customers = 1;
        Answer a = questionnaire_Answers.get(0);

        for(Answer a2 : questionnaire_Answers){
            if(!a.getCustomer().getId().equals(a2.getCustomer().getId()))
                customers++;
        }

        System.out.println("Total Customers that answered: " + 5);
        System.out.println("Total Answers made: " + questionnaire_Answers.size());

        for(Section s : questionnaire.getSections()){

            System.out.println("---------------Section " + s.getSection_id().getSection_id() + "---------------");

            System.out.println(s.getSection_title().getTitle());

            int i = 1;
            for (Question q : s.getContent()) {

                System.out.println(i + ". " + q.getQuestion());

                List<Answer> answers = listAnswer.getAnswerByQuestion(id,s.getSection_id(),q.getQuestion_id());

                int contTotal = 0;
                for(Answer a2 : answers){
                    for(String a3 : a2.getAnswers()){
                        contTotal++;
                    }
                }

                System.out.println("Total: " + contTotal);

                for(Question_Option option : q.getOptions()){

                    int cont = 0;
                    List<Double> l = new ArrayList<>();

                    int cont1 = 0,cont2 = 0,cont3 = 0,cont4 = 0,cont5 = 0;
                    int cont11 = 0,cont22 = 0,cont33 = 0,cont44 = 0,cont55 = 0;

                    for(Answer a2 : answers){
                        for(String a3 : a2.getAnswers()){
                            if(q.getType().equals(Question_Type.SCALING_OPTIONS)){

                                //System.out.println("a3: " + a3);
                                switch (a3) {
                                    case "Strongly Agree":
                                        cont1++;
                                        break;
                                    case "Agree":
                                        cont2++;
                                        break;
                                    case "Neutral":
                                        cont3++;
                                        break;
                                    case "Disagree":
                                        cont4++;
                                        break;
                                    case "Strongly Disagree":
                                        cont5++;
                                        break;
                                }

                                cont11 = cont1;
                                cont22 = cont2;
                                cont33 = cont3;
                                cont44 = cont4;
                                cont55 = cont5;
                            }
                            else if(q.getType().equals(Question_Type.MULTIPLE_CHOICE) || q.getType().equals(Question_Type.MULTIPLE_CHOICE_WITH_INPUT_VALUE)){
                                if(a3.equals(option.getOption())){
                                    cont++;
                                }
                            }
                            else{
                                if(a3.equals(option.getOption())){
                                    cont++;
                                }
                            }
                        }
                    }

                    double r = (double) cont/contTotal;

                    final DecimalFormat df = new DecimalFormat("0.00");

                    //System.out.println("cont11: " + cont11);
                    //System.out.println("cont22: " + cont22);
                    //System.out.println("cont33: " + cont33);
                    //System.out.println("cont44: " + cont44);
                    //System.out.println("cont55: " + cont55);
                    //System.out.println("contTotal: " + contTotal);

                    l.add((double)cont11/contTotal);
                    l.add((double)cont22/contTotal);
                    l.add((double)cont33/contTotal);
                    l.add((double)cont44/contTotal);
                    l.add((double)cont55/contTotal);

                    //System.out.println("l outside: " + l);

                    if(q.getType().equals(Question_Type.SCALING_OPTIONS)){
                        System.out.println("- " + option.getOption() + ": " +
                                "Strongly Agree = " + df.format(l.get(0)*100) + "%   " +
                                "Agree = " + df.format(l.get(1)*100) + "%   " +
                                "Neutral = " + df.format(l.get(2)*100) + "%   " +
                                "Disagree = " + df.format(l.get(3)*100) + "%   " +
                                "Strongly Disagree = " + df.format(l.get(4)*100) + "%");
                    }
                    else if(answers.size() == 0 || r == 0){
                        System.out.println("- " + option.getOption() + " = " + 0 + "%");
                    }
                    else{
                        System.out.println("- " + option.getOption() + " = " + df.format(r*100) + "%");
                    }
                    System.out.print("");
                    if(q.getType().equals(Question_Type.SCALING_OPTIONS))
                        System.out.println();
                }
                i++;
                System.out.println();
            }
            System.out.println();
        }
    }
}
