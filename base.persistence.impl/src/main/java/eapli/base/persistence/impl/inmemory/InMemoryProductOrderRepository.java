package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.ProductOrder;
import eapli.base.warehouse.repository.ProductOrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryProductOrderRepository extends InMemoryDomainRepository<ProductOrder, String> implements ProductOrderRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public ProductOrder productOrderByID(long orderID) {

        return null;
    }

    @Override
    public ProductOrder getFirstReadyProductOrder() {
        return null;
    }

    @Override
    public List<ProductOrder> getAllReadyProductOrders() {
        return null;
    }

    @Override
    public boolean updateProductOrderSentToClient(Long id) {
        return true;
    }


}
