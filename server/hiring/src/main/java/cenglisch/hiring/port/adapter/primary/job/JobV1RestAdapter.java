package cenglisch.hiring.port.adapter.primary.job;

import cenglisch.hiring.application.job.JobApplicationPort;
import cenglisch.hiring.application.job.NewJobPosting;
import cenglisch.hiring.application.job.PublishJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/job")
public class JobV1RestAdapter {

    @Autowired
    private JobApplicationPort jobApplicationPort;

    @PostMapping("newJobPosting")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void newJobPosting(@RequestBody NewJobPosting newJobPosting) {
        jobApplicationPort.newJobPosting(newJobPosting);
    }

    @PostMapping("publishJobPosting")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishJobPosting(@RequestBody PublishJobPosting publishJobPosting) {
        jobApplicationPort.publishJobPosting(publishJobPosting);
    }
}
