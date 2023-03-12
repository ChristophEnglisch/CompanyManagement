package cenglisch.hiring.domain.model.candidate;

import cenglisch.Default;
import cenglisch.hiring.domain.model.Entity;
import cenglisch.hiring.domain.model.candidate.exception.CandidateException;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.person.PersonId;

public class Candidate extends Entity {
    private CandidateId candidateId;
    private PersonId personId;
    private CandidateState candidateState;
    private JobId jobId;

    public Candidate(final PersonId personId, final JobId jobId) {
        setPersonId(personId);
        setJobId(jobId);
        setCandidateState(CandidateState.APPLICATION_ACCEPTED);
    }

    @Default
    public Candidate(
            final CandidateId candidateId,
            final JobId jobId,
            final PersonId personId,
            final CandidateState candidateState
    ) {
        setCandidateId(candidateId);
        setJobId(jobId);
        setPersonId(personId);
        setCandidateState(candidateState);
    }

    public void changeCandidateState(final CandidateState stateChange) {
        if (candidateState == stateChange) {
            return;
        }
        boolean stateChangeValid = false;
        switch (candidateState) {
            case APPLICATION_ACCEPTED ->
                    stateChangeValid = stateChange == CandidateState.APPLICATION_APPROVED || stateChange == CandidateState.APPLICATION_REJECTED;
            case APPLICATION_APPROVED ->
                    stateChangeValid = stateChange == CandidateState.ADOPTED || stateChange == CandidateState.REJECTED;
        }
        if (!stateChangeValid) {
            throw new CandidateException("Illegal State Change: " + candidateState.name() + " to " + stateChange.name() + " invalid");
        }
        setCandidateState(stateChange);
    }

    public void setCandidateId(final CandidateId pCandidateId) {
        assertArgumentNotNull(pCandidateId, "candidate id cannot be null");
        candidateId = pCandidateId;
    }

    private void setPersonId(final PersonId pPersonId) {
        assertArgumentNotNull(pPersonId, "person id cannot be null");
        personId = pPersonId;
    }

    private void setCandidateState(final CandidateState pCandidateState) {
        assertArgumentNotNull(pCandidateState, "candidate state cannot be null");
        candidateState = pCandidateState;
    }

    private void setJobId(JobId pJobId) {
        assertArgumentNotNull(pJobId, "job id cannot be null");
        this.jobId = pJobId;
    }

    public CandidateId getCandidateId() {
        return candidateId;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public CandidateState getCandidateState() {
        return candidateState;
    }

    public JobId getJobId() {
        return jobId;
    }
}