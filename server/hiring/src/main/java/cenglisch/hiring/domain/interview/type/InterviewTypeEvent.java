package cenglisch.hiring.domain.interview.type;

import cenglisch.hiring.domain.DomainEvent;

public interface InterviewTypeEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".interview.type";
    }
}
