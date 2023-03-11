package cenglisch.appointment.domain.model.commitment.event;

import cenglisch.appointment.domain.model.AppointmentDomainEvent;

public interface CommitmentEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".commitment";
    }
}
