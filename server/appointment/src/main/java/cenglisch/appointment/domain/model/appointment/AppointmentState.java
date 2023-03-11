package cenglisch.appointment.domain.model.appointment;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public enum AppointmentState {
    PENDING,
    CONFLICT,
    CANCELED,
    ACCEPTED,
    LAUNCHED,
    FINISHED
}
