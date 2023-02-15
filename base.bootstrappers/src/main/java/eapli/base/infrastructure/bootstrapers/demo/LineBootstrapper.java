package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.application.ListProduct;
import eapli.base.product.domain.Product;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.repository.LineRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineBootstrapper {
    private static final Logger LOGGER = LogManager.getLogger(LineBootstrapper.class);

    public boolean execute() {

        ListProduct listProduct = new ListProduct();
        Product product1 = listProduct.getProductByID(1);
        Product product2 = listProduct.getProductByID(2);

        register(product1,3);
        register(product2,10);
        return true;
    }

    private void register(Product product, int quantity) {

        try {
            LineRepository repository = PersistenceContext.repositories().lineRepository();

            final Line newLine = new Line(product,quantity);

            repository.save(newLine);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
