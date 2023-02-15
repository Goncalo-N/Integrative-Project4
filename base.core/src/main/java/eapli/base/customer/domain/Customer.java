package eapli.base.customer.domain;

import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

import java.util.List;

import static eapli.base.customer.domain.Gender.Female;
import static eapli.base.customer.domain.Gender.Male;

@Entity
public class Customer implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String vatID;
    private int phone_number;
    private Gender gender;
    private String email;

    @Embedded
    private Birthday birthday;

    @ManyToMany
    private List<Address> addresses;

    public Customer() {
    }

    public Customer(String first_name, String last_name, String vatID, int phone_number, Gender gender, String email, Birthday birthday, List<Address> addresses) {
        checkFirstName(first_name);
        checkLastName(last_name);
        checkVatId(vatID);
        checkPhoneNumber(phone_number);
        checkGender(gender);
        checkEmail(email);
        checkBirthday(birthday);
        checkAddress(addresses);

        this.first_name = first_name;
        this.last_name = last_name;
        this.vatID = vatID;
        this.phone_number = phone_number;
        this.gender = gender;
        this.email = email;
        this.birthday = birthday;
        this.addresses = addresses;
    }

    @Override
    public String identity() {
        //Customer customer = new Customer(this.first_name,this.last_name,this.vatID,this.phone_number,this.gender,this.email,this.birthday,this.addresses);
        //return String.valueOf(customer);
        return String.valueOf(this.id);
    }

    private void checkFirstName(String first_name)
    {
        if (StringUtils.isBlank(first_name))
            throw new IllegalArgumentException("First name cannot be blank.");
        if (first_name.length() > 15)
            throw new IllegalArgumentException("First name must have less than 16 characters.");
    }

    private void checkLastName(String last_name)
    {
        if (StringUtils.isBlank(last_name))
            throw new IllegalArgumentException("Last name cannot be blank.");
        if (last_name.length() > 15)
            throw new IllegalArgumentException("Last name must have less than 16 characters.");
    }

    private void checkVatId(String vatID)
    {
        if (StringUtils.isBlank(vatID))
            throw new IllegalArgumentException("VatID cannot be blank.");
        if (vatID.length() > 9)
            throw new IllegalArgumentException("VatID must have less than 10 characters.");
    }

    private void checkPhoneNumber(int phone_number)
    {
        String k = String.valueOf(phone_number);
        if (StringUtils.isBlank(k))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (k.length() != 9)
            throw new IllegalArgumentException("Phone number must have 9 digits.");
    }

    private void checkGender(Gender gender)
    {
        String k = String.valueOf(gender);
        if (StringUtils.isBlank(k))
            throw new IllegalArgumentException("Gender cannot be blank.");
        if (!k.equals(String.valueOf(Male)) && !k.equals(String.valueOf(Female)))
            throw new IllegalArgumentException("Gender must be Male or Female.");
    }

    private void checkEmail(String email)
    {
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email cannot be blank.");
        if (email.length() > 40)
            throw new IllegalArgumentException("Email must have less than 41 characters.");
    }

    private void checkBirthday(Birthday birthday)
    {
        if (StringUtils.isBlank(String.valueOf(birthday)))
            throw new IllegalArgumentException("Birthday cannot be blank.");
        if (birthday.getDay() > 31)
            throw new IllegalArgumentException("Birthday day must be less than 32");
        if (birthday.getMonth() > 12)
            throw new IllegalArgumentException("Birthday month must be less than 32");
    }

    private void checkAddress(List<Address> address)
    {
        if (StringUtils.isBlank(String.valueOf(address)))
            throw new IllegalArgumentException("Address cannot be blank.");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getVatID() {
        return vatID;
    }

    public void setVatID(String vatID) {
        this.vatID = vatID;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Customer)) {
            return false;
        }

        final Customer that = (Customer) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", vatID='" + vatID + '\'' +
                ", phone_number=" + phone_number +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", addresses=" + addresses +
                '}';
    }
}
