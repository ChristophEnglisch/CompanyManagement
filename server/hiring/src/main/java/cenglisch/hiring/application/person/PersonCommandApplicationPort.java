package cenglisch.hiring.application.person;

import cenglisch.hiring.domain.model.person.PersonService;

public class PersonCommandApplicationPort {
    private final PersonService personService;

    public PersonCommandApplicationPort(final PersonService personService) {
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
