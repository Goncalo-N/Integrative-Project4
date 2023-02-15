package eapli.base.warehouse.aisle.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class coordinates implements ValueObject {

    @Column(insertable = false, updatable = false)
    private long lsquare;

    @Column(insertable = false, updatable = false)
    private long wsquare;

    public coordinates(final long lsquare, final long wsquare) {

        this.lsquare = lsquare;
        this.wsquare = wsquare;
    }

    public coordinates() {

    }

    public long getLsquare() {
        return lsquare;
    }

    public void setLsquare(long lsquare) {
        this.lsquare = lsquare;
    }

    public long getWsquare() {
        return wsquare;
    }

    public void setWsquare(long wsquare) {
        this.wsquare = wsquare;
    }

    public static coordinates valueOf(final long lsquare, final long wsquare) {
        return new coordinates(lsquare,wsquare);
    }

    @Override
    public String toString() {
        return "coordinates{" +
                "lsquare=" + lsquare +
                ", wsquare=" + wsquare +
                '}';
    }
}
