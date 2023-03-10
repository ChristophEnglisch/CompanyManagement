package cenglisch.hiring.domain.person.event;

import cenglisch.hiring.domain.HiringDomainEvent;

public interface PersonEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".person";
    }
}
