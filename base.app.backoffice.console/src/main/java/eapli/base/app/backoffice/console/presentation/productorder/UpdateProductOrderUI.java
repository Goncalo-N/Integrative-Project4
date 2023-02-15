package eapli.base.app.backoffice.console.presentation.productorder;

import eapli.base.warehouse.application.ListProductOrder;
import eapli.base.warehouse.application.UpdateProductOrderController;
import eapli.base.warehouse.domain.ProductOrder;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import static eapli.base.warehouse.enums.ProductOrderStatusEnum.READY_FOR_CARRIER_DISPATCHING;

public class UpdateProductOrderUI extends AbstractUI {

    private final UpdateProductOrderController controller = new UpdateProductOrderController();
    private final ListProductOrder listProductOrder = new ListProductOrder();

    @Override
    protected boolean doShow() {
        System.out.println("Select One of the product Orders to Update as Sent to Client");

        for (ProductOrder order: listProductOrder.getALLProductOrderByStatus(READY_FOR_CARRIER_DISPATCHING)) {
            System.out.println(order);
        }

        try {
           return controller.UpdateProductOrder(Console.readLong("Insert the id of the Order to Update:"));
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String headline() {
        return "Update an Order as Sento to Customer";
    }
}
