package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.agv.domain.AGV;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVRepository extends InMemoryDomainRepository<AGV, String> implements AGVRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public AGV agvById(long agvId) {
        return null;
    }

    @Override
    public boolean checkAGV(Long agvId) {
        return false;
    }


    @Override
    public AGV getFirstAvailableAGV() {
        return null;
    }


}
