package cenglisch.hiring.application.candidate;

import cenglisch.hiring.domain.model.candidate.Candidate;
import cenglisch.hiring.domain.model.candidate.CandidateId;
import cenglisch.hiring.domain.model.candidate.CandidateService;
import cenglisch.hiring.domain.model.candidate.CandidateState;
import cenglisch.hiring.domain.model.candidate.exception.CandidateException;
import cenglisch.hiring.domain.model.interview.InterviewService;
import cenglisch.hiring.domain.model.interview.state.InterviewState;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.job.JobService;

public class CandidateCommandApplicationPort {
    private final CandidateService candidateService;
    private final JobService jobService;
    private final InterviewService interviewService;


    public CandidateCommandApplicationPort(
            final CandidateService candidateService,
            final InterviewService interviewService,
            final JobService jobService
    ) {
        this.candidateService = candidateService;
        this.jobService = jobService;
        this.interviewService = interviewService;
    }

    private void interviewMustBeCarriedOut(final CandidateId candidateId) {
        if (!interviewService.isInterviewInState(candidateId, InterviewState.CARRIED_OUT)) {
            throw new CandidateException("interview must be carried out");
        }
    }

    private void jobCapacitiesMustBeAvailable(final CandidateId candidateId) {
        Candidate candidate = candidateService.find(candidateId).orElseThrow(() -> {
            throw new CandidateException("candidate not found");
        });
        jobCapacitiesMustBeAvailable(candidate.getJobId());
    }

    private void jobCapacitiesMustBeAvailable(final JobId jobId) {
        if (!jobService.capacitiesAvailable(jobId)) {
            throw new CandidateException("no employees are wanted");
        }
    }

    public void candidateApplies(final CandidateApplies candidateApplies) {
        jobCapacitiesMustBeAvailable(candidateApplies.jobId());
        candidateService.newCandidate(
                candidateApplies.personId(),
                candidateApplies.jobId()
        );
    }

    public void approveCandidateApplication(final ApproveCandidateApplication approveCandidateApplication) {
        jobCapacitiesMustBeAvailable(approveCandidateApplication.candidateId());
        candidateService.changeCandidateState(
                approveCandidateApplication.candidateId(),
                CandidateState.APPLICATION_APPROVED
        );
    }

    public void rejectCandidateApplication(final RejectCandidateApplication rejectCandidateApplication) {
        jobCapacitiesMustBeAvailable(rejectCandidateApplication.candidateId());
        candidateService.changeCandidateState(
                rejectCandidateApplication.candidateId(),
                CandidateState.APPLICATION_REJECTED
        );
    }

    public void adoptCandidate(final AdoptCandidate adoptCandidate) {
        jobCapacitiesMustBeAvailable(adoptCandidate.candidateId());
        interviewMustBeCarriedOut(adoptCandidate.candidateId());
        candidateService.changeCandidateState(
                adoptCandidate.candidateId(),
                CandidateState.ADOPTED
        );
    }

    public void rejectCandidate(final RejectCandidate rejectCandidate) {
        jobCapacitiesMustBeAvailable(rejectCandidate.candidateId());
        interviewMustBeCarriedOut(rejectCandidate.candidateId());
        candidateService.changeCandidateState(
                rejectCandidate.candidateId(),
                CandidateState.REJECTED
        );
    }
}