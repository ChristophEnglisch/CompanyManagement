package cenglisch.appointment.domain.appointment.interview.event;

import cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewFinished(AppointmentInterviewId appointmentInterviewId) implements AppointmentInterviewEvent{
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".launched";
    }
}
