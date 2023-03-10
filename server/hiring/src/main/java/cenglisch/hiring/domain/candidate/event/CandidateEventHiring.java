package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.HiringDomainEvent;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public interface CandidateEventHiring extends HiringDomainEvent {
    CandidateId candidateId();

    JobId jobId();

    default String topic() {
        return HiringDomainEvent.super.topic() + ".candidate";
    }
}
