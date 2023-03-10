package cenglisch.hiring.domain.interview.type;

import cenglisch.hiring.domain.interview.InterviewId;

public record InterviewHeldOnline(InterviewId interviewId) implements InterviewTypeEventHiring {
    @Override
    public String topic() {
        return "hiring.interview";
    }
}
