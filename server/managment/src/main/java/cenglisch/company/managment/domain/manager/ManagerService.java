package cenglisch.company.managment.domain.manager;

import cenglisch.company.managment.domain.EventHandler;
import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.manager.event.ManagerCreated;
import cenglisch.company.managment.domain.manager.event.ManagerEvent;
import cenglisch.company.managment.domain.manager.event.ManagerJoinedCompany;
import cenglisch.company.managment.domain.manager.event.ManagerLeftCompany;

import java.util.Optional;
import java.util.function.Consumer;

public class ManagerService {
    private final ManagerRepository managerRepository;
    private final EventHandler eventHandler;

    public ManagerService(ManagerRepository managerRepository, EventHandler eventHandler) {
        this.managerRepository = managerRepository;
        this.eventHandler = eventHandler;
    }

    private Optional<Manager> find(ManagerId managerId) {
        return managerRepository.findById(managerId);
    }

    public void newManager(String name) {
        Manager manager = this.managerRepository.save(new Manager(name));
        this.eventHandler.publish(new ManagerCreated(manager.getManagerId()));
    }

    public void joinCompany(ManagerId managerId, CompanyId companyId) {
        manageManager(
                managerId,
                manager -> manager.joinCompany(companyId),
                new ManagerJoinedCompany(managerId, companyId)
        );
    }

    public void leaveCompany(ManagerId managerId, CompanyId companyId) {
        manageManager(
                managerId,
                manager -> manager.leaveCompany(companyId),
                new ManagerLeftCompany(managerId, companyId)
        );
    }

    private void manageManager(ManagerId managerId, Consumer<Manager> action, ManagerEvent managerEvent){
        Manager manager = find(managerId).orElseThrow(ManagerNotFoundException::new);
        action.accept(manager);
        managerRepository.save(manager);
        eventHandler.publish(managerEvent);
    }
}