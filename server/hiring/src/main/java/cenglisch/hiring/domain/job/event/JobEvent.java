package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.DomainEvent;

public interface JobEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".job";
    }
}
