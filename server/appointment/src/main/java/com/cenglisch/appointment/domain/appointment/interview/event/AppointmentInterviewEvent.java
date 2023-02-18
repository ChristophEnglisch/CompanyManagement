package com.cenglisch.appointment.domain.appointment.interview.event;

import com.cenglisch.appointment.domain.DomainEvent;

public interface AppointmentInterviewEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".appointment.interview";
    }
}
