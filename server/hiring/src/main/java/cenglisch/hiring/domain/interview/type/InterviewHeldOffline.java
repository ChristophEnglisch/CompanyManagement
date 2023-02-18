package cenglisch.hiring.domain.interview.type;

import cenglisch.hiring.domain.interview.InterviewId;

public record InterviewHeldOffline(InterviewId interviewId) implements InterviewTypeEvent {
    @Override
    public String topic() {
        return "hiring.interview";
    }
}