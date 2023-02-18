package com.cenglisch.appointment.domain.appointment.event;

import com.cenglisch.appointment.domain.DomainEvent;

public interface AppointmentEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".appointment";
    }
}
