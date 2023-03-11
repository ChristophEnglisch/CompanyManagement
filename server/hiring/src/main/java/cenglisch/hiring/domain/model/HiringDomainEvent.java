package cenglisch.hiring.domain.model;

import cenglisch.domain.model.DomainEvent;

public interface HiringDomainEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() +  ".hiring";
    }
}
