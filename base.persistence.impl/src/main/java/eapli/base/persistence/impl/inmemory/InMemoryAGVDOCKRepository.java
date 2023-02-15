package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVDOCKRepository extends InMemoryDomainRepository<AGVDOCK, String> implements AGVDOCKRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public AGVDOCK AGVDOCKByID(Long AGVDOCKID) {
        return null;
    }
}