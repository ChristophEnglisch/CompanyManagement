package cenglisch.hiring.port.adapter.primary.job;

import cenglisch.hiring.application.job.JobApplicationPort;
import cenglisch.hiring.application.job.NewJobPosting;
import cenglisch.hiring.application.job.PublishJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/job")
public class JobPresentationRestAdapter {

    @Autowired
    private JobApplicationPort jobApplicationPort;

    @PostMapping("newJobPosting")
    public void newJobPosting(@RequestBody NewJobPosting newJobPosting) {
        jobApplicationPort.newJobPosting(newJobPosting);
    }

    @PostMapping("publishJobPosting")
    public void publishJobPosting(@RequestBody PublishJobPosting publishJobPosting) {
        jobApplicationPort.publishJobPosting(publishJobPosting);
    }
}
