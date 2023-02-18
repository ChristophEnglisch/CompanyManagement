package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public record CandidateAdopted(CandidateId candidateId, JobId jobId) implements CandidateEvent {
    public String topic() {
        return CandidateEvent.super.topic() + ".adopted";
    }
}