package cenglisch.hiring.domain.model.job.event;

import cenglisch.hiring.domain.model.job.JobId;

public record NoMoreCapacitiesAvailable(JobId jobId) implements JobEventHiring {
}
