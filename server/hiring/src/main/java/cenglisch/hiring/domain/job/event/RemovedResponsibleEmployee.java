package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.job.ResponsibleEmployee;

public record RemovedResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) implements JobEventHiring {
}
