package cenglisch.company.management.domain.company.events;

import cenglisch.company.management.domain.ManagementDomainEvent;
import cenglisch.company.management.domain.company.CompanyId;

public record CompanyClosed(CompanyId companyId) implements ManagementDomainEvent {

}
