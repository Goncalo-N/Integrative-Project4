package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.warehouse.domain.Task;
import eapli.base.warehouse.repository.TaskRepository;

public class JpaTaskRepository extends BasepaRepositoryBase<Task, String, String> implements TaskRepository {


    public JpaTaskRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }

}
