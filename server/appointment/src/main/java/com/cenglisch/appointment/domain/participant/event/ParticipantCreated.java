package com.cenglisch.appointment.domain.participant.event;

import com.cenglisch.appointment.domain.DomainEvent;
import com.cenglisch.appointment.domain.participant.ParticipantId;

public record ParticipantCreated(ParticipantId participantId) implements DomainEvent {
    public String topic() {
        return DomainEvent.super.topic() + "participant";
    }
}
