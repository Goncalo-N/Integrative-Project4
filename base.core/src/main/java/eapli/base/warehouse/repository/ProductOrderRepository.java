package eapli.base.warehouse.repository;


import eapli.base.warehouse.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ProductOrderRepository  extends DomainRepository<String, ProductOrder> {

     ProductOrder productOrderByID(long orderID);

    /**
     * Finds the first Product Order that is ready for Shipment (created First)
     * @return Product Order
     */
     ProductOrder getFirstReadyProductOrder();


     List<ProductOrder> getAllReadyProductOrders();


    boolean updateProductOrderSentToClient(Long id);
}

