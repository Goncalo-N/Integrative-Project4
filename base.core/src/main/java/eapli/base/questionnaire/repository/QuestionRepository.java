package eapli.base.questionnaire.repository;

import eapli.base.questionnaire.domain.Question.Question;
import eapli.framework.domain.repositories.DomainRepository;

public interface QuestionRepository extends DomainRepository<String, Question> {
}
