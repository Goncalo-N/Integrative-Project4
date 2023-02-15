package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaire.domain.Question.Question;
import eapli.base.questionnaire.repository.QuestionRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryQuestionRepository extends InMemoryDomainRepository<Question, String> implements QuestionRepository {

    static {
        InMemoryInitializer.init();
    }
}
