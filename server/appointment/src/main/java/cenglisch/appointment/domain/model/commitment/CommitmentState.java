package cenglisch.appointment.domain.model.commitment;


import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public enum CommitmentState {
    CONFIRM,
    REJECTED,
}
