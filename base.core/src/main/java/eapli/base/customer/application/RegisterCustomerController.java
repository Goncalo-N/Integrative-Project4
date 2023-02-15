package eapli.base.customer.application;

import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Gender;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

public class RegisterCustomerController {

    private final CustomerRepository repository = PersistenceContext.repositories().customerRepository();

    public void registerNewCustomer(String first_name, String last_name, String vatID, int phone_number, Gender gender, String email, Birthday birthday,
                                    List<Address> adresses) {
        final Customer newCustomer = new Customer(first_name, last_name, vatID, phone_number, gender, email, birthday, adresses);

        this.repository.save(newCustomer);
    }
}
