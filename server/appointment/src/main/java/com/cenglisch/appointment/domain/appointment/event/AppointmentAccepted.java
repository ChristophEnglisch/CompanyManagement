package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentAccepted(AppointmentId appointmentId) implements AppointmentEvent {
}
