package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public record CandidateAdopted(CandidateId candidateId, JobId jobId) implements CandidateEventHiring {
    public String topic() {
        return CandidateEventHiring.super.topic() + ".adopted";
    }
}