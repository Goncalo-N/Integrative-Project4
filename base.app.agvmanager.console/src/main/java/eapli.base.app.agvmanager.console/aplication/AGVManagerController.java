package eapli.base.app.agvmanager.console.aplication;

import eapli.base.warehouse.application.ListAgv;
import eapli.base.warehouse.application.ListProductOrder;

public class AGVManagerController {

    private final ListProductOrder listProductOrder = new ListProductOrder();

    private final ListAgv listAgv = new ListAgv();

    /*
    public void automaticSortAGV(){
        List<ProductOrder> productOrderList = listProductOrder.getALLProductOrderByStatus(READY_FOR_CARRIER_DISPATCHING);

        Iterable<AGV> agvList = listAgv.listAllAGVs();

        for(ProductOrder productOrder: productOrderList){
            Task task = new Task();

            for(AGV agv: agvList){

                if(agv.getAgvstate() == WAITING_INSTRUCTIONS){

                    task.setOrder(productOrder);
                    task.setAgv(agv);

                    agv.setAgvstate(OCUPIED);
                    listAgv.updateAGV(agv);

                    listAgv.saveTask(task);
                }
            }
        }
    }*/
}
