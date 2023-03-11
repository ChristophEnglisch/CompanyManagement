package cenglisch.appointment.application.appointment.interview;

import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterviewId;

public record GenerateInterviewAppointment(
    String candidateEmail,
    String candidateFullName,
    AppointmentInterviewId interviewId
) {
}
