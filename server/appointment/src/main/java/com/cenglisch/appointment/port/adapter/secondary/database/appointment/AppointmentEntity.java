package com.cenglisch.appointment.port.adapter.secondary.database.appointment;

import com.cenglisch.appointment.domain.appointment.AppointmentInformation;
import com.cenglisch.appointment.domain.appointment.AppointmentState;
import com.cenglisch.appointment.domain.appointment.AppointmentType;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.date.AppointmentDateEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.common.Default;

import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "appointment")
public class AppointmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ParticipantEntity schedulingParticipant;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "appointment_participant",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private Collection<ParticipantEntity> participants;

    @OneToOne(fetch = FetchType.LAZY)
    private AppointmentDateEntity publishedAppointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentType appointmentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentState appointmentState;

    @Embedded
    private AppointmentInformation appointmentInformation;

    public AppointmentEntity(){}

    @Default
    public AppointmentEntity(String id, ParticipantEntity schedulingParticipant, Collection<ParticipantEntity> participants, AppointmentDateEntity publishedAppointmentDate, AppointmentType appointmentType, AppointmentState appointmentState, AppointmentInformation appointmentInformation) {
        this.id = id;
        this.schedulingParticipant = schedulingParticipant;
        this.participants = participants;
        this.publishedAppointmentDate = publishedAppointmentDate;
        this.appointmentType = appointmentType;
        this.appointmentState = appointmentState;
        this.appointmentInformation = appointmentInformation;
    }

    public String getId() {
        return id;
    }

    public ParticipantEntity getSchedulingParticipant() {
        return schedulingParticipant;
    }

    public Collection<ParticipantEntity> getParticipants() {
        return participants;
    }

    public AppointmentDateEntity getPublishedAppointmentDate() {
        return publishedAppointmentDate;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public AppointmentState getAppointmentState() {
        return appointmentState;
    }

    public AppointmentInformation getAppointmentInformation() {
        return appointmentInformation;
    }
}
