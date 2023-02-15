package eapli.base.warehouse.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.domain.ProductOrder;
import eapli.base.warehouse.domain.ProductOrderStatus;
import eapli.base.warehouse.repository.LineRepository;
import eapli.base.warehouse.repository.ProductOrderRepository;

import java.util.List;

import static eapli.base.warehouse.enums.ProductOrderStatusEnum.DISPATCHED;

public class UpdateProductOrderController {

    private final ProductOrderRepository repository = PersistenceContext.repositories().productOrderRepository();
    private final ListProductOrder listProductOrder = new ListProductOrder();

    public List<ProductOrder> listReadyToUpdateProductOrder(){

        return repository.getAllReadyProductOrders();

    }

    public boolean UpdateProductOrder(Long id){

        try{
            ProductOrder productOrder = listProductOrder.getProductOrderByID(id);
            productOrder.setOrderStatus(new ProductOrderStatus(DISPATCHED));
            System.out.println(productOrder);

            repository.save(productOrder);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
