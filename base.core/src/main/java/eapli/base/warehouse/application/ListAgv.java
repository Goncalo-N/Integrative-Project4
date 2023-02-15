package eapli.base.warehouse.application;

import eapli.base.warehouse.agv.domain.AGV;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.Task;
import eapli.base.warehouse.repository.TaskRepository;

public class ListAgv {

    private final AGVRepository repository = PersistenceContext.repositories().agvRepository();
    private final TaskRepository taskRepository = PersistenceContext.repositories().taskRepository();

    public Iterable<AGV> listAllAGVs() {
        return this.repository.findAll();
    }

    public AGV getAGVByID(long agvID) {
        AGV agv = new AGV();
        for (AGV l : listAllAGVs()) {
            if (l.getId() == agvID) {
                agv.setId(l.getId());
                agv.setAgvstate(l.getAgvstate());
                agv.setAgvdock(l.getAgvdock());
                agv.setDescription(l.getDescription());
                agv.setModel(l.getModel());
                agv.setVolume(l.getVolume());
                agv.setMax_weigth(l.getMax_weigth());
            }
        }
        return agv;
    }

    public void updateAGV(AGV agv) {
        repository.save(agv);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
