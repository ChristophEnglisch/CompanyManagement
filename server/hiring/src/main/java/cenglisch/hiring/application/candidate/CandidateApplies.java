package cenglisch.hiring.application.candidate;

import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.domain.model.PersonId;

public record CandidateApplies(PersonId personId, JobId jobId) {
}
