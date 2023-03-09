package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentLaunched(AppointmentId appointmentId) implements AppointmentEvent {
}
