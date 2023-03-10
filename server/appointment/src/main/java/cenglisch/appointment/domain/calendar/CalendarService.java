package cenglisch.appointment.domain.calendar;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.participant.ParticipantId;
import cenglisch.domain.model.EventHandler;
import org.jmolecules.ddd.annotation.Service;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final EventHandler eventHandler;

    public CalendarService(CalendarRepository calendarRepository, EventHandler eventHandler) {
        this.calendarRepository = calendarRepository;
        this.eventHandler = eventHandler;
    }

    public void createCalendarEntry(ParticipantId calendarId, AppointmentId appointmentId) {

    }
}
