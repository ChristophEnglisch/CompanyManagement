package cenglisch.hiring.domain.model.candidate;

import cenglisch.hiring.domain.model.candidate.exception.CandidateException;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.person.PersonId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CandidateTest {
    @Test
    public void testCandidateSimpleConstructorException() {
        IllegalArgumentException exception = null;
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(null, null);
        });
        assertEquals("person id cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(new PersonId("P-12312"), null);
        });
        assertEquals("job id cannot be null", exception.getMessage());

        var candidate = new Candidate(new PersonId("P-12312"), new JobId("J-12312"));
        assertEquals(
                CandidateState.APPLICATION_ACCEPTED,
                candidate.getCandidateState()
        );
    }

    @Test
    public void testCandidateConstructor() {
        IllegalArgumentException exception = null;
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(null, null, null, null);
        });
        assertEquals("candidate id cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(new CandidateId("P-1312"), null, null, null);
        });
        assertEquals("job id cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(new CandidateId("P-1312"), new JobId("J-123123"), null, null);
        });
        assertEquals("person id cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(new CandidateId("P-1312"), new JobId("J-123123"), new PersonId("P-1312"), null);
        });
        assertEquals("candidate state cannot be null", exception.getMessage());
    }

    @Test
    public void testChangeCandidateStateValidCases() {
        candidateStateAssertion(CandidateState.APPLICATION_ACCEPTED, CandidateState.APPLICATION_APPROVED);
        candidateStateAssertion(CandidateState.APPLICATION_ACCEPTED, CandidateState.APPLICATION_REJECTED);
        candidateStateAssertion(CandidateState.APPLICATION_APPROVED, CandidateState.ADOPTED);
        candidateStateAssertion(CandidateState.APPLICATION_APPROVED, CandidateState.REJECTED);
    }

    private void candidateStateAssertion(CandidateState initialState, CandidateState changeToState) {
        var candidate = new Candidate(new CandidateId("C-1312312"), new JobId("J-1231231"), new PersonId("P-1312"), initialState);
        assertEquals(
                initialState,
                candidate.getCandidateState()
        );
        candidate.changeCandidateState(changeToState);
        assertEquals(
                changeToState,
                candidate.getCandidateState()
        );
    }

    @Test
    public void testChangeCandidateStateFailCases() {
        candidateStateException(CandidateState.APPLICATION_ACCEPTED, CandidateState.ADOPTED);
        candidateStateException(CandidateState.APPLICATION_ACCEPTED, CandidateState.REJECTED);

        candidateStateException(CandidateState.APPLICATION_APPROVED, CandidateState.APPLICATION_ACCEPTED);
        candidateStateException(CandidateState.APPLICATION_APPROVED, CandidateState.APPLICATION_REJECTED);

        candidateStateException(CandidateState.APPLICATION_REJECTED, CandidateState.APPLICATION_ACCEPTED);
        candidateStateException(CandidateState.APPLICATION_REJECTED, CandidateState.APPLICATION_APPROVED);
        candidateStateException(CandidateState.APPLICATION_REJECTED, CandidateState.ADOPTED);
        candidateStateException(CandidateState.APPLICATION_REJECTED, CandidateState.REJECTED);

        candidateStateException(CandidateState.ADOPTED, CandidateState.APPLICATION_ACCEPTED);
        candidateStateException(CandidateState.ADOPTED, CandidateState.APPLICATION_APPROVED);
        candidateStateException(CandidateState.ADOPTED, CandidateState.APPLICATION_REJECTED);
        candidateStateException(CandidateState.ADOPTED, CandidateState.REJECTED);
    }

    private void candidateStateException(CandidateState initialState, CandidateState changeToState) {
        var candidate = new Candidate(new CandidateId("C-1312312"), new JobId("J-1231"), new PersonId("P-1312"), initialState);
        Exception exception = assertThrows(CandidateException.class, () -> {
            candidate.changeCandidateState(changeToState);
        });
        assertEquals(
                "Illegal State Change: " + initialState.name() + " to " + changeToState.name() + " invalid",
                exception.getMessage()
        );
    }
}
