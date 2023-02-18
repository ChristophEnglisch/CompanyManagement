package com.cenglisch.appointment.domain.appointment.interview.event;

import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewAccepted(AppointmentInterviewId appointmentInterviewId) implements AppointmentInterviewEvent {
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".accepted";
    }
}
