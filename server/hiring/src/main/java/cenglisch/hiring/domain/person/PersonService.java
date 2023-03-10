package cenglisch.hiring.domain.person;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.person.event.PersonVerified;
import cenglisch.hiring.domain.person.event.PersonalInformationDeposited;
import cenglisch.hiring.domain.person.exception.PersonException;
import cenglisch.hiring.domain.person.exception.PersonNotFoundException;

import java.util.Optional;

public class PersonService {
    private final PersonRepository personRepository;
    private final EventHandler eventHandler;

    public PersonService(final PersonRepository personRepository, final EventHandler eventHandler) {
        this.personRepository = personRepository;
        this.eventHandler = eventHandler;
    }

    public Optional<Person> find(PersonId personId) {
        return personRepository.find(personId);
    }
    private void emailExists(final String email) {
        if (personRepository.existsByEmail(email)) {
            throw new PersonException("Email " + email + " already exists");
        }
    }

    public void newPerson(final String firstname, final String lastname, final String email) {
        emailExists(email);
        Person person = personRepository.save(
                new Person(
                        firstname,
                        lastname,
                        email
                )
        );
        eventHandler.publish(new PersonalInformationDeposited(person.getPersonId()));
    }

    public void verifyPersonalInformation(final PersonId personId) {
        Person person = find(personId).orElseThrow(PersonNotFoundException::new);
        person.verify();
        personRepository.save(person);
        eventHandler.publish(new PersonVerified(personId));
    }
}