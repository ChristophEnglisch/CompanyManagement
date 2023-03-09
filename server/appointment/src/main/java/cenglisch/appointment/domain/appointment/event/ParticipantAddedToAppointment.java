package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.participant.ParticipantId;

public record ParticipantAddedToAppointment(AppointmentId appointmentId, ParticipantId participantId) implements AppointmentEvent {
}
