package eapli.base.app.backoffice.console.presentation.customer;

import eapli.base.customer.application.RegisterCustomerController;
import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Gender;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class    RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController controller = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        final String first_name = Console.readLine("First Name (<16): ");
        final String last_name = Console.readLine("Last Name (<16):");
        final String vatID = Console.readLine("VatID (<10):");
        final int phone_number = Console.readInteger("Phone Number (=9):");
        final Gender gender = Gender.valueOf(Console.readLine("Gender (Male/Female):"));
        final String email = Console.readLine("Email (<41):");

        System.out.println("Birthday Date (day/month/year):");
        final Birthday birthday = new Birthday();
        birthday.setDay(Console.readInteger("Day (<32):: "));
        birthday.setMonth(Console.readInteger("Month (<13): "));
        birthday.setYear(Console.readInteger("Year: "));

        List<Address> adresses = new ArrayList<>();
        System.out.println("Biling Address (name,door number,postal code,city,country):");
        final Address address1 = new Address();
        address1.setName(Console.readLine("Name (<31): "));
        address1.setDoor_number(Console.readInteger("Door number: "));
        address1.setPostal_code(Console.readLine("Postal Code: "));
        address1.setCity(Console.readLine("City: "));
        address1.setCountry(Console.readLine("Country: "));
        adresses.add(address1);

        System.out.println("Delivering Address (name,door number,postal code,city,country):");
        final Address address2 = new Address();
        address2.setName(Console.readLine("Name (<31): "));
        address2.setDoor_number(Console.readInteger("Door number: "));
        address2.setPostal_code(Console.readLine("Postal Code: "));
        address2.setCity(Console.readLine("City: "));
        address2.setCountry(Console.readLine("Country: "));
        adresses.add(address2);

        try {
            this.controller.registerNewCustomer(first_name, last_name, vatID, phone_number, gender, email, birthday, adresses);
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register New Customer";
    }
}
