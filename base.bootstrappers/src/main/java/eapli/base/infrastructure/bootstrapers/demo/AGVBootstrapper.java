package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agv.application.AGVController;
import eapli.base.warehouse.agv.domain.AGV_MODEL;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AGVBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);

    public boolean execute(){

        AGV_MODEL model1 = new AGV_MODEL("model1");
        AGV_MODEL model2 = new AGV_MODEL("model2");

        AGVDOCK dock1 = PersistenceContext.repositories().agvdockRepository().AGVDOCKByID(1L);
        AGVDOCK dock2 = PersistenceContext.repositories().agvdockRepository().AGVDOCKByID(2L);
        AGVDOCK dock3 = PersistenceContext.repositories().agvdockRepository().AGVDOCKByID(3L);

        registerAGV("AGV 1",model1,20.0,50.0,dock1);
        registerAGV("AGV 2",model1,20.0,50.0,dock2);
        registerAGV("AGV 1",model2,20.0,50.0,dock3);

        return true;
    }

    private void registerAGV(String description, AGV_MODEL model, double max_weitgth, double volume, AGVDOCK dock){
        final AGVController controller = new AGVController();

        try{
            controller.createNewAGV(description,model,max_weitgth,volume,dock);

        }catch (Exception e){
            System.out.println("------------------------------------------------------------------------------");
            e.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", e);
        }
    }

}
