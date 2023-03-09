package cenglisch.hiring.port.adapter.secondary.database.person;

import cenglisch.Default;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean verified;

    public PersonEntity() {
    }

    @Default
    public PersonEntity(String id, String firstname, String lastname, String email, boolean verified) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.verified = verified;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }
}