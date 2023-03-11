package cenglisch.hiring.domain.model.job.event;

import cenglisch.hiring.domain.model.job.JobId;

public record JobPostingCreated(JobId jobId) implements JobEventHiring {
}
