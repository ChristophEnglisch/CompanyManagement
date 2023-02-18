package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.participant.ParticipantId;

public record ParticipantAddedToAppointment(AppointmentId appointmentId, ParticipantId participantId) implements AppointmentEvent {
}
