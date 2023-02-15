package eapli.base.warehouse.agv.repositories;

import eapli.base.warehouse.agv.domain.AGV;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVRepository extends DomainRepository<String, AGV> {
     /**
      * Returns the AGV
      * @param agvId Id of the AGV to return
      * @return AGV
      */
     AGV agvById(long agvId);

     /**
      * Checks if AGV is registered in Data Base
      * @param agvId AGV to search
      * @return false if not registered, true if registered
      */
     boolean checkAGV(Long agvId);

     /**
      * Returns the first available AGV(idle for longer)
      * @return the AGV 
      */
     AGV getFirstAvailableAGV();
}
