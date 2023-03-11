package cenglisch.appointment.domain.model;

import cenglisch.domain.model.DomainEvent;

public interface AppointmentDomainEvent extends DomainEvent {
    default String topic() {
        return "appointment";
    }
}
