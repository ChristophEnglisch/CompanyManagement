package cenglisch.hiring.port.adapter.secondary.database.person;

import cenglisch.hiring.domain.person.Person;
import cenglisch.hiring.domain.person.PersonId;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T23:28:14+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person mapToPerson(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonId personId = null;
        String firstname = null;
        String lastname = null;
        String email = null;
        boolean verified = false;

        personId = personEntityToPersonId( personEntity );
        firstname = personEntity.getFirstname();
        lastname = personEntity.getLastname();
        email = personEntity.getEmail();
        verified = personEntity.isVerified();

        Person person = new Person( personId, firstname, lastname, email, verified );

        return person;
    }

    @Override
    public PersonEntity mapToPersonEntity(Person person) {
        if ( person == null ) {
            return null;
        }

        String id = null;
        String firstname = null;
        String lastname = null;
        String email = null;
        boolean verified = false;

        id = personPersonIdId( person );
        firstname = person.getFirstname();
        lastname = person.getLastname();
        email = person.getEmail();
        verified = person.isVerified();

        PersonEntity personEntity = new PersonEntity( id, firstname, lastname, email, verified );

        return personEntity;
    }

    protected PersonId personEntityToPersonId(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        String id = null;

        id = personEntity.getId();

        PersonId personId = new PersonId( id );

        return personId;
    }

    private String personPersonIdId(Person person) {
        if ( person == null ) {
            return null;
        }
        PersonId personId = person.getPersonId();
        if ( personId == null ) {
            return null;
        }
        String id = personId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
