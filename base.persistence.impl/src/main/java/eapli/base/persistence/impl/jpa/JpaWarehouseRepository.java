package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.repository.WarehouseRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, String, String> implements WarehouseRepository {
    public JpaWarehouseRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public Warehouse warehouseByID(long warehouseID){
        final TypedQuery<Warehouse> query = createQuery("SELECT m FROM Warehouse m WHERE m.code = :dCode", Warehouse.class);
        query.setParameter("cCode", warehouseID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}

