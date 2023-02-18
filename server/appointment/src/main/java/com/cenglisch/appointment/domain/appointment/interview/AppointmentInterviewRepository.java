package com.cenglisch.appointment.domain.appointment.interview;

import com.cenglisch.appointment.domain.Repository;
import com.cenglisch.appointment.domain.appointment.AppointmentId;

import java.util.Optional;

public interface AppointmentInterviewRepository extends Repository<AppointmentInterview, AppointmentInterviewId> {
    Optional<AppointmentInterview> findByAppointmentId(AppointmentId appointmentId);
}
