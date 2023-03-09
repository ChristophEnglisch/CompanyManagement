package cenglisch.appointment.port.adapter.secondary.database.participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantJpaRepository extends JpaRepository<ParticipantEntity, String> {
}
