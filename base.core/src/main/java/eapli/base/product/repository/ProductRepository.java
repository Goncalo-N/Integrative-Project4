package eapli.base.product.repository;

import eapli.base.product.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

public interface ProductRepository extends DomainRepository<String, Product>  {

    public Product productByID(String productID);
}
