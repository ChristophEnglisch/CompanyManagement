package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.AppointmentDomainEvent;

public interface AppointmentEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".appointment";
    }
}
