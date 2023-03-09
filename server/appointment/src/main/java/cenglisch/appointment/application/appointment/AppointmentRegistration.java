package cenglisch.appointment.application.appointment;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.appointment.AppointmentInformation;
import cenglisch.appointment.domain.appointment.AppointmentType;
import cenglisch.appointment.domain.appointment.date.AppointmentDate;
import cenglisch.appointment.domain.participant.ParticipantId;

public record AppointmentRegistration(
        AppointmentId appointmentId,
        ParticipantId schedulingParticipant,
        AppointmentDate appointmentDate,
        AppointmentType appointmentType,
        AppointmentInformation appointmentInformation
) {
}
