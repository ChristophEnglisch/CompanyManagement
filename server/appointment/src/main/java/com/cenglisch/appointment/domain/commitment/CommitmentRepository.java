package com.cenglisch.appointment.domain.commitment;

import com.cenglisch.appointment.domain.Repository;
import com.cenglisch.appointment.domain.appointment.AppointmentId;

import java.util.Collection;

public interface CommitmentRepository extends Repository<Commitment, CommitmentId> {

    Collection<Commitment> findByAppointmentId(AppointmentId appointmentId);
}
