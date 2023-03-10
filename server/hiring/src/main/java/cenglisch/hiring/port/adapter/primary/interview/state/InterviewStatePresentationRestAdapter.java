package cenglisch.hiring.port.adapter.primary.interview.state;

import cenglisch.hiring.application.interview.state.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/interview/state")
public class InterviewStatePresentationRestAdapter {

    @Autowired
    private InterviewStateApplicationPort interviewStateApplicationPort;

    @PostMapping("acceptInterview")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void acceptInterview(@RequestBody AcceptInterview acceptInterview) {
        interviewStateApplicationPort.acceptInterview(acceptInterview);
    }

    @PostMapping("launchInterview")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void launchInterview(@RequestBody LaunchInterview launchInterview) {
        interviewStateApplicationPort.launchInterview(launchInterview);
    }

    @PostMapping("endInterviewExecution")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void endInterviewExecution(@RequestBody EndInterviewExecution endInterviewExecution){
        interviewStateApplicationPort.endInterviewExecution(endInterviewExecution);
    }
}
