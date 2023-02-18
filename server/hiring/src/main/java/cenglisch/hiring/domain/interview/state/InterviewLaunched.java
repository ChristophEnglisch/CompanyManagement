package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.interview.InterviewId;


public record InterviewLaunched(InterviewId interviewId) implements InterviewStateEvent { }