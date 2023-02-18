package cenglisch.hiring.port.adapter.secondary.database.job;

import cenglisch.hiring.domain.job.Job;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.job.ResponsibleEmployee;
import cenglisch.hiring.port.adapter.secondary.database.person.PersonEntity;
import cenglisch.hiring.port.adapter.secondary.database.person.PersonJpaRepository;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-29T12:39:10+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public Job mapToJob(JobEntity jobEntity) {
        if ( jobEntity == null ) {
            return null;
        }

        JobId jobId = null;
        Collection<ResponsibleEmployee> responsibleEmployees = null;
        String jobName = null;
        int neededCapacities = 0;
        boolean published = false;

        jobId = jobEntityToJobId( jobEntity );
        responsibleEmployees = mapPersonEntityToResponsibleEmployee( jobEntity.getResponsibleEmployees() );
        jobName = jobEntity.getJobName();
        neededCapacities = jobEntity.getNeededCapacities();
        published = jobEntity.isPublished();

        Job job = new Job( jobId, jobName, neededCapacities, published, responsibleEmployees );

        return job;
    }

    @Override
    public JobEntity mapToJobEntity(Job job, PersonJpaRepository personRepository) {
        if ( job == null ) {
            return null;
        }

        String id = null;
        Collection<PersonEntity> responsibleEmployees = null;
        String jobName = null;
        int neededCapacities = 0;
        boolean published = false;

        id = jobJobIdId( job );
        responsibleEmployees = mapResponsibleEmployeeToPersonEntity( job.getResponsibleEmployees(), personRepository );
        jobName = job.getJobName();
        neededCapacities = job.getNeededCapacities();
        published = job.isPublished();

        JobEntity jobEntity = new JobEntity( id, jobName, neededCapacities, published, responsibleEmployees );

        return jobEntity;
    }

    protected JobId jobEntityToJobId(JobEntity jobEntity) {
        if ( jobEntity == null ) {
            return null;
        }

        String id = null;

        id = jobEntity.getId();

        JobId jobId = new JobId( id );

        return jobId;
    }

    private String jobJobIdId(Job job) {
        if ( job == null ) {
            return null;
        }
        JobId jobId = job.getJobId();
        if ( jobId == null ) {
            return null;
        }
        String id = jobId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
