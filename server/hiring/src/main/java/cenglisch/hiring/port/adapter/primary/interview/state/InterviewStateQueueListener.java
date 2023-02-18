package cenglisch.hiring.port.adapter.primary.interview.state;

import cenglisch.hiring.application.interview.state.AcceptInterview;
import cenglisch.hiring.application.interview.state.EndInterviewExecution;
import cenglisch.hiring.application.interview.state.InterviewStateApplicationPort;
import cenglisch.hiring.application.interview.state.LaunchInterview;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterviewStateQueueListener {

    @Autowired
    private InterviewStateApplicationPort interviewStateApplicationPort;

    @RabbitListener(queues = "appointment.interview.accepted")
    public void acceptInterview(AcceptInterview acceptInterview) {
        interviewStateApplicationPort.acceptInterview(acceptInterview);
    }

    @RabbitListener(queues = "appointment.interview.launched")
    public void launchInterview(LaunchInterview launchInterview) {
        interviewStateApplicationPort.launchInterview(launchInterview);
    }

    @RabbitListener(queues = "appointment.interview.generated")
    public void endInterviewExecution(EndInterviewExecution endInterviewExecution){
        interviewStateApplicationPort.endInterviewExecution(endInterviewExecution);
    }
}
