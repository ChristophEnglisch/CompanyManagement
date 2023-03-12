package cenglisch.hiring.application.job;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.model.candidate.CandidateRepository;
import cenglisch.hiring.domain.model.candidate.event.CandidateAdopted;
import cenglisch.hiring.domain.model.job.exception.JobException;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.job.JobService;

public class JobCommandApplicationPort {
    private final JobService jobService;

    private final CandidateRepository candidateRepository;

    public JobCommandApplicationPort(JobService jobService, CandidateRepository candidateRepository, EventHandler eventHandler) {
        this.jobService = jobService;
        this.candidateRepository = candidateRepository;
        eventHandler.subscribe(
                CandidateAdopted.class, event -> {
                    reduceCapacities(new ReduceCapacities(event.jobId()));
                }
        );
    }

    private boolean jobAlreadyHasApplicants(JobId jobId) {
        //TODO move to Query Application Port
        return candidateRepository.existsByJobId(jobId);
    }

    public void newJobPosting(NewJobPosting newJobPosting) {
        jobService.newJobPosting(
                newJobPosting.jobName(),
                newJobPosting.neededCapacities()
        );
    }

    public void publishJobPosting(PublishJobPosting publishJobPosting) {
        jobService.publishJobPosting(
                publishJobPosting.jobId(),
                publishJobPosting.neededCapacities()
        );
    }

    public void reduceCapacities(ReduceCapacities reduceCapacities) {
        jobService.reduceCapacities(
                reduceCapacities.jobId()
        );
    }

    public void addResponsibleEmployee(AddResponsibleEmployee addResponsibleEmployee) {
        if (jobAlreadyHasApplicants(addResponsibleEmployee.jobId())) {
            throw new JobException("job already has applicants");
        }
        jobService.addResponsibleEmployee(addResponsibleEmployee.jobId(), addResponsibleEmployee.responsibleEmployee());
    }

    public void removeResponsibleEmployee(RemoveResponsibleEmployee removeResponsibleEmployee) {
        if (jobAlreadyHasApplicants(removeResponsibleEmployee.jobId())) {
            throw new JobException("job already has applicants");
        }
        jobService.removeResponsibleEmployee(removeResponsibleEmployee.jobId(), removeResponsibleEmployee.responsibleEmployee());
    }
}