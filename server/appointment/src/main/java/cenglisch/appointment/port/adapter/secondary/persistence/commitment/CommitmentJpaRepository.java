package cenglisch.appointment.port.adapter.secondary.persistence.commitment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommitmentJpaRepository extends JpaRepository<CommitmentEntity, String> {
    Collection<CommitmentEntity> findByAppointmentId(String id);
}
