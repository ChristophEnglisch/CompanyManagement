package cenglisch.appointment.domain.model.appointment.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;

public record AppointmentCreated(AppointmentId appointmentId) implements AppointmentEvent {
}
