package cenglisch.appointment.domain.model.participant.event;

import cenglisch.appointment.domain.model.AppointmentDomainEvent;
import cenglisch.appointment.domain.model.participant.ParticipantId;

public record ParticipantCreated(ParticipantId participantId) implements AppointmentDomainEvent {
    public String topic() {
        return AppointmentDomainEvent.super.topic() + "participant";
    }
}
