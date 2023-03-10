package cenglisch.hiring.domain.candidate;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.candidate.exception.CandidateApplicationException;
import cenglisch.hiring.domain.candidate.exception.CandidateException;
import cenglisch.hiring.domain.candidate.exception.CandidateNotFoundException;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.person.PersonId;

import java.util.Optional;

public class CandidateService {
    private final CandidateRepository candidateRepository;

    private final EventHandler eventHandler;

    public CandidateService(
            CandidateRepository candidateRepository,
            EventHandler eventHandler
    ) {
        this.candidateRepository = candidateRepository;
        this.eventHandler = eventHandler;
    }

    public Optional<Candidate> find(final CandidateId candidateId) {
        return candidateRepository.find(candidateId);
    }

    public boolean isCandidateInState(final CandidateId candidateId, final CandidateState candidateState) {
        final Candidate candidate = find(candidateId).orElseThrow(CandidateNotFoundException::new);
        return candidate.getCandidateState() == candidateState;
    }

    private boolean personAlreadyAppliedForJob(final PersonId personId, final JobId jobId) {
        return candidateRepository.existsByPersonIdAndJobId(personId, jobId);
    }

    public void newCandidate(final PersonId personId, final JobId jobId) {
        if (personAlreadyAppliedForJob(personId, jobId)){
            throw new CandidateApplicationException("person has already applied for this job");
        }

        Candidate candidate = candidateRepository.save(new Candidate(personId, jobId));
        eventHandler.publish(
                CandidateStateEventFactory.make(
                        candidate.getCandidateId(),
                        candidate.getCandidateState(),
                        candidate.getJobId()
                )
        );
    }

    public void changeCandidateState(final CandidateId candidateId, final CandidateState candidateState) {
        if (candidateState == CandidateState.APPLICATION_ACCEPTED) {
            throw new CandidateException("invalid state change");
        }
        final Candidate candidate = find(candidateId).orElseThrow(CandidateNotFoundException::new);
        candidate.changeCandidateState(candidateState);
        candidateRepository.save(candidate);
        eventHandler.publish(
                CandidateStateEventFactory.make(candidateId, candidateState, candidate.getJobId())
        );
    }
}