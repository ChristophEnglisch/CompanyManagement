package cenglisch.hiring.application.job;

import cenglisch.hiring.domain.model.job.JobId;

public record PublishJobPosting(JobId jobId, int neededCapacities) {

}