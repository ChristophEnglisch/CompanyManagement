package cenglisch.hiring.port.adapter.secondary.persistence.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterviewJpaRepository extends JpaRepository<InterviewEntity, String> {
    Optional<InterviewEntity> findByCandidateId(String id);
}
