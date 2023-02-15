package eapli.base.customer.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Gender;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.ProductOrder;

import java.util.ArrayList;
import java.util.List;

public class ListCustomer {

    private final CustomerRepository repository = PersistenceContext.repositories().customerRepository();

    public Iterable<Customer> listAllCustomers() {
        return this.repository.findAll();
    }

    public void updateCustomer(Customer customer) {this.repository.save(customer);}

    public Customer getCustomerByID(int customerID) {
        Customer customer = new Customer();
        for (Customer c : listAllCustomers()) {
            if (c.getId() == customerID) {
                customer.setId(c.getId());
                customer.setFirst_name(c.getFirst_name());
                customer.setLast_name(c.getLast_name());
                customer.setVatID(c.getVatID());
                customer.setPhone_number(c.getPhone_number());
                customer.setGender(c.getGender());
                customer.setEmail(c.getEmail());
                customer.setBirthday(c.getBirthday());
                customer.setAddresses(c.getAddresses());
            }
        }
        return customer;
    }

    public Customer getCustomerByName(String customerName) {
        Customer customer = new Customer();
        for (Customer c : listAllCustomers()) {
            if (c.getFirst_name().equals(customerName)) {
                customer.setId(c.getId());
                customer.setFirst_name(c.getFirst_name());
                customer.setLast_name(c.getLast_name());
                customer.setVatID(c.getVatID());
                customer.setPhone_number(c.getPhone_number());
                customer.setGender(c.getGender());
                customer.setEmail(c.getEmail());
                customer.setBirthday(c.getBirthday());
                customer.setAddresses(c.getAddresses());
            }
        }
        return customer;
    }

    public List<Customer> getCustomersByGender(Gender gender) {
        List<Customer> customers = new ArrayList<>();

        // Vai buscar todos os Customers
        for (Customer c : listAllCustomers()) {

            if(c.getGender() == gender)
                customers.add(c);
        }

        return customers;
    }
}
