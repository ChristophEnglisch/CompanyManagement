package cenglisch.hiring.domain.model.interview.state;

import cenglisch.hiring.domain.model.HiringDomainEvent;
import cenglisch.hiring.domain.model.interview.InterviewId;

public interface InterviewStateEventHiring extends HiringDomainEvent {
    InterviewId interviewId();


    default String topic() {
        return HiringDomainEvent.super.topic() + ".interview.state";
    }
}
