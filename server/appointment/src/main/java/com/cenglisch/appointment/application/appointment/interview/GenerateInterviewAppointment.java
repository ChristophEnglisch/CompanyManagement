package com.cenglisch.appointment.application.appointment.interview;

import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public record GenerateInterviewAppointment(
    String candidateEmail,
    String candidateFullName,
    AppointmentInterviewId interviewId
) {
}
