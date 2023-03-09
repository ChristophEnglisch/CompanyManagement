package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentAccepted(AppointmentId appointmentId) implements AppointmentEvent {
}
