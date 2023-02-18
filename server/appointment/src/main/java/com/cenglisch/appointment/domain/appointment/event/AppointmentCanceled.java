package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentCanceled(AppointmentId appointmentId) implements AppointmentEvent {
}
