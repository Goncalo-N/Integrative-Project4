package eapli.base.warehouse.repository;

import eapli.base.customer.domain.Customer;
import eapli.base.warehouse.domain.Line;
import eapli.framework.domain.repositories.DomainRepository;

public interface LineRepository extends DomainRepository<String, Line> {
    Line lineById(long id);
}
