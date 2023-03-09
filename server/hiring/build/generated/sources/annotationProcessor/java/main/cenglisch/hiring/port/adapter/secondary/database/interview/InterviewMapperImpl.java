package cenglisch.hiring.port.adapter.secondary.database.interview;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.interview.Interview;
import cenglisch.hiring.domain.interview.InterviewId;
import cenglisch.hiring.domain.interview.state.InterviewState;
import cenglisch.hiring.domain.interview.type.InterviewType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T23:28:14+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class InterviewMapperImpl implements InterviewMapper {

    @Override
    public Interview mapToInterview(InterviewEntity interviewEntity) {
        if ( interviewEntity == null ) {
            return null;
        }

        InterviewId interviewId = null;
        CandidateId candidateId = null;
        InterviewState interviewState = null;
        InterviewType interviewType = null;

        interviewId = interviewEntityToInterviewId( interviewEntity );
        candidateId = interviewEntityToCandidateId( interviewEntity );
        interviewState = interviewEntity.getInterviewState();
        interviewType = interviewEntity.getInterviewType();

        Interview interview = new Interview( interviewId, candidateId, interviewState, interviewType );

        return interview;
    }

    @Override
    public InterviewEntity mapToInterviewEntity(Interview interview) {
        if ( interview == null ) {
            return null;
        }

        String id = null;
        String candidateId = null;
        InterviewState interviewState = null;
        InterviewType interviewType = null;

        id = interviewInterviewIdId( interview );
        candidateId = interviewCandidateIdId( interview );
        interviewState = interview.getInterviewState();
        interviewType = interview.getInterviewType();

        InterviewEntity interviewEntity = new InterviewEntity( id, candidateId, interviewState, interviewType );

        return interviewEntity;
    }

    protected InterviewId interviewEntityToInterviewId(InterviewEntity interviewEntity) {
        if ( interviewEntity == null ) {
            return null;
        }

        String id = null;

        id = interviewEntity.getId();

        InterviewId interviewId = new InterviewId( id );

        return interviewId;
    }

    protected CandidateId interviewEntityToCandidateId(InterviewEntity interviewEntity) {
        if ( interviewEntity == null ) {
            return null;
        }

        String id = null;

        id = interviewEntity.getCandidateId();

        CandidateId candidateId = new CandidateId( id );

        return candidateId;
    }

    private String interviewInterviewIdId(Interview interview) {
        if ( interview == null ) {
            return null;
        }
        InterviewId interviewId = interview.getInterviewId();
        if ( interviewId == null ) {
            return null;
        }
        String id = interviewId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String interviewCandidateIdId(Interview interview) {
        if ( interview == null ) {
            return null;
        }
        CandidateId candidateId = interview.getCandidateId();
        if ( candidateId == null ) {
            return null;
        }
        String id = candidateId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
