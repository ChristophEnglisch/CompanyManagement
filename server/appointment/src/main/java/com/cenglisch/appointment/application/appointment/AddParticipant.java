package com.cenglisch.appointment.application.appointment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.participant.ParticipantId;

public record AddParticipant(AppointmentId appointmentId, ParticipantId participantId) {
}
