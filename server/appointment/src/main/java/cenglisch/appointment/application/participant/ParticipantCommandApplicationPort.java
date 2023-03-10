package cenglisch.appointment.application.participant;

import cenglisch.appointment.domain.model.participant.ParticipantService;
import cenglisch.domain.model.PersonId;

public class ParticipantCommandApplicationPort {
    private final ParticipantService participantService;

    public ParticipantCommandApplicationPort(ParticipantService participantService) {
        this.participantService = participantService;
    }

    public void newParticipant(NewParticipant newParticipant) {
        participantService.newParticipant(newParticipant.personId());
    }
}
