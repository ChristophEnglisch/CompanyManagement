package cenglisch.appointment.domain.commitment.event;

import cenglisch.appointment.domain.AppointmentDomainEvent;

public interface CommitmentEvent extends AppointmentDomainEvent {
    default String topic() {
        return AppointmentDomainEvent.super.topic() + ".commitment";
    }
}
