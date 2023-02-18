package cenglisch.hiring.application.job;

import cenglisch.hiring.domain.job.JobId;
import cenglisch.hiring.domain.job.ResponsibleEmployee;

public record AddResponsibleEmployee(JobId jobId, ResponsibleEmployee responsibleEmployee) {
}
