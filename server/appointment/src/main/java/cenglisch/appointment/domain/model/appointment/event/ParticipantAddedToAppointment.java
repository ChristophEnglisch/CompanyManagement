package cenglisch.appointment.domain.model.appointment.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.participant.ParticipantId;

public record ParticipantAddedToAppointment(AppointmentId appointmentId, ParticipantId participantId) implements AppointmentEvent {
}
