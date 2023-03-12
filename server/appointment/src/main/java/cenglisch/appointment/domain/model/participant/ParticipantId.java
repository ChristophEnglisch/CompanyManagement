package cenglisch.appointment.domain.model.participant;

@org.jmolecules.ddd.annotation.ValueObject
public class ParticipantId {

    private String id;

    public ParticipantId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
