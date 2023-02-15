package eapli.base.customer.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.customer.domain.Gender.Male;
import static org.junit.Assert.*;

public class CustomerTest {

    public CustomerTest() {

    }

    @Test
    public void testIdentity() {
        System.out.println("identity");

        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer instance = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
        String expResult = "Customer{id=null, first_name='António', last_name='Silva', vatID='12345ABC', phone_number=987657443, gender=Male, email='antonio@gmail.com', birthday=2/12/1999, addresses=[Rua das Coves, 23, 456-312, Porto, Portugal, Rua das Coves1, 231, 456-3121, Porto1, Portugal1]}";
        String result = instance.identity();
        assertEquals(expResult, result);
    }

    @Test
    public void testSameAs() {
        System.out.println("sameAs");

        //Tests for a null comparison
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer instance = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
        boolean result = instance.sameAs(null);
        assertFalse(result);

        //Tests for same fields but different first name
        Customer instance2 = new Customer("António1", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
        boolean result2 = instance.sameAs(instance2);
        assertFalse(result2);

        //Tests for equal object
        Customer instance3 = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
        boolean result3 = instance.sameAs(instance3);
        assertTrue(result3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFirstName() {
        System.out.println("checkFirstName");

        //Tests if first name is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer(null, "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

        //Tests if first name has less than 16 characters
        Customer customer2 = new Customer("abcdefdfdsdfgdgdasdas", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkLastName() {
        System.out.println("checkLastName");

        //Tests if last name is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", null, "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

        //Tests if last name has less than 16 characters
        Customer customer2 = new Customer("António", "abcdefdfdsdfgdgdasdas", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkVatID() {
        System.out.println("checkVatID");

        //Tests if vatID is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", "Silva", null, 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

        //Tests if vatID has less than 10 characters
        Customer customer2 = new Customer("António", "Silva", "123456789ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumber() {
        System.out.println("checkPhoneNumber");

        //Tests if phone number is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", "Silva", "12345ABC", 0, Male, "antonio@gmail.com", new Birthday(2,12,1999),adresses1 );

        //Tests if phone number is != than 9 digits
        Customer customer2 = new Customer("António", "Silva", "12345ABC", 957443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGender() {
        System.out.println("checkGender");

        //Tests if gender is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", "Silva", "12345ABC", 987657443, null, "antonio@gmail.com", new Birthday(2,12,1999), adresses1);

        //Tests if gender is != than Male or Female
        Customer customer2 = new Customer("António", "Silva", "12345ABC", 987657443, Gender.valueOf("abc"), "antonio@gmail.com", new Birthday(2,12,1999), adresses1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkEmail() {
        System.out.println("checkEmail");

        //Tests if email is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", "Silva", "12345ABC", 987657443, Male, null, new Birthday(2,12,1999), adresses1);

        //Tests if email has less than 41 digits
        Customer customer2 = new Customer("António", "Silva", "12345ABC", 987657443, Male, "ansudjfgfgdfrgtdfdfdsdfgrgrdtonio@gmail.com", new Birthday(2,12,1999), adresses1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkBirthday() {
        System.out.println("checkBirthday");

        //Tests if birthday is null
        List<Address> adresses1 = new ArrayList<>();
        adresses1.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses1.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));
        Customer customer = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(0,0,0), adresses1);

        //Tests if birthday day is less than 32
        Customer customer2 = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(45,12,1999), adresses1);

        //Tests if birthday month is less than 13
        Customer customer3 = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,17,1999), adresses1);
    }
}