package com.cenglisch.appointment.domain.calendar;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.participant.ParticipantId;

import java.util.ArrayList;
import java.util.Collection;

public class Calendar {

    private CalendarId calendarId;

    private ParticipantId participantId;

    private Collection<AppointmentId> appointmentIds;

    public Calendar(final ParticipantId participantId) {
        setParticipantId(participantId);
        appointmentIds = new ArrayList<>();
    }

    public Calendar(final ParticipantId participantId, final Collection<AppointmentId> appointmentIds) {
        setParticipantId(participantId);
        setAppointmentIds(appointmentIds);
    }

    public void createCalendarEntry(AppointmentId appointmentId){
        appointmentIds.add(appointmentId);
    }

    private void setCalendarId(CalendarId calendarId) {
        this.calendarId = calendarId;
    }

    private void setParticipantId(ParticipantId participantId) {
        this.participantId = participantId;
    }

    private void setAppointmentIds(Collection<AppointmentId> appointmentIds) {
        this.appointmentIds = appointmentIds;
    }

    public CalendarId getCalendarId() {
        return calendarId;
    }

    public ParticipantId getParticipantId() {
        return participantId;
    }

    public Collection<AppointmentId> getAppointmentIds() {
        return appointmentIds;
    }
}
