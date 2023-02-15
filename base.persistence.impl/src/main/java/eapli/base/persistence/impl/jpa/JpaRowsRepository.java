package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.rows.domain.Rows;
import eapli.base.warehouse.rows.repository.RowsRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaRowsRepository extends BasepaRepositoryBase<Rows, String, String> implements RowsRepository {
    public JpaRowsRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
    @Override
    public Rows rowsByID(long rowsID){
        final TypedQuery<Rows> query = createQuery("SELECT m FROM Rows m WHERE m.code = :dCode", Rows.class);
        query.setParameter("cCode", rowsID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

}


