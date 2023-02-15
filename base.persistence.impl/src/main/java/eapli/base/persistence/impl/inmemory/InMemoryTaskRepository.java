package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Address;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.warehouse.domain.Task;
import eapli.base.warehouse.repository.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task, String> implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }
}
