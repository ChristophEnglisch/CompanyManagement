package com.cenglisch.appointment.port.adapter.secondary.database.appointment.interview;

import com.cenglisch.common.Default;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_interview")
public class AppointmentInterviewEntity {
    @Id
    @Column
    private String id;
    @Column
    private String appointmentId;


    public AppointmentInterviewEntity() {
    }

    @Default
    public AppointmentInterviewEntity(String id, String appointmentId) {
        this.id = id;
        this.appointmentId = appointmentId;
    }


    public String getId() {
        return id;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
}
