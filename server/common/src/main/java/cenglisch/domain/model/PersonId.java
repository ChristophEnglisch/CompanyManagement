package cenglisch.domain.model;


/**
 * This Identity provides value from sso user
 */
public class PersonId {

    private final String personId;

    public PersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }
}
