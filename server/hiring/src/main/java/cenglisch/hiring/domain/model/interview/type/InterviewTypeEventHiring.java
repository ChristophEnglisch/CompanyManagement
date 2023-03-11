package cenglisch.hiring.domain.model.interview.type;

import cenglisch.hiring.domain.model.HiringDomainEvent;

public interface InterviewTypeEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".interview.type";
    }
}
