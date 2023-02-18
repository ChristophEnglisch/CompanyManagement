package cenglisch.hiring.domain.interview.state;

import cenglisch.hiring.domain.interview.InterviewId;

public record InterviewAccepted(InterviewId interviewId) implements InterviewStateEvent {}

