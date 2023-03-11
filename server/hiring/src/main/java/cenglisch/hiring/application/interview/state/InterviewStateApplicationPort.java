package cenglisch.hiring.application.interview.state;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.candidate.event.CandidateApplicationApproved;
import cenglisch.hiring.domain.candidate.exception.CandidateNotFoundException;
import cenglisch.hiring.domain.interview.Interview;
import cenglisch.hiring.domain.interview.exception.InterviewException;
import cenglisch.hiring.domain.interview.InterviewId;
import cenglisch.hiring.domain.interview.InterviewService;
import cenglisch.hiring.domain.interview.exception.InterviewNotFoundException;
import cenglisch.hiring.domain.interview.state.InterviewState;
import cenglisch.hiring.domain.model.person.exception.PersonNotFoundException;
import cenglisch.hiring.domain.model.person.PersonService;

public class InterviewStateApplicationPort {

    private final InterviewService interviewService;

    private final CandidateService candidateService;
    private final PersonService personService;

    public InterviewStateApplicationPort(final InterviewService interviewService, final CandidateService candidateService, final PersonService personService, final EventHandler eventHandler) {
        this.interviewService = interviewService;
        this.candidateService = candidateService;
        this.personService = personService;

        eventHandler.subscribe(
                CandidateApplicationApproved.class, event -> {
                    generateInterview(event.candidateId());
                }
        );
    }

    private void generateInterview(final CandidateId candidateId) {
        Candidate candidate = candidateService.find(candidateId).orElseThrow(CandidateNotFoundException::new);
        interviewService.newInterview(
                candidateId,
                personService.find(candidate.getPersonId()).orElseThrow(PersonNotFoundException::new)
        );
    }

    private void candidateApplicationMustBeApproved(final CandidateId candidateId) {
        if (!candidateService.isCandidateInState(candidateId, CandidateState.APPLICATION_APPROVED)) {
            throw new InterviewException("invalid Candidate State");
        }
    }

    private void candidateApplicationMustBeApproved(final InterviewId interviewId) {
        Interview interview = interviewService.find(interviewId).orElseThrow(InterviewNotFoundException::new);
        candidateApplicationMustBeApproved(interview.getCandidateId());
    }

    public void acceptInterview(final AcceptInterview acceptInterview) {
        candidateApplicationMustBeApproved(acceptInterview.interviewId());
        interviewService.changeInterviewState(acceptInterview.interviewId(), InterviewState.ACCEPTED);
    }

    public void launchInterview(final LaunchInterview launchInterview) {
        candidateApplicationMustBeApproved(launchInterview.interviewId());
        interviewService.changeInterviewState(launchInterview.interviewId(), InterviewState.LAUNCHED);
    }

    public void endInterviewExecution(final EndInterviewExecution endInterviewExecution) {
        candidateApplicationMustBeApproved(endInterviewExecution.interviewId());
        interviewService.changeInterviewState(endInterviewExecution.interviewId(), InterviewState.CARRIED_OUT);
    }
}