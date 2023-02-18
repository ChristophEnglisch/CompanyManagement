package cenglisch.hiring.application.candidate;

import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.person.PersonId;

public record CandidateApplies(PersonId personId, JobId jobId) {
}
