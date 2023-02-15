package eapli.base.persistence.impl.jpa;

import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.repository.QuestionnaireRepository;

public class JpaQuestionnaireRepository extends BasepaRepositoryBase<Questionnaire, String, String> implements QuestionnaireRepository {

    public JpaQuestionnaireRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
