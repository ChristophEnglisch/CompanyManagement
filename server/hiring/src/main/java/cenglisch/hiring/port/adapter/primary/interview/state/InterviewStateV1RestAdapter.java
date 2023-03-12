package cenglisch.hiring.port.adapter.primary.interview.state;

import cenglisch.hiring.application.interview.state.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/interview/state")
public class InterviewStateV1RestAdapter {

    @Autowired
    private InterviewStateCommandApplicationPort interviewStateCommandApplicationPort;

    @PostMapping("acceptInterview")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void acceptInterview(@RequestBody AcceptInterview acceptInterview) {
        interviewStateCommandApplicationPort.acceptInterview(acceptInterview);
    }

    @PostMapping("launchInterview")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void launchInterview(@RequestBody LaunchInterview launchInterview) {
        interviewStateCommandApplicationPort.launchInterview(launchInterview);
    }

    @PostMapping("endInterviewExecution")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void endInterviewExecution(@RequestBody EndInterviewExecution endInterviewExecution){
        interviewStateCommandApplicationPort.endInterviewExecution(endInterviewExecution);
    }
}
