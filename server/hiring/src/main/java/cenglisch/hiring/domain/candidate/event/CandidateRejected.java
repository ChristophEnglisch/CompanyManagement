package cenglisch.hiring.domain.candidate.event;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.job.JobId;

public record CandidateRejected(CandidateId candidateId, JobId jobId) implements CandidateEvent {

}