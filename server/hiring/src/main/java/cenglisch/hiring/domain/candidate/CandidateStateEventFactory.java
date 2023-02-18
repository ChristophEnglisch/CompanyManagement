package cenglisch.hiring.domain.candidate;

import cenglisch.hiring.domain.candidate.event.*;
import cenglisch.hiring.domain.job.JobId;

public final class CandidateStateEventFactory {
    public static CandidateEvent make(
            final CandidateId candidateId,
            final CandidateState candidateState,
            final JobId jobId
    ) {
        return switch (candidateState) {
            case APPLICATION_ACCEPTED -> new CandidateApplicationAccepted(candidateId, jobId);
            case APPLICATION_APPROVED -> new CandidateApplicationApproved(candidateId, jobId);
            case APPLICATION_REJECTED -> new CandidateApplicationRejected(candidateId, jobId);
            case ADOPTED -> new CandidateAdopted(candidateId, jobId);
            case REJECTED -> new CandidateRejected(candidateId, jobId);
        };
    }
}
