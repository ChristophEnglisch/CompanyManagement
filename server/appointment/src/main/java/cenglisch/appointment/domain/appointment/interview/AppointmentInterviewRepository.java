package cenglisch.appointment.domain.appointment.interview;


import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.domain.model.Repository;

import java.util.Optional;

public interface AppointmentInterviewRepository extends Repository<AppointmentInterview, AppointmentInterviewId> {
    Optional<AppointmentInterview> findByAppointmentId(AppointmentId appointmentId);
}
