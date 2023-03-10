package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.interview.InterviewId;
public record InterviewCarriedOut(InterviewId interviewId) implements InterviewStateEventHiring {}