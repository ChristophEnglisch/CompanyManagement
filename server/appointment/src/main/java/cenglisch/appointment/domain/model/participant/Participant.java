package cenglisch.appointment.domain.model.participant;

import cenglisch.Default;
import cenglisch.domain.model.PersonId;

public class Participant {
    private ParticipantId participantId;

    private PersonId personId;

    public Participant(final PersonId personId) {
        setPersonId(personId);
    }

    @Default
    public Participant(final ParticipantId participantId, final PersonId personId) {
        setParticipantId(participantId);
        setPersonId(personId);
    }

    public void setParticipantId(ParticipantId participantId) {
        this.participantId = participantId;
    }

    private void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public ParticipantId getParticipantId() {
        return participantId;
    }

    public PersonId getPersonId() {
        return personId;
    }
}
