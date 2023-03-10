package cenglisch.hiring.domain.candidate;

import cenglisch.hiring.domain.candidate.event.*;
import cenglisch.hiring.domain.job.JobId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CandidateStateEventFactoryTest {

    private final CandidateId candidateId = new CandidateId("C-12121");
    private final JobId jobId = new JobId("J-13121");

    @Test
    public void testEventCases() {
        eventAssertion(
                new CandidateApplicationAccepted(candidateId, jobId),
                CandidateStateEventFactory.make(candidateId, CandidateState.APPLICATION_ACCEPTED, jobId)
        );
        eventAssertion(
                new CandidateApplicationApproved(candidateId, jobId),
                CandidateStateEventFactory.make(candidateId, CandidateState.APPLICATION_APPROVED, jobId)
        );
        eventAssertion(
                new CandidateApplicationRejected(candidateId, jobId),
                CandidateStateEventFactory.make(candidateId, CandidateState.APPLICATION_REJECTED, jobId)
        );
        eventAssertion(
                new CandidateAdopted(candidateId, jobId),
                CandidateStateEventFactory.make(candidateId, CandidateState.ADOPTED, jobId)
        );
        eventAssertion(
                new CandidateRejected(candidateId, jobId),
                CandidateStateEventFactory.make(candidateId, CandidateState.REJECTED, jobId)
        );
    }

    public void eventAssertion(CandidateEventHiring expectedEvent, CandidateEventHiring builtCandidateEvent) {
        assertEquals(
                expectedEvent.candidateId(),
                builtCandidateEvent.candidateId()
        );
        assertEquals(
                expectedEvent.jobId(),
                builtCandidateEvent.jobId()
        );
        assertEquals(
                expectedEvent.getClass(),
                builtCandidateEvent.getClass()
        );
    }
}
