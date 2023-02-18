package com.cenglisch.appointment.domain.commitment.event;

import com.cenglisch.appointment.domain.DomainEvent;

public interface CommitmentEvent extends DomainEvent {
    default String topic() {
        return DomainEvent.super.topic() + ".commitment";
    }
}
