package eapli.base.warehouse.rows.application;

import eapli.base.warehouse.rows.domain.Rows;
import eapli.base.warehouse.aisle.domain.coordinates;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.rows.repository.RowsRepository;

public class RowsController {

    private final RowsRepository repository = PersistenceContext.repositories().rowsRepository();

    public void registerNewRow(Long id, coordinates begin, coordinates end, long shelves) {
        final Rows newRows = new Rows(id, begin, end, shelves);

        this.repository.save(newRows);
    }
}
