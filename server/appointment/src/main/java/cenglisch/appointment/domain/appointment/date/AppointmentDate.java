package cenglisch.appointment.domain.appointment.date;

import cenglisch.appointment.domain.Entity;
import cenglisch.appointment.domain.appointment.AppointmentId;
import org.jmolecules.ddd.annotation.Identity;

import java.sql.Date;
import java.sql.Time;

@org.jmolecules.ddd.annotation.Entity
public class AppointmentDate extends Entity {

    @Identity
    private AppointmentDateId appointmentDateId;

    private AppointmentId appointmentId;

    private Date date;

    private Time startTime;

    private Time endTime;

    public AppointmentDate(
            AppointmentId appointmentId,
            Date date,
            Time startTime,
            Time endTime
    ) {
        setAppointmentId(appointmentId);
        setDate(date);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public void setAppointmentDateId(AppointmentDateId appointmentDateId) {
        assertArgumentNotNull(appointmentDateId, "provide a value for appointment date id");
        this.appointmentDateId = appointmentDateId;
    }

    private void setAppointmentId(AppointmentId appointmentId){
        assertArgumentNotNull(appointmentDateId, "provide a value for appointment Ωid");
        this.appointmentId = appointmentId;
    }

    private void setDate(Date aDate) {
        assertArgumentNotNull(aDate, "provide a value for date");
        assertArgumentFuture(aDate, "the date must be in future");
        this.date = aDate;
    }

    private void setStartTime(Time aStartTime) {
        assertArgumentNotNull(aStartTime, "provide  a value for start time");
        assertArgumentFuture(aStartTime, "provide a start time that is in future");
        this.startTime = aStartTime;
    }

    private void setEndTime(Time aEndTime) {
        assertArgumentNotNull(aEndTime, "provide a value for end time");
        assertArgumentFuture(aEndTime, "provide a end time that is in future");
        this.endTime = aEndTime;
    }

    public AppointmentDateId getAppointmentDateId() {
        return appointmentDateId;
    }

    public AppointmentId getAppointmentId(){
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}