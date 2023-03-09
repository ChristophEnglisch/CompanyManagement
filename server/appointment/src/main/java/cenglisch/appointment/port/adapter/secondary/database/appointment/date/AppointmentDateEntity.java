package cenglisch.appointment.port.adapter.secondary.database.appointment.date;

import cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentEntity;
import cenglisch.common.Default;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "appointment_date")
public class AppointmentDateEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @Column
    private Date date;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

    public AppointmentDateEntity(){

    }

    @Default
    public AppointmentDateEntity(String id, AppointmentEntity appointment, Date date, Time startTime, Time endTime) {
        this.id = id;
        this.appointment = appointment;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public AppointmentEntity getAppointment() {
        return appointment;
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
