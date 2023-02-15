package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaire.domain.Answer.Answer;
import eapli.base.questionnaire.repository.AnswerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAnswerRepository extends InMemoryDomainRepository<Answer, String> implements AnswerRepository {

    static {
        InMemoryInitializer.init();
    }
}
