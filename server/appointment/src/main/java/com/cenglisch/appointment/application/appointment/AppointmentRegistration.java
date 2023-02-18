package com.cenglisch.appointment.application.appointment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.AppointmentInformation;
import com.cenglisch.appointment.domain.appointment.AppointmentType;
import com.cenglisch.appointment.domain.appointment.date.AppointmentDate;
import com.cenglisch.appointment.domain.participant.ParticipantId;

public record AppointmentRegistration(
        AppointmentId appointmentId,
        ParticipantId schedulingParticipant,
        AppointmentDate appointmentDate,
        AppointmentType appointmentType,
        AppointmentInformation appointmentInformation
) {
}
