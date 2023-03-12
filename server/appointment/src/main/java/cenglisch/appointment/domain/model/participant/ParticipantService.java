package cenglisch.appointment.domain.model.participant;

import cenglisch.appointment.domain.model.participant.event.ParticipantCreated;
import cenglisch.domain.model.EventHandler;
import cenglisch.domain.model.PersonId;

@org.jmolecules.ddd.annotation.Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final EventHandler eventHandler;

    public ParticipantService(ParticipantRepository participantRepository, EventHandler eventHandler) {
        this.participantRepository = participantRepository;
        this.eventHandler = eventHandler;
    }

    public ParticipantId newParticipant(PersonId personId) {
        Participant participant = participantRepository.save(new Participant(personId));
        eventHandler.publish(new ParticipantCreated(participant.getParticipantId()));
        return participant.getParticipantId();
    }
}