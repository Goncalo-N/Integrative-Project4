package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.base.warehouse.aisle.repository.AisleRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAisleRepository extends InMemoryDomainRepository<Aisle, String> implements AisleRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Aisle aisleByID(long aisleID) {
        return null;
    }
}