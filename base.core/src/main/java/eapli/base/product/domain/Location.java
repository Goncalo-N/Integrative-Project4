package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Location implements ValueObject {

    private int aisleId;
    private int rowId;
    private int shelfId;

    public Location() {
    }

    public Location(int aisleId, int rowId, int shelfId){
        this.aisleId = aisleId;
        this.rowId = rowId;
        this.shelfId = shelfId;
    }

    public int getAisleId() {
        return aisleId;
    }

    public void setAisleId(int aisleId) {
        this.aisleId = aisleId;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getAisleId() == location.getAisleId() && getRowId() == location.getRowId() && getShelfId() == location.getShelfId();
    }

    @Override
    public String toString() {
        return "Location{" +
                "aisleId=" + aisleId +
                ", rowId=" + rowId +
                ", shelfId=" + shelfId +
                '}';
    }
}
