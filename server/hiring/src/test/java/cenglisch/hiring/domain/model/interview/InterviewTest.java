package cenglisch.hiring.domain.model.interview;


import cenglisch.hiring.domain.model.candidate.CandidateId;
import cenglisch.hiring.domain.model.interview.exception.InterviewException;
import cenglisch.hiring.domain.model.interview.state.InterviewState;
import cenglisch.hiring.domain.model.interview.type.InterviewType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterviewTest {

    private void changeInterviewStateAssertion(final InterviewState initialState, final InterviewState changeToState) {
        final Interview interview = new Interview(new InterviewId("I-1212"), new CandidateId("C-1231"), initialState, InterviewType.ONLINE);
        assertEquals(
            initialState,
            interview.getInterviewState()
        );
        interview.changeInterviewState(changeToState);
        assertEquals(
                changeToState,
                interview.getInterviewState()
        );
    }

    @Test
    public void testChangeInterviewStateValidCases() {
        changeInterviewStateAssertion(InterviewState.GENERATED, InterviewState.ACCEPTED);
        changeInterviewStateAssertion(InterviewState.ACCEPTED, InterviewState.LAUNCHED);
        changeInterviewStateAssertion(InterviewState.LAUNCHED, InterviewState.CARRIED_OUT);
    }

    private void interviewStateException(InterviewState initialState, InterviewState changeToState) {
        final Interview interview = new Interview(new InterviewId("I-1212"), new CandidateId("C-1231"), initialState, InterviewType.ONLINE);
        Exception exception = assertThrows(InterviewException.class, () -> {
            interview.changeInterviewState(changeToState);
        });
        assertEquals(
                "Illegal State Change: " + initialState.name() + " to " + changeToState.name() + " invalid",
                exception.getMessage()
        );
    }

    @Test
    public void testChangeInterviewStateFailCases() {
        interviewStateException(InterviewState.GENERATED, InterviewState.LAUNCHED);
        interviewStateException(InterviewState.GENERATED, InterviewState.CARRIED_OUT);

        interviewStateException(InterviewState.ACCEPTED, InterviewState.GENERATED);
        interviewStateException(InterviewState.ACCEPTED, InterviewState.CARRIED_OUT);

        interviewStateException(InterviewState.LAUNCHED, InterviewState.GENERATED);
        interviewStateException(InterviewState.LAUNCHED, InterviewState.ACCEPTED);

        interviewStateException(InterviewState.CARRIED_OUT, InterviewState.GENERATED);
        interviewStateException(InterviewState.CARRIED_OUT, InterviewState.ACCEPTED);
        interviewStateException(InterviewState.CARRIED_OUT, InterviewState.LAUNCHED);
    }

    private void changeInterviewTypeAssertion(final InterviewState interviewState) {
        final Interview interview = new Interview(new InterviewId("I-1212"), new CandidateId("C-1231"), interviewState, InterviewType.ONLINE);
        assertEquals(
                InterviewType.ONLINE,
                interview.getInterviewType()
        );
        interview.changeInterviewType(InterviewType.OFFLINE);
        assertEquals(
                InterviewType.OFFLINE,
                interview.getInterviewType()
        );
    }

    @Test
    public void testChangeInterviewTypeValidCases() {
        changeInterviewTypeAssertion(InterviewState.GENERATED);
        changeInterviewTypeAssertion(InterviewState.ACCEPTED);
    }

    private void interviewTypeException(final InterviewState interviewState) {
        final Interview interview = new Interview(new InterviewId("I-1212"), new CandidateId("C-1231"), interviewState, InterviewType.ONLINE);
        assertEquals(
                InterviewType.ONLINE,
                interview.getInterviewType()
        );
        Exception exception = assertThrows(InterviewException.class, () -> {
            interview.changeInterviewType(InterviewType.OFFLINE);
        });
        assertEquals(
                "interview type cannot be changed, because interview is already " + interviewState.name(),
                exception.getMessage()
        );
    }

    @Test
    public void changeInterviewTypeFailCases() {
        interviewTypeException(InterviewState.LAUNCHED);
        interviewTypeException(InterviewState.CARRIED_OUT);
    }

    @Test
    public void testSimpleConstructor(){
        final Interview interview = new Interview(new CandidateId("C-12312"));
        assertEquals(
                InterviewState.GENERATED,
                interview.getInterviewState()
        );
        assertEquals(
                InterviewType.ONLINE,
                interview.getInterviewType()
        );
    }
}
