package cenglisch.appointment.application.participant;

import cenglisch.appointment.domain.model.participant.ParticipantService;

public class ParticipantApplicationPort {
    private final ParticipantService participantService;

    public ParticipantApplicationPort(ParticipantService participantService) {
        this.participantService = participantService;
    }

    public void newParticipant(NewParticipant newParticipant) {
        participantService.newParticipant(newParticipant.name(), newParticipant.email());
    }
}
