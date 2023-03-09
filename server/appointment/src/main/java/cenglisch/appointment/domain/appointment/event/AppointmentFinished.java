package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentFinished(AppointmentId appointmentId) implements AppointmentEvent {
}
