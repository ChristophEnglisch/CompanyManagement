package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentLaunched(AppointmentId appointmentId) implements AppointmentEvent {
}
