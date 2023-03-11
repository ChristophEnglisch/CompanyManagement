package cenglisch.hiring.domain.model.interview.type;

import cenglisch.hiring.domain.model.interview.InterviewId;

public record InterviewHeldOnline(InterviewId interviewId) implements InterviewTypeEventHiring {
    @Override
    public String topic() {
        return "hiring.interview";
    }
}
