package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, String> implements CustomerRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Customer customerByID(Long customerID) {
        return null;
    }
}
