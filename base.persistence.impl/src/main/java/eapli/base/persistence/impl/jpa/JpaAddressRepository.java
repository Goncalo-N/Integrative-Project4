package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Address;
import eapli.base.customer.repository.AddressRepository;

public class JpaAddressRepository extends BasepaRepositoryBase<Address, String, String> implements AddressRepository {

    public JpaAddressRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
