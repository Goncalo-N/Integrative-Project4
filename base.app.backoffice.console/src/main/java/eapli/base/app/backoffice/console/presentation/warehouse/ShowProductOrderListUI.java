package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehouse.application.WarehouseController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ShowProductOrderListUI extends AbstractUI {

    WarehouseController warehouseController = new WarehouseController();





    @Override
    protected boolean doShow() {
        System.out.println("-------------------------");
        System.out.println("List of Product Orders ready to ship for a costumer:");
        System.out.print(warehouseController.getAllReadyProductOrders());
        final Long orderId = Console.readLong("Enter the ID of the Order you wish to Update as 'sent to Costumer' ");
        try{
            warehouseController.updateProductOrderToSentToClient(warehouseController.getProductOrderById(orderId));
        }catch (Exception e){
            System.out.println("ProductOrder Failed to Update");
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Starting to update Product Orders ";
    }
}
