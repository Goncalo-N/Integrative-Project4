package eapli.base.warehouse.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.repository.LineRepository;

import java.util.ArrayList;
import java.util.List;

public class ListLine {
    private final LineRepository repository = PersistenceContext.repositories().lineRepository();

    public Iterable<Line> listAllLines() {
        return this.repository.findAll();
    }

    public List<Line> getLinesByProduct(long productId) {
        List<Line> listLines = new ArrayList<>();
        Line line = new Line();

        for (Line l : listAllLines()) {
            if (l.getProduct().getId() == productId) {
                line.setId(l.getId());
                line.setProduct(l.getProduct());
                line.setQuantity(l.getQuantity());
                listLines.add(line);
            }
        }

        return listLines;
    }
}
