package cenglisch.appointment.domain.participant.event;

import cenglisch.appointment.domain.AppointmentDomainEvent;
import cenglisch.appointment.domain.participant.ParticipantId;

public record ParticipantCreated(ParticipantId participantId) implements AppointmentDomainEvent {
    public String topic() {
        return AppointmentDomainEvent.super.topic() + "participant";
    }
}
