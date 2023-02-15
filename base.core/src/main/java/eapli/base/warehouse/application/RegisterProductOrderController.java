package eapli.base.warehouse.application;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.*;
import eapli.base.warehouse.repository.ProductOrderRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class RegisterProductOrderController {

    private final ProductOrderRepository repository = PersistenceContext.repositories().productOrderRepository();

    public void registerNewProductOrder(ProductOrderStatus productOrderStatus, ShipmentMethod shipment_method, PaymentMethod payment_method, LocalDateTime datetime, Customer customer,
                                        List<Line> line, AmountBeforeTaxes total_amount_before_taxes, AmountAfterTaxes total_amount_after_taxes) {
        final ProductOrder newProductOrder = new ProductOrder(payment_method,productOrderStatus,shipment_method,datetime,total_amount_before_taxes,total_amount_after_taxes,customer,line);

        this.repository.save(newProductOrder);
    }
}
