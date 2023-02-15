package eapli.base.warehouse.domain;

import eapli.base.warehouse.enums.PaymentMethodEnum;
import eapli.base.warehouse.enums.ProductOrderStatusEnum;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * Classe que representa o Status de uma ProductOrder
 */
@Embeddable
public class ProductOrderStatus implements ValueObject {

    /** Status de uma ProductOrder */
    ProductOrderStatusEnum productOrderStatus;

    /**
     * Construtor para ProductOrderStatus
     * @param productOrderStatus Status da encomenda
     */
    public ProductOrderStatus(ProductOrderStatusEnum productOrderStatus) {
        this.productOrderStatus = productOrderStatus;
    }


    public ProductOrderStatus() {
        this.productOrderStatus= ProductOrderStatusEnum.REGISTERED;
    }

    public ProductOrderStatusEnum getProductOrderStatus() {
        return productOrderStatus;
    }

    public void setProductOrderStatus(ProductOrderStatusEnum productOrderStatus) {
        this.productOrderStatus = productOrderStatus;
    }

    public boolean verify(ProductOrderStatusEnum productOrderStatus){
        try{
            if(productOrderStatus==null){
                throw new Exception("Product Status cannot be changed to null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "ProductOrderStatus{" +
                "productOrderStatus=" + productOrderStatus +
                '}';
    }
}
