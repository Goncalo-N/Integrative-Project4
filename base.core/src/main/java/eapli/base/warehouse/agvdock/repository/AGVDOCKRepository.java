package eapli.base.warehouse.agvdock.repository;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVDOCKRepository  extends DomainRepository<String, AGVDOCK> {

     AGVDOCK AGVDOCKByID(Long AGVDOCKID);
}

