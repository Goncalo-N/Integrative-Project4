package eapli.base.warehouse.domain;

import eapli.base.customer.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que representa uma ProductOrder
 */

@Entity
public class ProductOrder implements AggregateRoot<String> {


    /** id da class ProductOrder */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /** Tipo de pagamento efetuado */
    @Embedded
    PaymentMethod paymentMethod;
    /** Status da encomenda */
    @Embedded
    ProductOrderStatus orderStatus;
    /** Tipo de envio da encomenda */
    @Embedded
    ShipmentMethod shipmentMethod;
    /** Ultima vez que a encomenda foi atualizada */
    LocalDateTime lastUpdated;

    @Embedded
    AmountBeforeTaxes total_amount_before_taxes;

    @Embedded
    AmountAfterTaxes total_amount_after_taxes;

    @ManyToOne
    private Customer customer;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Line> line;

    public ProductOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ProductOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /** Construtor vazio */
    public ProductOrder() {}


    /**
     * Contrutor para ProductOrder
     * @param paymentMethod tipo de pagamento
     * @param orderStatus Status da encomenda
     * @param shipmentMethod Tipo de envio
     * @param lastUpdated Data da ultima vez que foi atualizada
     */
    public ProductOrder( PaymentMethod paymentMethod, ProductOrderStatus orderStatus, ShipmentMethod shipmentMethod, LocalDateTime lastUpdated) {
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.shipmentMethod = shipmentMethod;
        this.lastUpdated = lastUpdated;
    }

    public ProductOrder( PaymentMethod paymentMethod, ProductOrderStatus orderStatus, ShipmentMethod shipmentMethod, LocalDateTime lastUpdated, AmountBeforeTaxes total_amount_before_taxes, AmountAfterTaxes total_amount_after_taxes, Customer customer, List<Line> line) {
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.shipmentMethod = shipmentMethod;
        this.lastUpdated = lastUpdated;
        this.total_amount_before_taxes = total_amount_before_taxes;
        this.total_amount_after_taxes = total_amount_after_taxes;
        this.customer = customer;
        this.line = line;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public AmountBeforeTaxes getTotal_amount_before_taxes() {
        return total_amount_before_taxes;
    }

    public void setTotal_amount_before_taxes(AmountBeforeTaxes total_amount_before_taxes) {
        this.total_amount_before_taxes = total_amount_before_taxes;
    }

    public AmountAfterTaxes getTotal_amount_after_taxes() {
        return total_amount_after_taxes;
    }

    public void setTotal_amount_after_taxes(AmountAfterTaxes total_amount_after_taxes) {
        this.total_amount_after_taxes = total_amount_after_taxes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Line> getLine() {
        return line;
    }

    public void setLine(List<Line> line) {
        this.line = line;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", paymentMethod=" + paymentMethod +
                ", orderStatus=" + orderStatus +
                ", shipmentMethod=" + shipmentMethod +
                ", lastUpdated=" + lastUpdated +
                ", total_amount_before_taxes=" + total_amount_before_taxes +
                ", total_amount_after_taxes=" + total_amount_after_taxes +
                ", customer=" + customer +
                ", line=" + line +
                '}';
    }
}
