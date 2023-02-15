package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaCustomerRepository  extends BasepaRepositoryBase<Customer, String, String> implements CustomerRepository {

    public JpaCustomerRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public Customer customerByID(Long customerID){

        try{
            final TypedQuery<Customer> query = createQuery("SELECT m FROM Customer m WHERE m.id = :code", Customer.class);
            query.setParameter("code", customerID);
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
