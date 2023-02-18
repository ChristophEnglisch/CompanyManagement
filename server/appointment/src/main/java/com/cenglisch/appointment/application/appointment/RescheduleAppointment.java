package com.cenglisch.appointment.application.appointment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.date.AppointmentDate;

public record RescheduleAppointment(AppointmentId appointmentId, AppointmentDate appointmentDate) {
}
