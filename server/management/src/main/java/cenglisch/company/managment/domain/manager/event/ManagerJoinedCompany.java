package cenglisch.company.management.domain.manager.event;

import cenglisch.company.management.domain.company.CompanyId;
import cenglisch.company.management.domain.manager.ManagerId;

public record ManagerJoinedCompany(ManagerId managerId, CompanyId companyId) implements ManagerEvent {
}