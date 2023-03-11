package cenglisch.appointment.domain.model.appointment.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;

public record AppointmentRescheduled(AppointmentId appointmentId) implements AppointmentEvent {
}
