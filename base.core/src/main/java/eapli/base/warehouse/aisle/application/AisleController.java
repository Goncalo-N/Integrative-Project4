package eapli.base.warehouse.aisle.application;

import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.base.warehouse.aisle.domain.coordinates;
import eapli.base.warehouse.aisle.repository.AisleRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.rows.domain.Rows;

import java.util.List;

public class AisleController {

    private final AisleRepository repository = PersistenceContext.repositories().aisleRepository();

    public void registerNewAisle(Long id, coordinates begin, coordinates end, coordinates depth, String accessibility, List<Rows> rowsList) {
        final Aisle newAisle = new Aisle(id, begin, end, depth, accessibility,rowsList);

        this.repository.save(newAisle);
    }
}
