package cenglisch.hiring.domain.candidate;


import cenglisch.domain.model.Repository;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.person.PersonId;

public interface CandidateRepository extends Repository<Candidate, CandidateId> {
    boolean existsByJobId(JobId jobId);

    boolean existsByPersonIdAndJobId(PersonId personId, JobId jobId);
}