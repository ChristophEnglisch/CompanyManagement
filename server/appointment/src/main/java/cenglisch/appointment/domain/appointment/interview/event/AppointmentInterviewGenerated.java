package cenglisch.appointment.domain.appointment.interview.event;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewGenerated(AppointmentInterviewId appointmentInterviewId,
                                            AppointmentId appointmentId) implements AppointmentInterviewEvent{
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".generated";
    }
}
