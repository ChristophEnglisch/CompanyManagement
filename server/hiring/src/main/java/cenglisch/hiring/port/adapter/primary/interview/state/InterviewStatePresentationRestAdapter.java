package cenglisch.hiring.port.adapter.primary.interview.state;

import cenglisch.hiring.application.interview.state.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/interview/state")
public class InterviewStatePresentationRestAdapter {

    @Autowired
    private InterviewStateApplicationPort interviewStateApplicationPort;

    @PostMapping("acceptInterview")
    public void acceptInterview(@RequestBody AcceptInterview acceptInterview) {
        interviewStateApplicationPort.acceptInterview(acceptInterview);
    }

    @PostMapping("launchInterview")
    public void launchInterview(@RequestBody LaunchInterview launchInterview) {
        interviewStateApplicationPort.launchInterview(launchInterview);
    }

    @PostMapping("endInterviewExecution")
    public void endInterviewExecution(@RequestBody EndInterviewExecution endInterviewExecution){
        interviewStateApplicationPort.endInterviewExecution(endInterviewExecution);
    }
}
