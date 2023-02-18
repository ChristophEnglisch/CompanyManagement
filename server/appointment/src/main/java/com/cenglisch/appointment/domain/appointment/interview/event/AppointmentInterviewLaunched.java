package com.cenglisch.appointment.domain.appointment.interview.event;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record AppointmentInterviewLaunched(AppointmentInterviewId appointmentInterviewId) implements AppointmentInterviewEvent{

}
