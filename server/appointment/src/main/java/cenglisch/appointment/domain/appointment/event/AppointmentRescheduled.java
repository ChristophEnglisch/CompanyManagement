package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentRescheduled(AppointmentId appointmentId) implements AppointmentEvent {
}
