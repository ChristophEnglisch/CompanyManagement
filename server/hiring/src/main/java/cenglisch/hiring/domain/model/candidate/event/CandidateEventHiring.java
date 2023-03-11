package cenglisch.hiring.domain.model.candidate.event;

import cenglisch.hiring.domain.model.HiringDomainEvent;
import cenglisch.hiring.domain.model.candidate.CandidateId;
import cenglisch.hiring.domain.model.job.JobId;

public interface CandidateEventHiring extends HiringDomainEvent {
    CandidateId candidateId();

    JobId jobId();

    default String topic() {
        return HiringDomainEvent.super.topic() + ".candidate";
    }
}
