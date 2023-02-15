package eapli.base.warehouse.agv.application;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.agv.domain.AGV;
import eapli.base.warehouse.agv.domain.AGVSTATE;
import eapli.base.warehouse.agv.domain.AGV_MODEL;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AGVController {
    private final AGVRepository repository = PersistenceContext.repositories().agvRepository();

    public void createNewAGV(String description, AGV_MODEL model, double max_weigth, double volume, AGVDOCK agvdock){
        final AGV newAGV =new AGV(description,model,max_weigth,volume,agvdock);
        this.repository.save(newAGV);
    }

    public AGV getAGVByID(Long id){
        return repository.agvById(id);
    }

    public AGV updateAGV(Long id, String description, AGV_MODEL model, double max_weigth, double volume, AGVDOCK agvdock){

        AGV targetAGV = this.repository.agvById(id);

        targetAGV.setDescription(description);
        targetAGV.setModel(model);
        targetAGV.setMax_weigth(max_weigth);
        targetAGV.setVolume(volume);
        targetAGV.setAgvdock(agvdock);
        targetAGV.setAgvstate(AGVSTATE.WAITING_INSTRUCTIONS);

        this.repository.save(targetAGV);

        return targetAGV;

    }







}
