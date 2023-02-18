package com.cenglisch.appointment.domain.commitment;


import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public enum CommitmentState {
    CONFIRM,
    REJECTED,
}
