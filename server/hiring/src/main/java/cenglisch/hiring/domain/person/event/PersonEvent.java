package cenglisch.hiring.domain.person.event;

import cenglisch.hiring.domain.DomainEvent;

public interface PersonEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".person";
    }
}
