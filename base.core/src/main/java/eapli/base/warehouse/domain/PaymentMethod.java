package eapli.base.warehouse.domain;

import eapli.base.warehouse.enums.PaymentMethodEnum;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.Embeddable;

/**
 * PaymentMethod - é a class value object que define o tipo de pagamento de uma encomenda
 */
@Embeddable
public class PaymentMethod implements ValueObject {

    /**
     * Tipo de pagamento
     */
    PaymentMethodEnum paymentMethod;

    /**
     * Construtor para PaymentMethod
     * @param paymentMethod metodo de pagamento da encomenda
     */
    public PaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod() { }


    public boolean verify(PaymentMethodEnum paymentMethod){
        try{
            if(paymentMethod==null){
                throw new Exception("Payment method cannot be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethod=" + paymentMethod +
                '}';
    }
}
