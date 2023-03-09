package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentCreated(AppointmentId appointmentId) implements AppointmentEvent {
}
