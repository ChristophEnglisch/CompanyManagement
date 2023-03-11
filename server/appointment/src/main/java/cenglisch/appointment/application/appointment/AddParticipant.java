package cenglisch.appointment.application.appointment;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.participant.ParticipantId;

public record AddParticipant(AppointmentId appointmentId, ParticipantId participantId) {
}
