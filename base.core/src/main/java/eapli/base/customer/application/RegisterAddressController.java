package eapli.base.customer.application;

import eapli.base.customer.domain.Address;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RegisterAddressController {

    private final AddressRepository repository = PersistenceContext.repositories().addressRepository();

    public void registerNewAddress(String name, int door_number, String postal_code, String city, String country) {
        final Address newAddress = new Address(name, door_number, postal_code, city, country);

        this.repository.save(newAddress);
    }
}
