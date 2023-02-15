package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.repository.LineRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryLineRepository extends InMemoryDomainRepository<Line, String> implements LineRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Line lineById(long id) {
        return null;
    }
}
