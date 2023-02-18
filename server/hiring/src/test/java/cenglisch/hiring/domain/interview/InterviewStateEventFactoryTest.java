package cenglisch.hiring.domain.interview;

import cenglisch.hiring.domain.interview.state.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterviewStateEventFactoryTest {

    private final InterviewId interviewId = new InterviewId("I-1231231");

    @Test
    public void testEventCases() {
        eventAssertion(
                new InterviewAccepted(interviewId),
                InterviewStateEventFactory.make(interviewId, InterviewState.ACCEPTED)
        );
        eventAssertion(
                new InterviewLaunched(interviewId),
                InterviewStateEventFactory.make(interviewId, InterviewState.LAUNCHED)
        );
        eventAssertion(
                new InterviewCarriedOut(interviewId),
                InterviewStateEventFactory.make(interviewId, InterviewState.CARRIED_OUT)
        );
    }

    public void eventAssertion(InterviewStateEvent expectedEvent, InterviewStateEvent builtEvent){
        assertEquals(
                expectedEvent.getClass(),
                builtEvent.getClass()
        );
        assertEquals(
                expectedEvent.interviewId(),
                builtEvent.interviewId()
        );
    }
}