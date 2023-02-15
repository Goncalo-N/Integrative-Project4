package eapli.base.productorder.domain;

import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Customer;
import eapli.base.product.domain.Location;
import eapli.base.product.domain.Photo;
import eapli.base.product.domain.Product;
import eapli.base.warehouse.domain.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static eapli.base.customer.domain.Gender.Male;
/**
public class ProductOrderTest {

    /**
    public ProductOrder ProductOrderTest(){

        List<Address> adresses = new ArrayList<>();
        adresses.add(new Address("Rua das Coves", 23, "456-312", "Porto", "Portugal"));
        adresses.add(new Address("Rua das Coves1", 231, "456-3121", "Porto1", "Portugal1"));

        Customer customer = new Customer("António", "Silva", "12345ABC", 987657443, Male, "antonio@gmail.com", new Birthday(2,12,1999), adresses);

        Product product = new Product("123ABC","A343FSD",12345,"Contintente","343FD4GF","Lenços",
                "Lenços de Papel de cozinha","Caixa de Lenços de Papel", Collections.singletonList(new Photo("photo1.png")),
                "Utensílios de Cozinha", 1.0, 1.5,new Location(1,1,1));

        List<Line> listLine = new ArrayList<>();
        Line line = new Line(product, 5);
        listLine.add(line);

        return new ProductOrder(ProductOrderStatus.REGISTERED,"Blue","PayPal",new Date(), customer,listLine, 3,4.5);
    }

    /*@Test(expected = AssertionError.class)
    public void checkProductOrderStatus() {
        System.out.println("checkProductOrderStatus");

        //Tests if ProductOrderStatus is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setProductOrderStatus(null);
    }*/

    /**
    @Test(expected = IllegalArgumentException.class)
    public void checkShipment_method() {
        System.out.println("checkShipment_method");

        //Tests if Shipment_method is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setShipment_method(null);

        //Tests if Shipment_method is different from Standard or Blue or Green
        productOrder.setShipment_method("teste");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPayment_method() {
        System.out.println("checkPayment_method");

        //Tests if Payment_method is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setPayment_method(null);

        //Tests if Payment_method is different from PayPal or Visa
        productOrder.setPayment_method("teste");
    }

    /*@Test(expected = AssertionError.class)
    public void checkDatetime() {
        System.out.println("checkDatetime");

        //Tests if Datetime is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setDatetime(null);
    }*/

    /*@Test(expected = AssertionError.class)
    public void checkCustomer() {
        System.out.println("checkCustomer");

        //Tests if Customer is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setCustomer(null);
    }*/

    /*@Test(expected = AssertionError.class)
    public void checkLine() {
        System.out.println("checkLine");

        //Tests if Line is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setLine(null);
    }*/
/**
    @Test(expected = IllegalArgumentException.class)
    public void checkTotal_amount_before_taxes() {
        System.out.println("checkTotal_amount_before_taxes");

        //Tests if total_amount_before_taxes is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setTotal_amount_before_taxes(0);

        //Tests if total_amount_before_taxes is negative
        productOrder.setTotal_amount_before_taxes(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTotal_amount_after_taxes() {
        System.out.println("checkTotal_amount_after_taxes");

        //Tests if total_amount_after_taxes is null
        ProductOrder productOrder = ProductOrderTest();
        productOrder.setTotal_amount_after_taxes(0);

        //Tests if total_amount_after_taxes is negative
        productOrder.setTotal_amount_after_taxes(-2);
    }
}
*/