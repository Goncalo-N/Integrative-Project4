package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouse.agvdock.application.AGVDOCKController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AGVDOCKBootstraper {

    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);

    public boolean execute(){

        registerAGVDOCK(1,2,3,"a1");
        registerAGVDOCK(4,5,6,"a1");
        registerAGVDOCK(7,8,9,"a1");


        return true;
    }

    private void registerAGVDOCK( int c1, int c2, int c3, String ac){
        final AGVDOCKController controller = new AGVDOCKController();

        try{
            controller.registerNewAGVDOCK(c1,c2,c3,ac);

        }catch (Exception e){
            System.out.println("------------------------------------------------------------------------------");
            e.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
