package eapli.base.persistence.impl.jpa;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.ProductOrder;
import eapli.base.warehouse.domain.ProductOrderStatus;
import eapli.base.warehouse.enums.ProductOrderStatusEnum;
import eapli.base.warehouse.repository.ProductOrderRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaProductOrderRepository extends BasepaRepositoryBase<ProductOrder, String, String> implements ProductOrderRepository {

    public JpaProductOrderRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public ProductOrder productOrderByID(long orderID){
        final TypedQuery<ProductOrder> query = createQuery("SELECT m FROM ProductOrder m WHERE m.code = :dCode", ProductOrder.class);
        query.setParameter("oCode", orderID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public ProductOrder getFirstReadyProductOrder() {
        final TypedQuery<ProductOrder> query = createQuery("SELECT m FROM ProductOrder m WHERE m.orderStatus.producOrderStatus = :status", ProductOrder.class);
        query.setParameter("status", ProductOrderStatusEnum.READY_FOR_CARRIER_DISPATCHING);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<ProductOrder> getAllReadyProductOrders() {
        final TypedQuery<ProductOrder> query = createQuery("SELECT m FROM ProductOrder m WHERE m.orderStatus.producOrderStatus = :status", ProductOrder.class);
        query.setParameter("status", ProductOrderStatusEnum.READY_FOR_CARRIER_DISPATCHING);
        try{
            return query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public boolean updateProductOrderSentToClient(Long id) {

        try{
            ProductOrder productOrder = PersistenceContext.repositories().productOrderRepository().productOrderByID(id);
            productOrder.setOrderStatus(new ProductOrderStatus(ProductOrderStatusEnum.DISPATCHED));
            save(productOrder);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
