package cenglisch.appointment.domain.model.reminder;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.participant.ParticipantId;

public class Reminder {
    private ReminderId reminderId;
    private AppointmentId appointmentId;
    private ParticipantId participantId;
}