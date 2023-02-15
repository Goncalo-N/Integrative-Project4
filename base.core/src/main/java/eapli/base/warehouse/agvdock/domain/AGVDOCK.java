package eapli.base.warehouse.agvdock.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class AGVDOCK implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Begin")
    private int begin;

    @Column(name="End")
    private int end;


    @Column(name="Depth")
    private int depth;

    private String accessibility;

    public AGVDOCK( int begin, int end, int depth,String accessibility) {
        this.begin = begin;
        this.end = end;
        this.depth= depth;

        this.accessibility = accessibility;
    }

    public AGVDOCK() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
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
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof AGVDOCK)) {
            return false;
        }

        final AGVDOCK that = (AGVDOCK) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


}
