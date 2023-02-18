package cenglisch.hiring.domain.person;

import cenglisch.common.domain.Default;
import cenglisch.hiring.domain.Entity;

import java.util.regex.Pattern;

public class Person extends Entity {

    private PersonId personId;
    private String firstname;
    private String lastname;
    private String email;
    private boolean verified;

    public Person(
            final String firstname,
            final String lastname,
            final String email
    ) {
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setVerified(false);
    }

    @Default
    public Person(
            final PersonId personId,
            final String firstname,
            final String lastname,
            final String email,
            final boolean verified
    ) {
        setPersonId(personId);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setVerified(verified);
    }

    public void verify(){
        setVerified(true);
    }

    public void setPersonId(PersonId pPersonId) {
        assertArgumentNotNull(pPersonId, "provide a value for person id");
        this.personId = pPersonId;
    }

    private void setFirstname(String pFirstname) {
        assertArgumentNotNull(pFirstname, "provide a value for firstname");
        assertArgumentLength(pFirstname, 1, 30, "firstname must be at least 1 and maximum 30 characters long");
        this.firstname = pFirstname;
    }

    private void setLastname(String pLastname) {
        assertArgumentNotNull(pLastname, "provide a value for lastname");
        assertArgumentLength(pLastname, 1, 30, "lastname must be at least 1 and maximum 30 characters long");
        this.lastname = pLastname;
    }

    private void setEmail(String pEmail) {
        assertArgumentNotNull(pEmail, "provide a value for email");

        boolean validEmail = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
                .matcher(pEmail)
                .matches();

        if (!validEmail) {
            throw new IllegalArgumentException("provide a valid email");
        }

        this.email = pEmail;
    }

    private void setVerified(boolean pVerified) {
        assertArgumentNotNull(pVerified, "provide a value for verified");
        this.verified = pVerified;
    }

    public PersonId getPersonId() {
        return personId;
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