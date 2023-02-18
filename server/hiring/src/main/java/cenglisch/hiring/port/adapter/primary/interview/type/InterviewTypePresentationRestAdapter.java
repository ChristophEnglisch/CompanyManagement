package cenglisch.hiring.port.adapter.primary.interview.type;

import cenglisch.hiring.application.interview.type.HoldInterviewOffline;
import cenglisch.hiring.application.interview.type.HoldInterviewOnline;
import cenglisch.hiring.application.interview.type.InterviewTypeApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/interview/type")
public class InterviewTypePresentationRestAdapter {

    @Autowired
    private InterviewTypeApplicationPort interviewTypeApplicationPort;

    @PostMapping("holdInterviewOffline")
    public void holdInterviewOffline(@RequestBody HoldInterviewOffline holdInterviewOffline) {
        interviewTypeApplicationPort.holdInterviewOffline(holdInterviewOffline);
    }

    @PostMapping("holdInterviewOnline")
    public void holdInterviewOnline(@RequestBody HoldInterviewOnline holdInterviewOnline) {
        interviewTypeApplicationPort.holdInterviewOnline(holdInterviewOnline);
    }
}
