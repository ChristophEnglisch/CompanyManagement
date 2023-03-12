package cenglisch.appointment.port.adapter.secondary.persistence.participant;

import cenglisch.Default;

import jakarta.persistence.*;

@Entity(name = "participant")
public class ParticipantEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String personId;

    public ParticipantEntity(){}

    @Default
    public ParticipantEntity(String id, String personId) {
        this.id = id;
        this.personId = personId;
    }

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }
}
