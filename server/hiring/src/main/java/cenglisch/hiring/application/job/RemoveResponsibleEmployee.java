package cenglisch.hiring.application.job;

import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.job.ResponsibleEmployee;

public record RemoveResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) {
}
