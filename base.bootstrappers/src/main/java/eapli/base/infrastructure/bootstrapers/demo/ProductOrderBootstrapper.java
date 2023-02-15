package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.application.RegisterProductOrderController;
import eapli.base.warehouse.domain.*;
import eapli.base.warehouse.enums.PaymentMethodEnum;
import eapli.base.warehouse.enums.ShipmentMethodEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static eapli.base.warehouse.enums.ProductOrderStatusEnum.*;

public class ProductOrderBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);

    public boolean execute() {

        Customer customer1 = PersistenceContext.repositories().customerRepository().customerByID(1L);
        Customer customer2 = PersistenceContext.repositories().customerRepository().customerByID(2L);

        List<Line> listLine1 = new ArrayList<>();
        Line line1 = PersistenceContext.repositories().lineRepository().lineById(1);
        listLine1.add(line1);

        List<Line> listLine2 = new ArrayList<>();
        Line line2 =PersistenceContext.repositories().lineRepository().lineById(2);
        listLine2.add(line2);

        PaymentMethod paymentMethod = new PaymentMethod(PaymentMethodEnum.CARD);

        ProductOrderStatus orderStatus = new ProductOrderStatus(REGISTERED);
        ProductOrderStatus orderStatus2 = new ProductOrderStatus(READY_FOR_CARRIER_DISPATCHING);

        ShipmentMethod shipmentMethod = new ShipmentMethod(ShipmentMethodEnum.SHIP);

        AmountBeforeTaxes amountBeforeTaxes = new AmountBeforeTaxes(200);
        AmountBeforeTaxes amountBeforeTaxes2 = new AmountBeforeTaxes(300);

        AmountAfterTaxes amountAfterTaxes = new AmountAfterTaxes(300);
        AmountAfterTaxes amountAfterTaxes2 = new AmountAfterTaxes(400);

        registerProductOrder(paymentMethod,orderStatus,shipmentMethod,LocalDateTime.now(),amountBeforeTaxes,amountAfterTaxes,customer1,listLine1);
        registerProductOrder(paymentMethod,orderStatus2,shipmentMethod,LocalDateTime.now().plusHours(1),amountBeforeTaxes2,amountAfterTaxes2,customer2,listLine1);
        registerProductOrder(paymentMethod,orderStatus2,shipmentMethod,LocalDateTime.now().plusHours(2),amountBeforeTaxes2,amountAfterTaxes2,customer2,listLine2);
        registerProductOrder(paymentMethod,orderStatus2,shipmentMethod,LocalDateTime.now().plusHours(3),amountBeforeTaxes2,amountAfterTaxes2,customer1,listLine2);

        return true;
    }

    private void registerProductOrder(PaymentMethod paymentMethod, ProductOrderStatus productOrderStatus, ShipmentMethod shipmentMethod, LocalDateTime dateTime,
                                      AmountBeforeTaxes amountBeforeTaxes, AmountAfterTaxes amountAfterTaxes, Customer customer, List<Line> line) {

        final RegisterProductOrderController controller = new RegisterProductOrderController();

        try {
            controller.registerNewProductOrder(productOrderStatus,shipmentMethod,paymentMethod,dateTime,customer,line,amountBeforeTaxes,amountAfterTaxes);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
