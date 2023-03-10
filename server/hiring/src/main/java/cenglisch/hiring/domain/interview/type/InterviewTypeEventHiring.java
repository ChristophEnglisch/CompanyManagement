package cenglisch.hiring.domain.interview.type;

import cenglisch.hiring.domain.HiringDomainEvent;

public interface InterviewTypeEventHiring extends HiringDomainEvent {
    default String topic() {
        return HiringDomainEvent.super.topic() + ".interview.type";
    }
}
