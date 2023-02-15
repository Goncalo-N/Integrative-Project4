package eapli.base.warehouse.aisle.domain;

import eapli.base.warehouse.rows.domain.Rows;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aisle implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private coordinates begin;
    @Embedded
    private coordinates end;
    @Embedded
    private coordinates depth;
    private String accessibility;
    @OneToMany
    private List<Rows> rowsList;

    public Aisle(Long id, coordinates begin, coordinates end, coordinates depth, String accessibility, List<Rows> rowsList) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
        this.accessibility = accessibility;
        this.rowsList = rowsList;
    }

    public Aisle() {

    }

    public List<Rows> getRowsList() {
        return rowsList;
    }

    public void setRowsList(List<Rows> rowsList) {
        this.rowsList = rowsList;
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

    public coordinates getDepth() {
        return depth;
    }

    public void setDepth(coordinates depth) {
        this.depth = depth;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public String toString() {
        return "Aisle{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility='" + accessibility + '\'' +
                ", rowsList ='"+rowsList+'\''+
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Aisle)) {
            return false;
        }

        final Aisle that = (Aisle) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


}
