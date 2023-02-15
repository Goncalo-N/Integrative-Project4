package eapli.base.persistence.impl.jpa;

import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaProductRepository extends BasepaRepositoryBase<Product, String, String> implements ProductRepository {

    public JpaProductRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

    @Override
    public Product productByID(String productID){
        final TypedQuery<Product> query = createQuery("SELECT m FROM Product m WHERE m.code = :dCode", Product.class);
        query.setParameter("cCode", productID);
        try{
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
