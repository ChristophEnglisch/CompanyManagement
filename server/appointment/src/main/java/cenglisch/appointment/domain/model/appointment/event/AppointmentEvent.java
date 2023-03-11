package cenglisch.appointment.domain.model.appointment.event;

import cenglisch.appointment.domain.model.AppointmentDomainEvent;

public interface AppointmentEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".appointment";
    }
}
