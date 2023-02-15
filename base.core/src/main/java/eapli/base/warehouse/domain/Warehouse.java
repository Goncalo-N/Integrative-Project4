package eapli.base.warehouse.domain;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.framework.domain.model.AggregateRoot;
import org.springframework.security.core.Transient;

import javax.persistence.*;
import java.util.List;

@Entity
@Transient
public class Warehouse implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float length;
    private float width;
    private float square;
    private String unit;
    @OneToMany
    private List <Aisle> Aisles;
    @OneToMany
    private List <AGVDOCK> AGVDOCKS;

    protected Warehouse() {
    }

    public Warehouse(Long length, Long width, Long square, String unit, List<Aisle> aisles, List<AGVDOCK> AGVDOCKS) {
        checkLength(length);
        checkWidth(width);
        checkSquare(square);
        checkUnit(unit);
        checkAisle(aisles);
        checkAGV(AGVDOCKS);

        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
        Aisles = aisles;
        this.AGVDOCKS = AGVDOCKS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Aisle> getAisles() {
        return Aisles;
    }

    public void setAisles(List<Aisle> aisles) {
        Aisles = aisles;
    }

    public List<AGVDOCK> getAGVDOCKS() {
        return AGVDOCKS;
    }

    public void setAGVDOCKS(List<AGVDOCK> AGVDOCKS) {this.AGVDOCKS = AGVDOCKS;}

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                ", length=" + length +
                ", width=" + width +
                ", square=" + square +
                ", unit='" + unit + '\'' +
                ", Aisles=" + Aisles +
                ", AGVDOCKS=" + AGVDOCKS +
                '}';
    }

    private void checkLength(Long length)
    {
        if (length==null || length<0)
            throw new IllegalArgumentException("length cannot be null or negative.");

    }

    private void checkWidth(Long width)
    {
        if (width==null || width<0)
            throw new IllegalArgumentException("width cannot be null or negative.");

    }

    private void checkSquare(Long square)
    {  if (square==null || square<0)
        throw new IllegalArgumentException("square cannot be null or negative.");
    }

    private void checkUnit(String unit)
    {
        if (unit == null)
            throw new IllegalArgumentException("Units cannot be null.");
        if (unit.isEmpty())
            throw new IllegalArgumentException("Units cannot be empty.");
    }

    private void checkAisle(List<Aisle> Aisles)
    {
        if (Aisles == null || Aisles.isEmpty())
            throw new IllegalArgumentException("Aisles lists cannot be empty or null.");

    }


    private void checkAGV(List<AGVDOCK> AGVDOCKS)
    {
        if (AGVDOCKS == null || AGVDOCKS.isEmpty())
            throw new IllegalArgumentException("AGVDOCK lists cannot be empty or null.");

    }
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Warehouse)) {
            return false;
        }

        final Warehouse that = (Warehouse) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


}
