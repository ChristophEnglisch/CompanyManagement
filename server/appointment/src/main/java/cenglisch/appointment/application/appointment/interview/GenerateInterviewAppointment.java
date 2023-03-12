package cenglisch.appointment.application.appointment.interview;

import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterviewId;
import cenglisch.domain.model.PersonId;

public record GenerateInterviewAppointment(
    AppointmentInterviewId interviewId,
    PersonId personId
) {
}
