package com.cenglisch.appointment.domain.reminder;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.participant.ParticipantId;

public class Reminder {
    private ReminderId reminderId;
    private AppointmentId appointmentId;
    private ParticipantId participantId;
}