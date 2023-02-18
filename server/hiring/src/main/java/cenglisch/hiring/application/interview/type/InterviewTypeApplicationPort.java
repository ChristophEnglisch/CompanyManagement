package cenglisch.hiring.application.interview.type;

import cenglisch.hiring.domain.interview.InterviewService;
import cenglisch.hiring.domain.interview.type.InterviewType;

public class InterviewTypeApplicationPort {
    private final InterviewService interviewService;

    public InterviewTypeApplicationPort(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    public void holdInterviewOnline(HoldInterviewOnline holdInterviewOnline) {
        interviewService.changeInterviewType(holdInterviewOnline.interviewId(), InterviewType.ONLINE);
    }

    public void holdInterviewOffline(HoldInterviewOffline holdInterviewOffline) {
        interviewService.changeInterviewType(holdInterviewOffline.interviewId(), InterviewType.OFFLINE);
    }
}
