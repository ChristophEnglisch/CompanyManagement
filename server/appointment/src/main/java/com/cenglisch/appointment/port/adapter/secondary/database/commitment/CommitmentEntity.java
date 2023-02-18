package com.cenglisch.appointment.port.adapter.secondary.database.commitment;


import com.cenglisch.appointment.domain.appointment.Appointment;
import com.cenglisch.appointment.domain.commitment.CommitmentState;
import com.cenglisch.appointment.domain.participant.Participant;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.common.Default;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity
@Table(name = "commitment")
public class CommitmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppointmentEntity appointment;
    @ManyToOne(fetch = FetchType.LAZY)
    private ParticipantEntity participant;
    @Enumerated(EnumType.STRING)
    @Column
    private CommitmentState commitmentState;

    public CommitmentEntity(){

    }

    @Default
    public CommitmentEntity(String id, AppointmentEntity appointment, ParticipantEntity participant, CommitmentState commitmentState) {
        this.id = id;
        this.appointment = appointment;
        this.participant = participant;
        this.commitmentState = commitmentState;
    }


    public String getId() {
        return id;
    }

    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public ParticipantEntity getParticipant() {
        return participant;
    }

    public CommitmentState getCommitmentState() {
        return commitmentState;
    }
}
