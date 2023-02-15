package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehouse.agvdock.application.AGVDOCKController;
import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agv.application.AGVController;
import eapli.base.warehouse.agv.domain.AGV_MODEL;
import eapli.base.warehouse.application.WarehouseController;
import eapli.base.warehouse.domain.Warehouse;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class WarehouseUI extends AbstractUI {

    private final WarehouseController controller = new WarehouseController();

    public void updateAGV(){
        final AGVController AGVcontroller = new AGVController();
        final AGVDOCKController AGVDOCKcontroller = new AGVDOCKController();
        System.out.println("*** UpdateAGV started***\n");
        Long warehouseId= Console.readLong("Enter the id of the wanted warehouse:");
        Warehouse warehouse = controller.getWarehouseById(warehouseId);
        Long AGVIDid = Console.readLong("Enter the id of the AGV to update:\n");
        System.out.println(AGVcontroller.getAGVByID(AGVIDid).toString());
        System.out.println("Enter the information you want to alter\n If you wish to mantain any parameter enter it");

        final String description = Console.readLine("Description:\n");

        AGV_MODEL AVG_MODEL= new AGV_MODEL(Console.readLine("model:\n"));



        final Double max_weigth = Console.readDouble("max_weigth:\n");
        final Double volume = Console.readDouble("volume:\n");

        final Long AGVDOCKID = Console.readLong("AGVDOCKID:\n");
        final AGVDOCK agvdock = AGVDOCKcontroller.agvdockById(AGVDOCKID);

        try {
            this.controller.updateAGV(AGVIDid,description,AVG_MODEL,max_weigth,volume,agvdock);
        }catch (Exception e){
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }
    }



    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
