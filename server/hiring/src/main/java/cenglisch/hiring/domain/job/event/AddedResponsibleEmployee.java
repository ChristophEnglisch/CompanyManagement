package cenglisch.hiring.domain.job.event;

import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.job.ResponsibleEmployee;

public record AddedResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) implements JobEvent {
}
