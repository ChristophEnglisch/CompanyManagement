package cenglisch.appointment.port.adapter.secondary.persistence.commitment;


import cenglisch.appointment.domain.model.commitment.CommitmentState;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentEntity;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantEntity;
import cenglisch.Default;

import jakarta.persistence.*;

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
