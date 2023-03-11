package cenglisch.appointment.domain.model.appointment.interview.event;

import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewFinished(AppointmentInterviewId appointmentInterviewId) implements AppointmentInterviewEvent{
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".launched";
    }
}
