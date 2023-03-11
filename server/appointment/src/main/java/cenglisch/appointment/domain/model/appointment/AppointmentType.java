package cenglisch.appointment.domain.model.appointment;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public enum AppointmentType {
    NORMAL,
    COMPULSORY_ATTENDANCE
}
