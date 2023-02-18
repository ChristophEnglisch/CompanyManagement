package cenglisch.hiring.application.person;

import cenglisch.hiring.domain.person.PersonId;
import cenglisch.hiring.domain.person.PersonService;

public class PersonApplicationPort {
    private final PersonService personService;

    public PersonApplicationPort(final PersonService personService) {
        this.personService = personService;
    }

    public void deposePersonalInformation(final DeposePersonalInformation deposePersonalInformation) {
        personService.newPerson(
                deposePersonalInformation.firstname(),
                deposePersonalInformation.lastname(),
                deposePersonalInformation.email()
        );
    }
}
