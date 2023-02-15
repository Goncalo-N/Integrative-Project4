package eapli.base.persistence.impl.jpa;

import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.repository.AnswerRepository;
import eapli.base.questionnaire.repository.QuestionnaireRepository;

public class JpaAnswerRepository extends BasepaRepositoryBase<Answer, String, String> implements AnswerRepository {

    public JpaAnswerRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
