package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.rows.domain.Rows;
import eapli.base.warehouse.rows.repository.RowsRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRowsRepository extends InMemoryDomainRepository<Rows, String> implements RowsRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Rows rowsByID(long rowsID) {
        return null;
    }
}

