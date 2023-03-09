package cenglisch.appointment.domain.appointment.interview.event;

import cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewLaunched(AppointmentInterviewId appointmentInterviewId) implements AppointmentInterviewEvent{

}
