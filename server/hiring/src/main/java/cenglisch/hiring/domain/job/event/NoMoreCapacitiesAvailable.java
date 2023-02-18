package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.DomainEvent;
import cenglisch.hiring.domain.job.JobId;

public record NoMoreCapacitiesAvailable(JobId jobId) implements JobEvent {
}
