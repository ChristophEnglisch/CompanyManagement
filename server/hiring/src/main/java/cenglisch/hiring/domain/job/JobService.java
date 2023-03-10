package cenglisch.hiring.domain.job;

import cenglisch.domain.model.EventHandler;
import cenglisch.hiring.domain.job.event.*;
import cenglisch.hiring.domain.job.exception.JobNotFoundException;

import java.util.Optional;
import java.util.function.Consumer;

public class JobService {

    private final JobRepository jobRepository;

    private final EventHandler eventHandler;

    public JobService(JobRepository jobRepository, EventHandler eventHandler) {
        this.jobRepository = jobRepository;
        this.eventHandler = eventHandler;
    }

    private Optional<Job> find(JobId jobId) {
        return jobRepository.find(jobId);
    }

    private void manageJob(JobId jobId, Consumer<Job> jobConsumer, JobEventHiring jobEvent) {
        Job job = find(jobId).orElseThrow(JobNotFoundException::new);
        jobConsumer.accept(job);
        jobRepository.save(job);
        eventHandler.publish(jobEvent);
    }

    public boolean capacitiesAvailable(JobId jobId) {
        Job job = find(jobId).orElseThrow(JobNotFoundException::new);
        return job.isPublished();
    }

    public void newJobPosting(String jobName, int neededCapacities) {
        Job job = jobRepository.save(new Job(jobName, neededCapacities));
        eventHandler.publish(new JobPostingCreated(job.getJobId()));
    }

    public void publishJobPosting(JobId jobId, int neededCapacities) {
        manageJob(
                jobId,
                job -> job.publishJobPosting(neededCapacities),
                new JobPostingPublished(jobId)
        );
    }

    public void reduceCapacities(JobId jobId) {
        Job job = find(jobId).orElseThrow(JobNotFoundException::new);
        job.reduceCapacities();
        jobRepository.save(job);
        if (!job.isPublished()) {
            eventHandler.publish(new NoMoreCapacitiesAvailable(job.getJobId()));
        }
        eventHandler.publish(new JobCapacitiesReduced(job.getJobId()));
    }

    public void addResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) {
        manageJob(
                jobId,
                job -> job.addResponsibleEmployee(responsibleEmployee),
                new AddedResponsibleEmployee(jobId, responsibleEmployee)
        );
    }

    public void removeResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) {
        manageJob(
                jobId,
                job -> job.removeResponsibleEmployee(responsibleEmployee),
                new RemovedResponsibleEmployee(jobId, responsibleEmployee)
        );
    }
}