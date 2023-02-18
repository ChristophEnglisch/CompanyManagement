package cenglisch.hiring.domain.interview;

import cenglisch.hiring.domain.Repository;
import cenglisch.hiring.domain.candidate.CandidateId;

import java.util.Optional;

public interface InterviewRepository extends Repository<Interview, InterviewId> {
    Optional<Interview> findByCandidateId(CandidateId candidateId);
}
