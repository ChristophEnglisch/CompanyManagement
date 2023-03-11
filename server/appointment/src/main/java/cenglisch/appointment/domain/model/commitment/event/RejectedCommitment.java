package cenglisch.appointment.domain.model.commitment.event;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.commitment.CommitmentId;

public record RejectedCommitment(AppointmentId appointmentId, CommitmentId commitmentId) implements CommitmentEvent {
}
