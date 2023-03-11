package cenglisch.hiring.domain.model.person.event;

import cenglisch.hiring.domain.model.HiringDomainEvent;

public interface PersonEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".person";
    }
}
