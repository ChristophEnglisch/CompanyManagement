package cenglisch.appointment.application.appointment;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.participant.ParticipantId;

public record AddParticipant(AppointmentId appointmentId, ParticipantId participantId) {
}
