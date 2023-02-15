package eapli.base.app.backoffice.console.presentation.productorder;

import eapli.base.customer.application.ListCustomer;
import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.application.ListProduct;
import eapli.base.product.domain.Product;
import eapli.base.warehouse.application.RegisterProductOrderController;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.domain.ProductOrderStatus;
import eapli.base.warehouse.enums.ProductOrderStatusEnum;
import eapli.base.warehouse.repository.LineRepository;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterProductOrderUI extends AbstractUI {

    private final RegisterProductOrderController controller = new RegisterProductOrderController();
    private final ListCustomer listCustomerController = new ListCustomer();
    private final ListProduct listProductController = new ListProduct();

    @Override
    protected boolean doShow() {

        final int option1 = Console.readInteger("Would you like to type (1) or select the customer ID (2) ?");
        final int customerID;

        Customer customer = new Customer();

        if(option1 == 1){
            customerID = Console.readInteger("Type Customer ID: ");

            customer = listCustomerController.getCustomerByID(customerID);
        }
        else
        if(option1 == 2){
            Iterable<Customer> listaCustomers = listCustomerController.listAllCustomers();
            for(Customer c : listaCustomers){
                System.out.println("Customer " + c.getId() + ", " + c.getFirst_name() + " " + c.getLast_name());
            }

            customerID = Console.readInteger("Select Customer ID: ");

            customer = listCustomerController.getCustomerByID(customerID);
        }

        System.out.println("Address: " + customer.getAddresses());
        String optionAddress = Console.readLine("Do you want to change your billing/delivering addresses (Y/N) ?");

        if(optionAddress.equals("Y")){
            System.out.println("Billing address (name,door number,postal code,city,country):");
            final Address billing_address = new Address();
            billing_address.setName(Console.readLine("Name (<31): "));
            billing_address.setDoor_number(Console.readInteger("Door number: "));
            billing_address.setPostal_code(Console.readLine("Postal Code: "));
            billing_address.setCity(Console.readLine("City: "));
            billing_address.setCountry(Console.readLine("Country: "));

            System.out.println("Delivering address (name,door number,postal code,city,country):");
            final Address delivering_address = new Address();
            delivering_address.setName(Console.readLine("Name (<31): "));
            delivering_address.setDoor_number(Console.readInteger("Door number: "));
            delivering_address.setPostal_code(Console.readLine("Postal Code: "));
            delivering_address.setCity(Console.readLine("City: "));
            delivering_address.setCountry(Console.readLine("Country: "));

            List<Address> adresses = new ArrayList<>();
            adresses.add(billing_address);
            adresses.add(delivering_address);

            customer.setAddresses(adresses);
            CustomerRepository repository = PersistenceContext.repositories().customerRepository();
            repository.save(customer);
        }

        List<Line> listLines = new ArrayList<>();
        double total_amount_before_taxes = 0;
        double total_amount_after_taxes = 0;

        String option3 = "Y";
        while(option3.equals("Y")) {

            final int option2 = Console.readInteger("Would you like to type (1) or select the product ID (2) ?");
            final long productID;

            Product product = new Product();

            if (option2 == 1) {
                productID = Console.readLong("Type Product ID: ");

                product = listProductController.getProductByID(productID);
            } else if (option1 == 2) {
                Iterable<Product> listaProducts = listProductController.listAllProducts();
                for(Product p : listaProducts){
                    System.out.println("Product " + p.getInternalCode() + ", " + p.getProductShortDescription());
                }

                productID = Console.readLong("Select Product ID: ");

                product = listProductController.getProductByID(productID);
            }

            Line line = new Line();
            line.setProduct(product);
            line.setQuantity(Console.readInteger("Product quantity: "));

            LineRepository repository = PersistenceContext.repositories().lineRepository();
            repository.save(line);

            //ListLine listLine = new ListLine();
            //line = listLine.getLineID(line.getProduct(), line.getQuantity(), line);
            listLines.add(line);

            double amount_before_taxes = product.getPriceNoTaxes();
            double amount_after_taxes = product.getPriceTaxes();

            total_amount_before_taxes = total_amount_before_taxes + amount_before_taxes;
            total_amount_after_taxes = amount_after_taxes + amount_after_taxes;

            option3 = Console.readLine("Would you like to add more products to the order (Y/N) ?");

            while (!option3.equals("Y") && !option3.equals("N"))
                option3 = Console.readLine("Wrong answer! Would you like to add more products to the order (Y/N) ?");
        }

        final String shipment_method = Console.readLine("Shipment_method (Standard/Blue/Green):");
        final String payment_method = Console.readLine("Payment_method (Paypal/Visa):");
        Date date = new Date();

        try {
            //this.controller.registerNewProductOrder(ProductOrderStatusEnum.REGISTERED, shipment_method, payment_method, date, customer, listLines, total_amount_before_taxes, total_amount_after_taxes);
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register New Product Order";
    }
}
