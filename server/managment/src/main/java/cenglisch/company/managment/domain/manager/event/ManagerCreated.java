package cenglisch.company.managment.domain.manager.event;

import cenglisch.company.managment.domain.DomainEvent;
import cenglisch.company.managment.domain.manager.ManagerId;

public record ManagerCreated(ManagerId managerId) implements DomainEvent {
}