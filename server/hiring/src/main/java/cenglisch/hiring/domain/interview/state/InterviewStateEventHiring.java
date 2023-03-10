package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.HiringDomainEvent;
import cenglisch.hiring.domain.interview.InterviewId;

public interface InterviewStateEventHiring extends HiringDomainEvent {
    InterviewId interviewId();


    default String topic() {
        return HiringDomainEvent.super.topic() + ".interview.state";
    }
}
