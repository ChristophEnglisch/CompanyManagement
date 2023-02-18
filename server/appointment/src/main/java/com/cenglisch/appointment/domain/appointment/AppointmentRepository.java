package com.cenglisch.appointment.domain.appointment;

import com.cenglisch.appointment.domain.Repository;

@org.jmolecules.ddd.annotation.Repository
public interface AppointmentRepository extends Repository<Appointment, AppointmentId> {
}
