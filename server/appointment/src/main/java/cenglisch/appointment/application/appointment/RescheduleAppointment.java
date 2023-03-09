package cenglisch.appointment.application.appointment;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.appointment.date.AppointmentDate;

public record RescheduleAppointment(AppointmentId appointmentId, AppointmentDate appointmentDate) {
}
