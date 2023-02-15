package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.base.warehouse.aisle.repository.AisleRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaAisleRepository extends BasepaRepositoryBase<Aisle, String, String> implements AisleRepository {
    public JpaAisleRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public Aisle aisleByID(long aisleID){
        final TypedQuery<Aisle> query = createQuery("SELECT m FROM Aisle m WHERE m.code = :dCode", Aisle.class);
        query.setParameter("cCode", aisleID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}

