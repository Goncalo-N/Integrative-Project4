package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Customer;
import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.repository.LineRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaLineRepository  extends BasepaRepositoryBase<Line, String, String> implements LineRepository {

    @Override
    public Line lineById(long id){
        final TypedQuery<Line> query = createQuery("SELECT m FROM Line m WHERE m.id = :id", Line.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    public JpaLineRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
