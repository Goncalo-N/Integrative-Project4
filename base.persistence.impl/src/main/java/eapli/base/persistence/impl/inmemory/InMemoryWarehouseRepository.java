package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.repository.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, String> implements WarehouseRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Warehouse warehouseByID(long warehouseID) {
        return null;
    }
}
