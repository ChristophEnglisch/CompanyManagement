package cenglisch.hiring.port.adapter.primary.interview.state;

import cenglisch.hiring.application.interview.state.AcceptInterview;
import cenglisch.hiring.application.interview.state.EndInterviewExecution;
import cenglisch.hiring.application.interview.state.InterviewStateCommandApplicationPort;
import cenglisch.hiring.application.interview.state.LaunchInterview;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterviewStateQueueListener {

    @Autowired
    private InterviewStateCommandApplicationPort interviewStateCommandApplicationPort;

    @RabbitListener(queues = "appointment.interview.accepted")
    public void acceptInterview(AcceptInterview acceptInterview) {
        interviewStateCommandApplicationPort.acceptInterview(acceptInterview);
    }

    @RabbitListener(queues = "appointment.interview.launched")
    public void launchInterview(LaunchInterview launchInterview) {
        interviewStateCommandApplicationPort.launchInterview(launchInterview);
    }

    @RabbitListener(queues = "appointment.interview.generated")
    public void endInterviewExecution(EndInterviewExecution endInterviewExecution){
        interviewStateCommandApplicationPort.endInterviewExecution(endInterviewExecution);
    }
}
