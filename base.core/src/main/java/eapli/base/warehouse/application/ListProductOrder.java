package eapli.base.warehouse.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Gender;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.domain.ProductOrder;
import eapli.base.warehouse.enums.ProductOrderStatusEnum;
import eapli.base.warehouse.repository.ProductOrderRepository;

import java.util.ArrayList;
import java.util.List;

public class ListProductOrder {

    private final ProductOrderRepository repository = PersistenceContext.repositories().productOrderRepository();

    public Iterable<ProductOrder> listAllProductOrders() {
        return this.repository.findAll();
    }

    public ProductOrder getProductOrderByID(long productID) {
        ProductOrder productOrder = new ProductOrder();
        for (ProductOrder l : listAllProductOrders()) {
            if (l.getId() == productID) {
                productOrder.setOrderStatus(l.getOrderStatus());
                productOrder.setPaymentMethod(l.getPaymentMethod());
                productOrder.setId(l.getId());
                productOrder.setCustomer(l.getCustomer());
                productOrder.setLine(l.getLine());
                productOrder.setLastUpdated(l.getLastUpdated());
                productOrder.setShipmentMethod(l.getShipmentMethod());
                productOrder.setTotal_amount_after_taxes(l.getTotal_amount_after_taxes());
                productOrder.setTotal_amount_before_taxes(l.getTotal_amount_before_taxes());
            }
        }
        return productOrder;
    }

    public List<ProductOrder> getALLProductOrderByStatus(ProductOrderStatusEnum productOrderStatus) {
        List<ProductOrder> listProductOrder = new ArrayList<>();

        for (ProductOrder l : listAllProductOrders()) {
            if (l.getOrderStatus().getProductOrderStatus() == productOrderStatus) {
                ProductOrder productOrder = new ProductOrder();
                productOrder.setOrderStatus(l.getOrderStatus());
                productOrder.setPaymentMethod(l.getPaymentMethod());
                productOrder.setId(l.getId());
                productOrder.setCustomer(l.getCustomer());
                productOrder.setLine(l.getLine());
                productOrder.setLastUpdated(l.getLastUpdated());
                productOrder.setShipmentMethod(l.getShipmentMethod());
                productOrder.setTotal_amount_after_taxes(l.getTotal_amount_after_taxes());
                productOrder.setTotal_amount_before_taxes(l.getTotal_amount_before_taxes());
                listProductOrder.add(productOrder);
            }
        }
        return listProductOrder;
    }

    public List<Customer> getCustomersByLines(List<Line> lines) {
        List<Customer> customers = new ArrayList<>();
        Customer customer;

        // Vai buscar todas as ProductOrders
        for (ProductOrder p : listAllProductOrders()) {
            // Vai buscar todas as Lines associadas à ProductOrder
            for (Line l : p.getLine()) {
                // Vai buscar todas as Lines associadas à lista lines
                for (Line l2 : lines) {
                    // Verifica se alguma Line da lista lines é igual a alguma Line da ProductOrder
                    if (l2 == l) {

                        // Se for então retira o Customer associado à ProductOrder e guarda na lista de Customers
                        customer = p.getCustomer();

                        customers.add(customer);
                    }
                }
            }
        }

        // Retira algum Customer repetido na lista
        for(Customer c1 : customers){
            customers.removeIf(c2 -> c1 == c2);
        }

        return customers;
    }
}
