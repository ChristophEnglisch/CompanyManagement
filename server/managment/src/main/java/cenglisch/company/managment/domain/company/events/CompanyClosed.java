package cenglisch.company.managment.domain.company.events;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.company.CompanyId;

public record CompanyClosed(CompanyId companyId) implements DomainEvent {

}
