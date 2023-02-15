package eapli.base.warehouse.aisle.repository;

import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.framework.domain.repositories.DomainRepository;

public interface AisleRepository  extends DomainRepository<String, Aisle> {

    public Aisle aisleByID(long aisleID);
}

