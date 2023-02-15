package eapli.base.persistence.impl.jpa;

import eapli.base.questionnaire.domain.Section.Section;
import eapli.base.questionnaire.repository.SectionRepository;

public class JpaSectionRepository extends BasepaRepositoryBase<Section, String, String> implements SectionRepository {

    public JpaSectionRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
