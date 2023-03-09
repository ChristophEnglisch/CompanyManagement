package cenglisch.appointment.domain.commitment.event;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.appointment.domain.commitment.CommitmentId;

public record RejectedCommitment(AppointmentId appointmentId, CommitmentId commitmentId) implements CommitmentEvent {
}
