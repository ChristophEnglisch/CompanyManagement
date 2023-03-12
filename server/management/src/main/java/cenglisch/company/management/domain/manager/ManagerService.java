package cenglisch.company.management.domain.manager;

import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.manager.event.ManagerCreated;
import cenglisch.company.management.domain.manager.event.ManagerEvent;
import cenglisch.company.management.domain.manager.event.ManagerJoinedCompany;
import cenglisch.company.management.domain.manager.event.ManagerLeftCompany;
import cenglisch.domain.model.EventHandler;

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
        return managerRepository.find(managerId);
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