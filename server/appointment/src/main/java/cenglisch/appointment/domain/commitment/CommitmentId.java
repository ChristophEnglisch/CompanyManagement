package cenglisch.appointment.domain.commitment;


import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class CommitmentId {
    private String id;

    public CommitmentId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
