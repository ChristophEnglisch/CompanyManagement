package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentRescheduled(AppointmentId appointmentId) implements AppointmentEvent {
}
