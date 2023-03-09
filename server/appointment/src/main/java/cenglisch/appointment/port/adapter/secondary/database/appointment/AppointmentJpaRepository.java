package cenglisch.appointment.port.adapter.secondary.database.appointment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentJpaRepository extends JpaRepository<AppointmentEntity, String> {
}
