package cenglisch.hiring.port.adapter.secondary.database.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, String> {
    boolean existsByJobId(String jobId);

    boolean existsByPersonIdAndJobId(String personId, String jobId);
}
