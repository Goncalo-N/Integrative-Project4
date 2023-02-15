package eapli.base.customer.application;

import eapli.base.customer.domain.Address;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ListAddresses {

    private final AddressRepository repository = PersistenceContext.repositories().addressRepository();

    public Iterable<Address> listAllAddresses() {
        return this.repository.findAll();
    }

    public Address getAddressByID(int addressID, Address address) {
        for (Address a : listAllAddresses()) {
            if (a.getId() == addressID) {
                address.setId(a.getId());
                address.setCity(a.getCity());
                address.setCountry(a.getCountry());
                address.setDoor_number(a.getDoor_number());
                address.setName(a.getName());
                address.setPostal_code(a.getPostal_code());
            }
        }
        return address;
    }
}
