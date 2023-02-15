package eapli.base.questionnaire.domain.LPROG.questionnaire;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class questionnaire {
    public static void main(String[] args) throws IOException {
        System.out.println("Result with Visitor : ");
        parseWithVisitor();
    }

    public static void parseWithVisitor() throws IOException {
        QuestionnaireLexer lexer = new QuestionnaireLexer(CharStreams.fromFileName("Questionnaire1Example"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse start rule lines:
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
