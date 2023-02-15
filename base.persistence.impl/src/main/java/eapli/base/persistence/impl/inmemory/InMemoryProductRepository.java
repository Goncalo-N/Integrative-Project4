package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, String> implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Product productByID(String productID) {
        return null;
    }
}
