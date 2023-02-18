package com.cenglisch.appointment.domain.commitment.event;

import com.cenglisch.appointment.domain.DomainEvent;
import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.commitment.CommitmentId;

public record RejectedCommitment(AppointmentId appointmentId, CommitmentId commitmentId) implements CommitmentEvent {
}
