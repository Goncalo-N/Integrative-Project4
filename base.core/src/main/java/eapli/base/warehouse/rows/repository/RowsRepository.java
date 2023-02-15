package eapli.base.warehouse.rows.repository;

import eapli.base.warehouse.rows.domain.Rows;
import eapli.framework.domain.repositories.DomainRepository;

public interface RowsRepository  extends DomainRepository<String, Rows> {

    public Rows rowsByID(long rowsID);
}

