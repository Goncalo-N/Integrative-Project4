package eapli.base.warehouse.rows.domain;

import eapli.base.warehouse.aisle.domain.coordinates;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Rows implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private coordinates begin;
    private coordinates end;
    private long shelves;

    public Rows(Long id, coordinates begin, coordinates end, Long shelves) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.shelves = shelves;
    }

    public Rows() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public coordinates getBegin() {
        return begin;
    }

    public void setBegin(coordinates begin) {
        this.begin = begin;
    }

    public coordinates getEnd() {
        return end;
    }

    public void setEnd(coordinates end) {
        this.end = end;
    }

    public long getShelves() {
        return shelves;
    }

    public void setShelves(long shelves) {
        this.shelves = shelves;
    }

    @Override
    public String toString() {
        return "Rows{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", shelves=" + shelves +
                '}';
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Rows)) {
            return false;
        }

        final Rows that = (Rows) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


}
