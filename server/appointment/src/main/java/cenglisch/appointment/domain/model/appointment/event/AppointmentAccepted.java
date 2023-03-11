package cenglisch.appointment.domain.model.appointment.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;

public record AppointmentAccepted(AppointmentId appointmentId) implements AppointmentEvent {
}
