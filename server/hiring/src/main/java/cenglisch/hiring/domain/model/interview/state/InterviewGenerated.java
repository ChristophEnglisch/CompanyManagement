package cenglisch.hiring.domain.model.interview.state;

import cenglisch.hiring.domain.model.interview.InterviewId;

public record InterviewGenerated(InterviewId interviewId, String candidateFullName, String candidateEmail) implements InterviewStateEventHiring {
    public String topic() {
        return InterviewStateEventHiring.super.topic() + ".generated";
    }

    public String toString() {
        return
            "{" +
                "\"interviewId\":\""+interviewId().getId()+"\"," +
                "\"candidateFullName\":\""+candidateFullName()+"\"," +
                "\"candidateEmail\":\""+candidateEmail()+"\"" +
            "}";
    }
}
