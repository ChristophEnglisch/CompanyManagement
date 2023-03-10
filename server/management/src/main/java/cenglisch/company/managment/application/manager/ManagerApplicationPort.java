package cenglisch.company.management.application.manager;

import cenglisch.company.management.domain.company.events.CompanyClosed;
import cenglisch.company.management.domain.company.events.CompanyOpened;
import cenglisch.company.management.domain.manager.ManagerService;
import cenglisch.domain.model.EventHandler;

public class ManagerApplicationPort {

    private final ManagerService managerService;

    public ManagerApplicationPort(final ManagerService managerService, final EventHandler eventHandler) {
        this.managerService = managerService;

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
        managerService.leaveCompany(managerLeavesCompany.managerId(), managerLeavesCompany.companyId());
    }
}
