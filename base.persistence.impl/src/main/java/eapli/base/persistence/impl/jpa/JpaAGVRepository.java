package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.agv.domain.AGV;
import eapli.base.warehouse.agv.domain.AGVSTATE;
import eapli.base.warehouse.agv.repositories.AGVRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaAGVRepository extends BasepaRepositoryBase<AGV, String, String> implements AGVRepository {

    public JpaAGVRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public AGV agvById(long agvId){
        final TypedQuery<AGV> query = createQuery("SELECT m FROM AGV m WHERE m.code = :dCode", AGV.class);
        query.setParameter("gCode", agvId);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public boolean checkAGV(Long agvId) {

        final TypedQuery<AGV> query = createQuery("SELECT m FROM AGV m WHERE m.code = :dCode", AGV.class);
        query.setParameter("gCode", agvId);
        try{
            if(query.getSingleResult().getId()==agvId)
                return true;
            return false;
        } catch(NoResultException e){
            System.out.println(e);
            return false;
        }
    }



    @Override
    public AGV getFirstAvailableAGV() {
        final TypedQuery<AGV> query = createQuery("SELECT m FROM AGV m WHERE m.agvstate = :state",AGV.class);
        query.setParameter("state", AGVSTATE.WAITING_INSTRUCTIONS);
        try {
            return query.getSingleResult();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
