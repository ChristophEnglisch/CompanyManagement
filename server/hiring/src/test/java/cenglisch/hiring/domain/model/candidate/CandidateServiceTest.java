package cenglisch.hiring.domain.model.candidate;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.candidate.event.CandidateApplicationAccepted;
import cenglisch.hiring.domain.candidate.event.CandidateApplicationApproved;
import cenglisch.hiring.domain.candidate.exception.CandidateException;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.model.person.PersonId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @Mock
    EventHandler eventHandler;

    @Mock
    CandidateRepository candidateRepository;

    @InjectMocks
    CandidateService candidateService;

    @Test
    public void testNewCandidate() {
        var personId = new PersonId("P-131231");
        var jobId = new JobId("J-12312");
        var candidate = new Candidate(new CandidateId("C-1231"), jobId, personId, CandidateState.APPLICATION_ACCEPTED);

        when(candidateRepository.save(any(Candidate.class))).thenAnswer(invocation -> candidate);

        candidateService.newCandidate(personId, jobId);

        verify(candidateRepository).save(any(Candidate.class));
        verify(eventHandler).publish(any(CandidateApplicationAccepted.class));
    }

    @Test
    public void testSetCandidateStateCandidateNotFound() {
        Optional<Candidate> optionalCandidate = Optional.empty();
        when(candidateRepository.find(any(CandidateId.class))).thenAnswer(invocation -> optionalCandidate);

        Exception exception = assertThrows(CandidateException.class, () -> {
            candidateService.changeCandidateState(new CandidateId("C-131221"), CandidateState.ADOPTED);
        });
        assertEquals(
                "Candidate not found",
                exception.getMessage()
        );
    }

    @Test
    public void testCandidateChangeState() {
        Optional<Candidate> optionalCandidate = Optional.of(
                new Candidate(
                        new PersonId("P-132131"),
                        new JobId("J-12312")
                )
        );
        when(candidateRepository.find(any(CandidateId.class))).thenAnswer(invocation -> optionalCandidate);

        candidateService.changeCandidateState(new CandidateId("C1231"), CandidateState.APPLICATION_APPROVED);
        verify(candidateRepository).save(any(Candidate.class));
        verify(eventHandler).publish(any(CandidateApplicationApproved.class));
    }
}