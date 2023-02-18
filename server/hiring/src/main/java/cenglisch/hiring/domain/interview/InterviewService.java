package cenglisch.hiring.domain.interview;

import cenglisch.hiring.domain.EventHandler;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.interview.exception.InterviewException;
import cenglisch.hiring.domain.interview.exception.InterviewNotFoundException;
import cenglisch.hiring.domain.interview.state.InterviewGenerated;
import cenglisch.hiring.domain.interview.state.InterviewState;
import cenglisch.hiring.domain.interview.state.InterviewStateEventFactory;
import cenglisch.hiring.domain.interview.type.InterviewHeldOffline;
import cenglisch.hiring.domain.interview.type.InterviewHeldOnline;
import cenglisch.hiring.domain.interview.type.InterviewType;
import cenglisch.hiring.domain.person.Person;

import java.util.Optional;

public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final EventHandler eventHandler;

    public InterviewService(InterviewRepository interviewRepository, EventHandler eventHandler) {
        this.interviewRepository = interviewRepository;
        this.eventHandler = eventHandler;
    }

    public Optional<Interview> find(final InterviewId interviewId) {
        return interviewRepository.find(interviewId);
    }

    public Optional<Interview> findByCandidateId(final CandidateId candidateId) {
        return interviewRepository.findByCandidateId(candidateId);
    }

    public boolean isInterviewInState(final CandidateId candidateId, final InterviewState interviewState) {
        Interview interview = findByCandidateId(candidateId).orElseThrow(InterviewNotFoundException::new);
        return interview.getInterviewState() == interviewState;
    }

    public void newInterview(final CandidateId candidateId, final Person person) {
        findByCandidateId(candidateId).ifPresent(s -> {
            throw new InterviewException("candidate already assigned to interview");
        });
        Interview interview = interviewRepository.save(new Interview(candidateId));
        eventHandler.publish(
                new InterviewGenerated(
                        interview.getInterviewId(),
                        person.getFirstname() + " " + person.getLastname(),
                        person.getEmail()
                )
        );
    }

    public void changeInterviewType(final InterviewId interviewId, final InterviewType interviewType) {
        Interview interview = find(interviewId).orElseThrow(InterviewNotFoundException::new);
        interview.changeInterviewType(interviewType);
        interviewRepository.save(interview);
        eventHandler.publish(
                interviewType == InterviewType.ONLINE ?
                        new InterviewHeldOnline(interviewId) :
                        new InterviewHeldOffline(interviewId)
        );
    }

    public void changeInterviewState(InterviewId interviewId, InterviewState interviewState) {
        Interview interview = find(interviewId).orElseThrow(InterviewNotFoundException::new);
        interview.changeInterviewState(interviewState);
        interviewRepository.save(interview);
        eventHandler.publish(InterviewStateEventFactory.make(interviewId, interviewState));
    }
}