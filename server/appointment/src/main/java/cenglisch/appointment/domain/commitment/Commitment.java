package cenglisch.appointment.domain.commitment;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.participant.ParticipantId;
import cenglisch.common.Default;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
public class Commitment {
    @Identity
    private CommitmentId commitmentId;
    private AppointmentId appointmentId;
    private ParticipantId participantId;
    private CommitmentState commitmentState;

    public Commitment(
            final AppointmentId appointmentId,
            final ParticipantId participantId,
            final CommitmentState CommitmentState
    ) {
        setAppointmentId(appointmentId);
        setParticipantId(participantId);
        setCommitmentState(CommitmentState);
    }

    @Default
    public Commitment(
            final CommitmentId commitmentId,
            final AppointmentId appointmentId,
            final ParticipantId participantId,
            final CommitmentState commitmentState
    ) {
        setCommitmentId(commitmentId);
        setAppointmentId(appointmentId);
        setParticipantId(participantId);
        setCommitmentState(commitmentState);
    }

    public void setCommitmentId(CommitmentId commitmentId) {
        this.commitmentId = commitmentId;
    }

    public void setParticipantId(ParticipantId participantId) {
        this.participantId = participantId;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setCommitmentState(CommitmentState commitmentState) {
        this.commitmentState = commitmentState;
    }


    public ParticipantId getParticipantId() {
        return participantId;
    }

    public boolean isCommitmentStateRejected() {
        return commitmentState == CommitmentState.REJECTED;
    }

    public boolean isCommitmentStateConfirmed() {
        return commitmentState == CommitmentState.CONFIRM;
    }

    public CommitmentState getCommitmentState() {
        return commitmentState;
    }

    public CommitmentId getCommitmentId() {
        return commitmentId;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }
}