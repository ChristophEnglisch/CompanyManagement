package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.DomainEvent;
import com.cenglisch.appointment.domain.appointment.AppointmentId;

public record AppointmentCreated(AppointmentId appointmentId) implements AppointmentEvent {
}
