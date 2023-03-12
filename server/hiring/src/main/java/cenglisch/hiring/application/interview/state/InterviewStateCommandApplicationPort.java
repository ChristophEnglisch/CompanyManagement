package cenglisch.hiring.application.interview.state;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.model.candidate.CandidateId;
import cenglisch.hiring.domain.model.candidate.CandidateService;
import cenglisch.hiring.domain.model.candidate.CandidateState;
import cenglisch.hiring.domain.model.candidate.event.CandidateApplicationApproved;
import cenglisch.hiring.domain.model.candidate.exception.CandidateNotFoundException;
import cenglisch.hiring.domain.model.interview.Interview;
import cenglisch.hiring.domain.model.interview.exception.InterviewException;
import cenglisch.hiring.domain.model.interview.InterviewId;
import cenglisch.hiring.domain.model.interview.InterviewService;
import cenglisch.hiring.domain.model.interview.exception.InterviewNotFoundException;
import cenglisch.hiring.domain.model.interview.state.InterviewState;

public class InterviewStateCommandApplicationPort {

    private final InterviewService interviewService;

    private final CandidateService candidateService;

    public InterviewStateCommandApplicationPort(final InterviewService interviewService, final CandidateService candidateService, final EventHandler eventHandler) {
        this.interviewService = interviewService;
        this.candidateService = candidateService;

        eventHandler.subscribe(
                CandidateApplicationApproved.class, event -> {
                    generateInterview(event.candidateId());
                }
        );
    }

    private void generateInterview(final CandidateId candidateId) {
        if(candidateService.find(candidateId).isEmpty()){
            throw new CandidateNotFoundException();
        }
        interviewService.newInterview(
                candidateId
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