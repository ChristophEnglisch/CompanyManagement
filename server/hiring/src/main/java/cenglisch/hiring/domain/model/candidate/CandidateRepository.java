package cenglisch.hiring.domain.model.candidate;


import cenglisch.domain.model.Repository;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.domain.model.PersonId;

public interface CandidateRepository extends Repository<Candidate, CandidateId> {
    boolean existsByJobId(JobId jobId);

    boolean existsByPersonIdAndJobId(PersonId personId, JobId jobId);
}