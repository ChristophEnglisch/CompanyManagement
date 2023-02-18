package cenglisch.hiring.domain.interview;

import cenglisch.common.domain.Default;
import cenglisch.hiring.domain.Entity;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.interview.exception.InterviewException;
import cenglisch.hiring.domain.interview.state.InterviewState;
import cenglisch.hiring.domain.interview.type.InterviewType;

public class Interview extends Entity {

    private InterviewId interviewId;

    private CandidateId candidateId;

    private InterviewState interviewState;

    private InterviewType interviewType;

    public Interview(final CandidateId pCandidateId) {
        setCandidateId(pCandidateId);
        setInterviewState(InterviewState.GENERATED);
        setInterviewType(InterviewType.ONLINE);
    }

    @Default
    public Interview(
            final InterviewId interviewId,
            final CandidateId candidateId,
            final InterviewState interviewState,
            final InterviewType interviewType
    ) {
        setInterviewId(interviewId);
        setCandidateId(candidateId);
        setInterviewState(interviewState);
        setInterviewType(interviewType);
    }

    public void changeInterviewType(final InterviewType changeToInterviewType) {
        if (interviewState.compareTo(InterviewState.LAUNCHED) >= 0) {
            throw new InterviewException("interview type cannot be changed, because interview is already " + interviewState.name());
        }
        setInterviewType(changeToInterviewType);
    }

    public void changeInterviewState(final InterviewState changeToInterviewState) {
        boolean stateChangeValid = false;
        switch (interviewState) {
            case GENERATED -> stateChangeValid = changeToInterviewState == InterviewState.ACCEPTED;
            case ACCEPTED -> stateChangeValid = changeToInterviewState == InterviewState.LAUNCHED;
            case LAUNCHED -> stateChangeValid = changeToInterviewState == InterviewState.CARRIED_OUT;
        }
        if (!stateChangeValid) {
            throw new InterviewException("Illegal State Change: " + interviewState.name() + " to " + changeToInterviewState.name() + " invalid");
        }
        setInterviewState(changeToInterviewState);
    }

    public void setInterviewId(InterviewId pInterviewId) {
        assertArgumentNotNull(pInterviewId, "Interview Id can not be null");
        interviewId = pInterviewId;
    }

    private void setCandidateId(CandidateId pCandidateId) {
        assertArgumentNotNull(pCandidateId, "Candidate Id can not be null");
        candidateId = pCandidateId;
    }

    private void setInterviewState(InterviewState pInterviewState) {
        assertArgumentNotNull(pInterviewState, "Interview State can not be null");
        interviewState = pInterviewState;
    }

    private void setInterviewType(InterviewType pInterviewType) {
        assertArgumentNotNull(pInterviewType, "Interview Type can not be null");
        interviewType = pInterviewType;
    }

    public InterviewId getInterviewId() {
        return interviewId;
    }

    public CandidateId getCandidateId() {
        return candidateId;
    }

    public InterviewState getInterviewState() {
        return interviewState;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }
}