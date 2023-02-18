package com.cenglisch.appointment.domain.participant;

import com.cenglisch.common.Default;

public class Participant {
    private ParticipantId participantId;
    private String name;
    private String email;

    public Participant(final String name, final String email) {
        setName(name);
        setEmail(email);
    }

    @Default
    public Participant(final ParticipantId participantId, final String name, final String email) {
        setParticipantId(participantId);
        setName(name);
        setEmail(email);
    }

    public void setParticipantId(ParticipantId participantId) {
        this.participantId = participantId;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public ParticipantId getParticipantId() {
        return participantId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
