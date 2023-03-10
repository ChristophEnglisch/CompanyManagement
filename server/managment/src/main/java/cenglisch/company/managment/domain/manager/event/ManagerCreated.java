package cenglisch.company.managment.domain.manager.event;

import cenglisch.company.managment.domain.ManagementDomainEvent;
import cenglisch.company.managment.domain.manager.ManagerId;

public record ManagerCreated(ManagerId managerId) implements ManagementDomainEvent {
}