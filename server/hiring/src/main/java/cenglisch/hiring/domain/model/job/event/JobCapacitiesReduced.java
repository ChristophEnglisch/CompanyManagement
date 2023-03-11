package cenglisch.hiring.domain.model.job.event;

import cenglisch.hiring.domain.model.job.JobId;

public record JobCapacitiesReduced(JobId jobId) implements JobEventHiring {
}