package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaAGVDOCKRepository extends BasepaRepositoryBase<AGVDOCK, String, String> implements AGVDOCKRepository {
    public JpaAGVDOCKRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public AGVDOCK AGVDOCKByID(Long agvdockID){
        final TypedQuery<AGVDOCK> query = createQuery("SELECT m FROM AGVDOCK m WHERE m.id = :code", AGVDOCK.class);
        query.setParameter("code", agvdockID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
