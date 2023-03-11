package cenglisch.hiring.domain.model.interview.state;

import cenglisch.hiring.domain.model.interview.InterviewId;


public record InterviewLaunched(InterviewId interviewId) implements InterviewStateEventHiring { }