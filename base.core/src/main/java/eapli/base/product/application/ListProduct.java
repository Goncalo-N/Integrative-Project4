package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;

public class ListProduct {

    private final ProductRepository repository = PersistenceContext.repositories().productRepository();

    public Iterable<Product> listAllProducts() {
        return this.repository.findAll();
    }

    public Product getProductByID(long productID) {
        Product product = new Product();
        for (Product p : listAllProducts()) {
            if (p.getId() == productID) {
                product.setId(p.getId());
                product.setInternalCode(p.getInternalCode());
                product.setProductionCode(p.getProductionCode());
                product.setBarCode(p.getBarCode());
                product.setBrandName(p.getBrandName());
                product.setReference(p.getReference());
                product.setProductShortDescription(p.getProductShortDescription());
                product.setProductExtendedDescription(p.getProductExtendedDescription());
                product.setProductTechnicalDescription(p.getProductTechnicalDescription());
                product.setPhotoPath(p.getPhotoPath());
                product.setProductCategory(p.getProductCategory());
                product.setPriceTaxes(p.getPriceTaxes());
                product.setPriceNoTaxes(p.getPriceNoTaxes());
                product.setLocation(p.getLocation());
            }
        }
        return product;
    }
}
