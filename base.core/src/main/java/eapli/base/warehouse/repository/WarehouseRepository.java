package eapli.base.warehouse.repository;

import eapli.base.warehouse.domain.Warehouse;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehouseRepository  extends DomainRepository<String, Warehouse> {

    public Warehouse warehouseByID(long warehouseID);
}

