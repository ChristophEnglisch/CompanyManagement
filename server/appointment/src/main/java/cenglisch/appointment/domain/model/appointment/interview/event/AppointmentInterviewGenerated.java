package cenglisch.appointment.domain.model.appointment.interview.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewGenerated(AppointmentInterviewId appointmentInterviewId,
                                            AppointmentId appointmentId) implements AppointmentInterviewEvent{
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".generated";
    }
}
