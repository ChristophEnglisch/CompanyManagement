package cenglisch.hiring.domain.interview;


import cenglisch.hiring.domain.EventHandler;
import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.interview.state.InterviewAccepted;
import cenglisch.hiring.domain.interview.state.InterviewState;
import cenglisch.hiring.domain.interview.type.InterviewHeldOffline;
import cenglisch.hiring.domain.interview.type.InterviewHeldOnline;
import cenglisch.hiring.domain.interview.type.InterviewType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InterviewServiceTest {

    @Mock
    EventHandler eventHandler;

    @Mock
    InterviewRepository interviewRepository;

    @InjectMocks
    InterviewService interviewService;

    @Test
    public void testChangeInterviewTypeToOnline() {
        final InterviewId interviewId = new InterviewId("I-121");
        Optional<Interview> optionalInterview = Optional.of(new Interview(interviewId, new CandidateId("c-12312"), InterviewState.ACCEPTED, InterviewType.OFFLINE));
        when(interviewRepository.find(any(InterviewId.class))).thenAnswer(invocation -> optionalInterview);

        Interview interview = optionalInterview.get();
        assertEquals(
                InterviewType.OFFLINE,
                interview.getInterviewType()
        );
        interviewService.changeInterviewType(
                interviewId,
                InterviewType.ONLINE
        );

        assertEquals(
                InterviewType.ONLINE,
                interview.getInterviewType()
        );
        verify(interviewRepository).save(any(Interview.class));
        verify(eventHandler).publish(any(InterviewHeldOnline.class));
    }

    @Test
    public void testChangeInterviewTypeToOffline() {
        final InterviewId interviewId = new InterviewId("I-121");
        Optional<Interview> optionalInterview = Optional.of(new Interview(interviewId, new CandidateId("c-12312"), InterviewState.ACCEPTED, InterviewType.ONLINE));
        when(interviewRepository.find(any(InterviewId.class))).thenAnswer(invocation -> optionalInterview);

        Interview interview = optionalInterview.get();
        assertEquals(
                InterviewType.ONLINE,
                interview.getInterviewType()
        );
        interviewService.changeInterviewType(
                interviewId,
                InterviewType.OFFLINE
        );

        assertEquals(
                InterviewType.OFFLINE,
                interview.getInterviewType()
        );
        verify(interviewRepository).save(any(Interview.class));
        verify(eventHandler).publish(any(InterviewHeldOffline.class));
    }

    @Test
    public void testChangeInterviewState() {
        final InterviewId interviewId = new InterviewId("I-121");
        Optional<Interview> optionalInterview = Optional.of(new Interview(interviewId, new CandidateId("c-12312"), InterviewState.GENERATED, InterviewType.ONLINE));
        when(interviewRepository.find(any(InterviewId.class))).thenAnswer(invocation -> optionalInterview);

        Interview interview = optionalInterview.get();
        assertEquals(
                InterviewState.GENERATED,
                interview.getInterviewState()
        );
        interviewService.changeInterviewState(
                interviewId,
                InterviewState.ACCEPTED
        );
        assertEquals(
                InterviewState.ACCEPTED,
                interview.getInterviewState()
        );
        verify(interviewRepository).save(any(Interview.class));
        verify(eventHandler).publish(any(InterviewAccepted.class));
    }
}