package cenglisch.hiring.application.interview.type;

import cenglisch.hiring.domain.model.interview.InterviewService;
import cenglisch.hiring.domain.model.interview.type.InterviewType;

public class InterviewTypeCommandApplicationPort {
    private final InterviewService interviewService;

    public InterviewTypeCommandApplicationPort(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    public void holdInterviewOnline(HoldInterviewOnline holdInterviewOnline) {
        interviewService.changeInterviewType(holdInterviewOnline.interviewId(), InterviewType.ONLINE);
    }

    public void holdInterviewOffline(HoldInterviewOffline holdInterviewOffline) {
        interviewService.changeInterviewType(holdInterviewOffline.interviewId(), InterviewType.OFFLINE);
    }
}
