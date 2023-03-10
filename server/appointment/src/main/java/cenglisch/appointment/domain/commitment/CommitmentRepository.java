package cenglisch.appointment.domain.commitment;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.domain.model.Repository;

import java.util.Collection;

public interface CommitmentRepository extends Repository<Commitment, CommitmentId> {

    Collection<Commitment> findByAppointmentId(AppointmentId appointmentId);
}
