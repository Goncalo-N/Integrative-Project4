package eapli.base.warehouse.enums;

/**
 *  ProductOrderStatusEnum - Define o estado de uma encomenda
 *  ON_HOLD - em fila de espera
 *  BEING_PREPARED - A encomenda está a ser preparada
 *  READY_FOR_DISPATCH - A encomenda está carregada e pronta a ser enviada ao cliente
 *  DISPATCHED - A encomenda foi enviada ao clinete
 */
public enum ProductOrderStatusEnum {
    REGISTERED, PAYMENT_PENDING, TO_BE_PREPARED, BEING_PREPARED_ON_THE_WAREHOUSE,
    READY_FOR_PACKAGING, READY_FOR_CARRIER_DISPATCHING, DISPATCHED,
    DELIVERED_BY_CARRIER, RECEIVED_BY_CUSTOMER;
}
