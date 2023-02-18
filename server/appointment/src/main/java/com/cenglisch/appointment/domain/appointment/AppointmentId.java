package com.cenglisch.appointment.domain.appointment;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class AppointmentId {
    private String id;

    public AppointmentId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
