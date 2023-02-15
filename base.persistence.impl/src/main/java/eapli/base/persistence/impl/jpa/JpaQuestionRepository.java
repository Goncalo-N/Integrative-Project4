package eapli.base.persistence.impl.jpa;

import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.repository.QuestionRepository;

public class JpaQuestionRepository extends BasepaRepositoryBase<Question, String, String> implements QuestionRepository {

    public JpaQuestionRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
