package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.HiringDomainEvent;

public interface JobEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".job";
    }
}
