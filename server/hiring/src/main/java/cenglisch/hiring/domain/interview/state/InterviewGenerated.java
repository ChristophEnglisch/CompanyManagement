package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.interview.InterviewId;

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
