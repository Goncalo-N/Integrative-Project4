package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmountAfterTaxes implements ValueObject {

    @Column(insertable = false,updatable = false)
    private float amount;

    public AmountAfterTaxes(float amount){
        this.amount = amount;
    }

    public AmountAfterTaxes() {

    }

    public boolean verify(float amount){
        try{
            if(amount<=0){
                throw new Exception("Value cannot be 0 or negative");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "AmountAfterTaxes{" +
                "amount=" + amount +
                '}';
    }
}
