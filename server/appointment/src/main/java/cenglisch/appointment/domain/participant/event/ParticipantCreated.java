package cenglisch.appointment.domain.participant.event;

import cenglisch.appointment.domain.DomainEvent;
import cenglisch.appointment.domain.participant.ParticipantId;

public record ParticipantCreated(ParticipantId participantId) implements DomainEvent {
    public String topic() {
        return DomainEvent.super.topic() + "participant";
    }
}
