package cenglisch.company.management.domain.company.events;

import cenglisch.company.management.domain.ManagementDomainEvent;
import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.manager.ManagerId;

public record CompanyOpened(CompanyId companyId, ManagerId managerId) implements ManagementDomainEvent {}
