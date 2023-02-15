package eapli.base.warehouse.agvdock.application;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AGVDOCKController {

    private final AGVDOCKRepository repository = PersistenceContext.repositories().agvdockRepository();

    public void registerNewAGVDOCK( int begin, int end, int depth,String accessibility) {
        final AGVDOCK newAGVDOCK = new AGVDOCK( begin, end, depth,accessibility);

        this.repository.save(newAGVDOCK);
    }

    public AGVDOCK agvdockById(Long id){
        return repository.AGVDOCKByID(id);
    }



}
