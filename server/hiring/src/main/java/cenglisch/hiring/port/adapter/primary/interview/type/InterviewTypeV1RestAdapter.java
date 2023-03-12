package cenglisch.hiring.port.adapter.primary.interview.type;

import cenglisch.hiring.application.interview.type.HoldInterviewOffline;
import cenglisch.hiring.application.interview.type.HoldInterviewOnline;
import cenglisch.hiring.application.interview.type.InterviewTypeCommandApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/interview/type")
public class InterviewTypeV1RestAdapter {

    @Autowired
    private InterviewTypeCommandApplicationPort interviewTypeCommandApplicationPort;

    @PostMapping("holdInterviewOffline")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void holdInterviewOffline(@RequestBody HoldInterviewOffline holdInterviewOffline) {
        interviewTypeCommandApplicationPort.holdInterviewOffline(holdInterviewOffline);
    }

    @PostMapping("holdInterviewOnline")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void holdInterviewOnline(@RequestBody HoldInterviewOnline holdInterviewOnline) {
        interviewTypeCommandApplicationPort.holdInterviewOnline(holdInterviewOnline);
    }
}
