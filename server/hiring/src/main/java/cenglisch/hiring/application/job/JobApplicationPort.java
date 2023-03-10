package cenglisch.hiring.application.job;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.candidate.CandidateRepository;
import cenglisch.hiring.domain.candidate.event.CandidateAdopted;
import cenglisch.hiring.domain.job.exception.JobException;
import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.job.JobService;

public class JobApplicationPort {
    private final JobService jobService;

    private final CandidateRepository candidateRepository;

    public JobApplicationPort(JobService jobService, CandidateRepository candidateRepository, EventHandler eventHandler) {
        this.jobService = jobService;
        this.candidateRepository = candidateRepository;
        eventHandler.subscribe(
                CandidateAdopted.class, event -> {
                    reduceCapacities(new ReduceCapacities(event.jobId()));
                }
        );
    }

    private boolean jobAlreadyHasApplicants(JobId jobId) {
        return candidateRepository.existsByJobId(jobId);
    }

    private void manageJob(JobId jobId){

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