package cenglisch.appointment.domain.model.appointment.interview.event;

import cenglisch.appointment.domain.model.AppointmentDomainEvent;

public interface AppointmentInterviewEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".appointment.interview";
    }
}
