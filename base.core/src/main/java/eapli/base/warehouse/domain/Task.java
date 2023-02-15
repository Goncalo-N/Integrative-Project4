package eapli.base.warehouse.domain;

import eapli.base.warehouse.agv.domain.AGV;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Task implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    ProductOrder order;

    AGV agv;

    public Task(ProductOrder order, AGV agv) {
        this.order = order;
        this.agv = agv;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductOrder getOrder() {
        return order;
    }

    public void setOrder(ProductOrder order) {
        this.order = order;
    }

    public AGV getAgv() {
        return agv;
    }

    public void setAgv(AGV agv) {
        this.agv = agv;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", order=" + order +
                ", agv=" + agv +
                '}';
    }
}
