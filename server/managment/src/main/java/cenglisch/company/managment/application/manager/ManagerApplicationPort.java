package cenglisch.company.managment.application.manager;

import cenglisch.company.managment.domain.EventHandler;
import cenglisch.company.managment.domain.company.events.CompanyClosed;
import cenglisch.company.managment.domain.company.events.CompanyOpened;
import cenglisch.company.managment.domain.manager.ManagerRepository;
import cenglisch.company.managment.domain.manager.ManagerService;

public class ManagerApplicationPort {

    private final ManagerService managerService;

    private final ManagerRepository managerRepository;

    public ManagerApplicationPort(final ManagerService managerService, final ManagerRepository managerRepository, final EventHandler eventHandler) {
        this.managerService = managerService;
        this.managerRepository = managerRepository;

        eventHandler.subscribe(CompanyOpened.class, event -> {
            managerJoinsCompany(new ManagerJoinsCompany(event.managerId(), event.companyId()));
        });
        eventHandler.subscribe(CompanyClosed.class, event -> {
            managerLeaveCompany(new ManagerLeavesCompany( null, event.companyId()));
        });
    }

    public void newManager(final NewManager newManager){
        managerService.newManager(newManager.managerName());
    }

    public void managerJoinsCompany(final ManagerJoinsCompany managerJoinsCompany){
        managerService.joinCompany(managerJoinsCompany.managerId(), managerJoinsCompany.companyId());
    }

    public void managerLeaveCompany(final ManagerLeavesCompany managerLeavesCompany){
        managerService.joinCompany(managerLeavesCompany.managerId(), managerLeavesCompany.companyId());
    }
}
