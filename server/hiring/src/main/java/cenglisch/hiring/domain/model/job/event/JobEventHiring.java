package cenglisch.hiring.domain.model.job.event;

import cenglisch.hiring.domain.model.HiringDomainEvent;

public interface JobEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".job";
    }
}
