package cenglisch.appointment.domain.appointment;


import cenglisch.domain.model.Repository;

@org.jmolecules.ddd.annotation.Repository
public interface AppointmentRepository extends Repository<Appointment, AppointmentId> {
}
