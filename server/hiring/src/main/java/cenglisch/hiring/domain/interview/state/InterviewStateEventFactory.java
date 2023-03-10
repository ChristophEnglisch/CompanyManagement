package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.interview.InterviewId;

public final class InterviewStateEventFactory {
    public static InterviewStateEventHiring make(InterviewId interviewId, InterviewState interviewState) {
        return switch (interviewState) {
            case ACCEPTED -> new InterviewAccepted(interviewId);
            case LAUNCHED -> new InterviewLaunched(interviewId);
            case CARRIED_OUT -> new InterviewCarriedOut(interviewId);
            default -> throw new IllegalStateException("Unexpected value: " + interviewState);
        };
    }
}
