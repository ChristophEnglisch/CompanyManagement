package cenglisch.hiring.domain.model.job.event;

import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.job.ResponsibleEmployee;

public record AddedResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) implements JobEventHiring {
}
