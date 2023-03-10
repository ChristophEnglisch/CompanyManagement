package cenglisch.hiring.domain;

import cenglisch.domain.model.DomainEvent;

public interface HiringDomainEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() +  ".hiring";
    }
}
