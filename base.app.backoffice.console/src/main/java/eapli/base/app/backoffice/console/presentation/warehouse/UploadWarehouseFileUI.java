package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehouse.application.WarehouseController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


public class UploadWarehouseFileUI extends AbstractUI {

    private final WarehouseController controller = new WarehouseController();

    @Override
    protected boolean doShow() {
        final String jsonFile = Console.readLine("JSON FILE NAME:");


        try {
            this.controller.uploadJSONFile(jsonFile);
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Upload JSON File";
    }
}
