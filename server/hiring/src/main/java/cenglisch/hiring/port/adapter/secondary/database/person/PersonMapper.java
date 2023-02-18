package cenglisch.hiring.port.adapter.secondary.database.person;

import cenglisch.hiring.domain.person.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface PersonMapper {

    @Mapping(source = "id", target = "personId.id")
    Person mapToPerson(PersonEntity personEntity);

    @Mapping(source = "personId.id", target = "id")
    PersonEntity mapToPersonEntity(Person person);
}
