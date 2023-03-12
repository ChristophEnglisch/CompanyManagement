package cenglisch.company.management.domain.manager.event;

import cenglisch.company.management.domain.ManagementDomainEvent;
import cenglisch.company.management.domain.manager.ManagerId;

public record ManagerCreated(ManagerId managerId) implements ManagementDomainEvent {
}