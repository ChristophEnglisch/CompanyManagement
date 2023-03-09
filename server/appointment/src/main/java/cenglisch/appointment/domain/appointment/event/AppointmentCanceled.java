package cenglisch.appointment.domain.appointment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentCanceled(AppointmentId appointmentId) implements AppointmentEvent {
}
