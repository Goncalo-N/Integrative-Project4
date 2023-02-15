package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Address;
import eapli.base.customer.repository.AddressRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAddressRepository  extends InMemoryDomainRepository<Address, String> implements AddressRepository {

    static {
        InMemoryInitializer.init();
    }
}
