package cenglisch.hiring.port.adapter.secondary.persistence.person;

import cenglisch.hiring.domain.model.person.Person;
import cenglisch.hiring.domain.model.person.PersonId;
import cenglisch.hiring.domain.model.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonRepositoryAdapter implements PersonRepository {

    @Autowired
    private PersonJpaRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public Optional<Person> find(PersonId id) {
        Optional<PersonEntity> optionalPerson = personRepository.findById(id.getId());
        return optionalPerson.map(personEntity -> personMapper.mapToPerson(personEntity));
    }

    public Person save(Person person) {
        if (person.getPersonId() == null){
            person.setPersonId(new PersonId(generateId()));
        }
        personRepository.saveAndFlush(
                personMapper.mapToPersonEntity(person)
        );
        return person;
    }

    @Override
    public void remove(Person person) {

    }


    public boolean existsByEmail(String email) {
        return personRepository.existsByEmail(email);
    }

    public String generateId() {
        return PersonRepository.super.generateId();
    }
}