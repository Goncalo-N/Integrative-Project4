package eapli.base.warehouse.agv.domain;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class AGV implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @Embedded
    private AGV_MODEL model;
    private double max_weigth;
    private double volume;

    private AGVSTATE agvstate;

    @OneToOne
    private AGVDOCK agvdock;

    public AGV(){}

    public AGV(String description, AGV_MODEL model, double max_weigth, double volume, AGVDOCK agvdock) {
        this.description = description;
        this.model = model;
        this.max_weigth = max_weigth;
        this.volume = volume;
        this.agvdock = agvdock;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AGV{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", model=" + model +
                ", max_weigth=" + max_weigth +
                ", volume=" + volume +
                ", agvstate=" + agvstate +
                ", agvdock=" + agvdock +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AGV_MODEL getModel() {
        return model;
    }

    public void setModel(AGV_MODEL model) {
        this.model = model;
    }

    public double getMax_weigth() {
        return max_weigth;
    }

    public void setMax_weigth(double max_weigth) {
        this.max_weigth = max_weigth;
    }

    public double getVolume() {
        return volume;
    }

    public Long getId() {
        return id;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setAgvdock(AGVDOCK agvdock) {
        this.agvdock = agvdock;
    }

    public AGVDOCK getAgvdock() {
        return agvdock;
    }

    public AGVSTATE getAgvstate() {
        return agvstate;
    }

    public void setAgvstate(AGVSTATE agvstate) {
        this.agvstate = agvstate;
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
