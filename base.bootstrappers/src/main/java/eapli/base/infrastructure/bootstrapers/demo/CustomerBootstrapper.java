package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customer.application.ListAddresses;
import eapli.base.customer.application.RegisterCustomerController;
import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Gender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.customer.domain.Gender.Female;
import static eapli.base.customer.domain.Gender.Male;

public class CustomerBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);

    public boolean execute() {

        ListAddresses listAddresses = new ListAddresses();

        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(listAddresses.getAddressByID(1,new Address()));
        adresses1.add(listAddresses.getAddressByID(2,new Address()));

        List<Address> adresses2 = new ArrayList<>();
        adresses1.add(listAddresses.getAddressByID(3,new Address()));
        adresses1.add(listAddresses.getAddressByID(4,new Address()));

        List<Address> adresses3 = new ArrayList<>();
        adresses1.add(listAddresses.getAddressByID(5,new Address()));
        adresses1.add(listAddresses.getAddressByID(6,new Address()));

        register("antonioSilva", "Pereira", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999),adresses1);
        register("fabioCorreia", "Nogueira", "23146TYU", 916234212, Male, "fabio@gmail.com", new Birthday(24,4,2001),adresses2);
        register("mariaTeixeira", "Carvalho", "67678WEQ", 923121112, Female, "maria@gmail.com", new Birthday(15,8,1987),adresses3);
        register("tiagoFonseca", "Fonseca", "34265RTY", 564789678, Male, "tiago@gmail.com", new Birthday(2,2,1985),adresses2);
        register("anaPereira", "Pereira", "77789YUY", 345444456, Female, "ana@gmail.com", new Birthday(19,5,1998),adresses1);

        return true;
    }

    private void register(String first_name, String last_name, String vatID, int phone_number, Gender gender, String email, Birthday birthday,
                          List<Address> adresses) {

        RegisterCustomerController controller = new RegisterCustomerController();

        try {

            controller.registerNewCustomer(first_name, last_name, vatID, phone_number, gender, email, birthday, adresses);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
