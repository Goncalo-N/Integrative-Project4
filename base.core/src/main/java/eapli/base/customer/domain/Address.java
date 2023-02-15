package eapli.base.customer.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address implements ValueObject, AggregateRoot<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int door_number;

    private String postal_code;

    private String city;

    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address() {
    }

    public Address(String name, int door_number, String postal_code, String city, String country) {
        this.name = name;
        this.door_number = door_number;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoor_number() {
        return door_number;
    }

    public void setDoor_number(int door_number) {
        this.door_number = door_number;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return door_number == address.door_number && Objects.equals(name, address.name) && Objects.equals(postal_code, address.postal_code) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, door_number, postal_code, city, country);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String toString() {
        return name + ", " + door_number + ", " + postal_code + ", " + city + ", " + country;
    }

    @Override
    public String identity() {
        return null;
    }
}
