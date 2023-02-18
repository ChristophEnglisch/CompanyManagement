package cenglisch.hiring.application.job;

import cenglisch.hiring.domain.job.JobId;

public record PublishJobPosting(JobId jobId, int neededCapacities) {

}