package eapli.base.warehouse.domain;

import eapli.base.product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Line implements ValueObject, AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;

    public Line() {
    }

    public Line(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }
}
