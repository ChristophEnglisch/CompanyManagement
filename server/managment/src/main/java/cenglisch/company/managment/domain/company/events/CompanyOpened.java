package cenglisch.company.managment.domain.company.events;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.company.CompanyId;
import cenglisch.company.managment.domain.manager.ManagerId;

public record CompanyOpened(CompanyId companyId, ManagerId managerId) implements DomainEvent {}
