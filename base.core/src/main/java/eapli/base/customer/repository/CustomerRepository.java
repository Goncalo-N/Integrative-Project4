package eapli.base.customer.repository;

import eapli.base.customer.domain.Customer;
import eapli.framework.domain.repositories.DomainRepository;

public interface CustomerRepository  extends DomainRepository<String, Customer> {

     Customer customerByID(Long customerID);
}

