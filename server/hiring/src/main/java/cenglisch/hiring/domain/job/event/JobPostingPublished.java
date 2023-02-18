package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.DomainEvent;
import cenglisch.hiring.domain.job.JobId;

public record JobPostingPublished(JobId jobId) implements JobEvent {
}