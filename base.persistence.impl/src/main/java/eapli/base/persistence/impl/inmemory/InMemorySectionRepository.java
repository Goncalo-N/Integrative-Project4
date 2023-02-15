package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.repository.SectionRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemorySectionRepository extends InMemoryDomainRepository<Section, String> implements SectionRepository {

    static {
        InMemoryInitializer.init();
    }
}
