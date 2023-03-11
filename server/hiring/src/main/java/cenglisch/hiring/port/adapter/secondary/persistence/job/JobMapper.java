package cenglisch.hiring.port.adapter.secondary.persistence.job;

import cenglisch.hiring.domain.job.Job;
import cenglisch.hiring.domain.job.ResponsibleEmployee;
import cenglisch.hiring.port.adapter.secondary.persistence.person.PersonEntity;
import cenglisch.hiring.port.adapter.secondary.persistence.person.PersonJpaRepository;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JobMapper {
    @Mapping(source = "id", target = "jobId.id")
    @Mapping(source = "responsibleEmployees", target = "responsibleEmployees", qualifiedByName = "mapPersonEntityToResponsibleEmployee")
    Job mapToJob(JobEntity jobEntity);

    @Mapping(source = "jobId.id", target = "id")
    @Mapping(source = "responsibleEmployees", target = "responsibleEmployees", qualifiedByName = "mapResponsibleEmployeeToPersonEntity")
    JobEntity mapToJobEntity(Job job, @Context PersonJpaRepository personRepository);

    @Named("mapPersonEntityToResponsibleEmployee")
    default List<ResponsibleEmployee> mapPersonEntityToResponsibleEmployee(Collection<PersonEntity> personEntities) {
        return personEntities.stream()
                .map(PersonEntity::getId)
                .map(ResponsibleEmployee::new)
                .collect(Collectors.toList());
    }

    @Named("mapResponsibleEmployeeToPersonEntity")
    default Collection<PersonEntity> mapResponsibleEmployeeToPersonEntity(Collection<ResponsibleEmployee> responsibleEmployees, @Context PersonJpaRepository personRepository) {
        return responsibleEmployees.stream()
                .map(ResponsibleEmployee::getId)
                .map(personRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}