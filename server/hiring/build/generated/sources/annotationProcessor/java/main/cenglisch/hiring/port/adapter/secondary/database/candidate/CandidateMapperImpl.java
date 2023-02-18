package cenglisch.hiring.port.adapter.secondary.database.candidate;

import cenglisch.hiring.domain.candidate.Candidate;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.candidate.CandidateState;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.person.PersonId;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T20:29:37+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public Candidate mapToCandidate(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        CandidateId candidateId = null;
        PersonId personId = null;
        JobId jobId = null;
        CandidateState candidateState = null;

        candidateId = candidateEntityToCandidateId( candidateEntity );
        personId = candidateEntityToPersonId( candidateEntity );
        jobId = candidateEntityToJobId( candidateEntity );
        candidateState = candidateEntity.getCandidateState();

        Candidate candidate = new Candidate( candidateId, jobId, personId, candidateState );

        return candidate;
    }

    @Override
    public CandidateEntity mapToCandidateEntity(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        String id = null;
        String personId = null;
        String jobId = null;
        CandidateState candidateState = null;

        id = candidateCandidateIdId( candidate );
        personId = candidatePersonIdId( candidate );
        jobId = candidateJobIdId( candidate );
        candidateState = candidate.getCandidateState();

        CandidateEntity candidateEntity = new CandidateEntity( id, jobId, personId, candidateState );

        return candidateEntity;
    }

    protected CandidateId candidateEntityToCandidateId(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        String id = null;

        id = candidateEntity.getId();

        CandidateId candidateId = new CandidateId( id );

        return candidateId;
    }

    protected PersonId candidateEntityToPersonId(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        String id = null;

        id = candidateEntity.getPersonId();

        PersonId personId = new PersonId( id );

        return personId;
    }

    protected JobId candidateEntityToJobId(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        String id = null;

        id = candidateEntity.getJobId();

        JobId jobId = new JobId( id );

        return jobId;
    }

    private String candidateCandidateIdId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        CandidateId candidateId = candidate.getCandidateId();
        if ( candidateId == null ) {
            return null;
        }
        String id = candidateId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String candidatePersonIdId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        PersonId personId = candidate.getPersonId();
        if ( personId == null ) {
            return null;
        }
        String id = personId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String candidateJobIdId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        JobId jobId = candidate.getJobId();
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
