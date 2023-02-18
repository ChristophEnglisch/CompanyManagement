package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.DomainEvent;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public interface CandidateEvent extends DomainEvent {
    CandidateId candidateId();

    JobId jobId();

    default String topic() {
        return DomainEvent.super.topic() + ".candidate";
    }
}
