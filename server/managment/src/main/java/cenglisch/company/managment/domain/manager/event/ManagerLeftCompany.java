package cenglisch.company.managment.domain.manager.event;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.manager.ManagerId;

public record ManagerLeftCompany(ManagerId managerId, CompanyId companyId) implements ManagerEvent {
}
