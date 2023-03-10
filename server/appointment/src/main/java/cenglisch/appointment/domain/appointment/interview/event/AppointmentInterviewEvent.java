package cenglisch.appointment.domain.appointment.interview.event;

import cenglisch.appointment.domain.AppointmentDomainEvent;

public interface AppointmentInterviewEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".appointment.interview";
    }
}
