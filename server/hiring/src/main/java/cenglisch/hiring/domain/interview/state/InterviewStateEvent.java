package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.DomainEvent;
import cenglisch.hiring.domain.interview.InterviewId;

public interface InterviewStateEvent extends DomainEvent {
    InterviewId interviewId();


    default String topic() {
        return DomainEvent.super.topic() + ".interview.state";
    }
}
