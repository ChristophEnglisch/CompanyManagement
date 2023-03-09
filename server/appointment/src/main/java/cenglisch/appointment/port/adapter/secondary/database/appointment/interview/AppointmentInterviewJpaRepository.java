package cenglisch.appointment.port.adapter.secondary.database.appointment.interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentInterviewJpaRepository extends JpaRepository<AppointmentInterviewEntity, String> {

    Optional<AppointmentInterviewEntity> findByAppointmentId(String id);
}
