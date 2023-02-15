package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaire.domain.Questionnaire.Questionnaire;
import eapli.base.questionnaire.repository.QuestionnaireRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryQuestionnaireRepository extends InMemoryDomainRepository<Questionnaire, String> implements QuestionnaireRepository {

    static {
        InMemoryInitializer.init();
    }
}
