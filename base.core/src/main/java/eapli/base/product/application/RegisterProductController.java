package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Location;
import eapli.base.product.domain.Photo;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;

import java.util.List;

public class RegisterProductController {

    private final ProductRepository repository = PersistenceContext.repositories().productRepository();

    public void registerNewProduct(String internalCode, String productionCode, int barCode, String brandName, String reference, String productShortDescription,
                                   String productExtendedDescription, String productTechnicalDescription, List<Photo> photoPath, String productCategory,
                                   double priceNoTaxes, double priceTaxes, Location location) {
        final Product newProduct = new Product(internalCode, productionCode, barCode, brandName, reference, productShortDescription, productExtendedDescription,
                productTechnicalDescription, photoPath, productCategory, priceNoTaxes, priceTaxes, location);

        this.repository.save(newProduct);
    }
}
