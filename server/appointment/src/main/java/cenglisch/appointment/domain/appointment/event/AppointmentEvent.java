package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.DomainEvent;

public interface AppointmentEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".appointment";
    }
}
