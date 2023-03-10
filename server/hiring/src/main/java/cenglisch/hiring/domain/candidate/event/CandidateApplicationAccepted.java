package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public record CandidateApplicationAccepted(CandidateId candidateId, JobId jobId) implements CandidateEventHiring {
}
