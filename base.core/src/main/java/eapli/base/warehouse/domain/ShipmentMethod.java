package eapli.base.warehouse.domain;

import eapli.base.warehouse.enums.PaymentMethodEnum;
import eapli.base.warehouse.enums.ShipmentMethodEnum;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * Classe que representa o metodo de envio de uma encomenda
 */
@Embeddable
public class ShipmentMethod implements ValueObject {

     /** Metodo de envio da encomenda */
     ShipmentMethodEnum shipmentMethod;

     /**
      * Construtor para ShipmentMethod
      * @param shipmentMethod metodo de envio da encomenda
      */
     public ShipmentMethod(ShipmentMethodEnum shipmentMethod) {
          this.shipmentMethod = shipmentMethod;
     }

     public ShipmentMethod() {

     }

     public boolean verify(ShipmentMethodEnum shipmentMethod){
          try{
               if(shipmentMethod==null){
                    throw new Exception("Shipment Method cannot be null");
               }
          } catch (Exception e) {
               e.printStackTrace();
               return false;
          }

          return false;
     }

     @Override
     public String toString() {
          return "ShipmentMethod{" +
                  "shipmentMethod=" + shipmentMethod +
                  '}';
     }
}
