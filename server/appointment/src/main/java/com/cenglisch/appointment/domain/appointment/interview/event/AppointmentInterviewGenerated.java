package com.cenglisch.appointment.domain.appointment.interview.event;

import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewGenerated(AppointmentInterviewId appointmentInterviewId,
                                            com.cenglisch.appointment.domain.appointment.AppointmentId appointmentId) implements AppointmentInterviewEvent{
    public String topic() {
        return AppointmentInterviewEvent.super.topic()  + ".generated";
    }
}
