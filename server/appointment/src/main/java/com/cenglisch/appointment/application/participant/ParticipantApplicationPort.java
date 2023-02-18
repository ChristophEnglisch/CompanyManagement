package com.cenglisch.appointment.application.participant;

import com.cenglisch.appointment.domain.participant.ParticipantService;

public class ParticipantApplicationPort {
    private final ParticipantService participantService;

    public ParticipantApplicationPort(ParticipantService participantService) {
        this.participantService = participantService;
    }

    public void newParticipant(NewParticipant newParticipant) {
        participantService.newParticipant(newParticipant.name(), newParticipant.email());
    }
}
