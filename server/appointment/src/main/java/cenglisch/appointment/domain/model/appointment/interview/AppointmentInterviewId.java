package cenglisch.appointment.domain.model.appointment.interview;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class AppointmentInterviewId {

    private String id;

    public AppointmentInterviewId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
