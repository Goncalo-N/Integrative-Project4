package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customer.application.RegisterAddressController;
import eapli.base.customer.application.RegisterCustomerController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBootstrapper {
    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);

    public boolean execute() {
        registerAddress("Rua das Coves", 23, "456-312", "Porto", "Portugal");
        registerAddress("Rua das Pedras", 5, "4657-111", "Espinho", "Portugal");
        registerAddress("Rua dos Milagres", 13, "456-312", "Aveiro", "Portugal");

        registerAddress("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1");
        registerAddress("Rua das Pedras1", 51, "4657-1111", "Espinho1", "Portugal1");
        registerAddress("Rua dos Milagres1", 131, "456-3121", "Aveiro1", "Portugal1");

        return true;
    }

    private void registerAddress(String name, int door_number, String postal_code, String city, String country) {

        final RegisterAddressController controller = new RegisterAddressController();

        try {
            controller.registerNewAddress(name, door_number, postal_code, city, country);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
