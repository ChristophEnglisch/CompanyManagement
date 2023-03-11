package cenglisch.appointment.domain.model.appointment.date;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class AppointmentDateId {

    private String id;

    public AppointmentDateId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
