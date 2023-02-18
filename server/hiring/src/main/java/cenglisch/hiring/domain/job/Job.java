package cenglisch.hiring.domain.job;

import cenglisch.common.domain.Default;
import cenglisch.hiring.domain.Entity;
import cenglisch.hiring.domain.job.exception.JobException;

import java.util.ArrayList;
import java.util.Collection;

public class Job extends Entity {

    private JobId jobId;

    private String jobName;

    private int neededCapacities;

    private boolean published;

    private Collection<ResponsibleEmployee> responsibleEmployees;

    public Job(final String pJobName, final int pNeededCapacities) {
        setJobName(pJobName);
        setNeededCapacities(pNeededCapacities);
        setPublished(pNeededCapacities > 0);
        this.responsibleEmployees = new ArrayList<>();
    }

    public Job(
        final JobId jobId,
        final String jobName,
        final int neededCapacities,
        final boolean published
    ) {
        setJobId(jobId);
        setJobName(jobName);
        setNeededCapacities(neededCapacities);
        setPublished(published);
        this.responsibleEmployees = new ArrayList<>();
    }

    @Default
    public Job(
            final JobId jobId,
            final String jobName,
            final int neededCapacities,
            final boolean published,
            final Collection<ResponsibleEmployee> responsibleEmployees
    ) {
        setJobId(jobId);
        setJobName(jobName);
        setNeededCapacities(neededCapacities);
        setPublished(published);
        this.responsibleEmployees = responsibleEmployees;
    }

    public final void reduceCapacities() {
        setNeededCapacities(neededCapacities - 1);
        if (!capacitiesAvailable()) {
            setPublished(false);
        }
    }

    public final void publishJobPosting(final int neededCapacities) {
        if (neededCapacities < 1){
            throw new JobException("job can not be published if needed capacities are lower than 1");
        }
        setNeededCapacities(neededCapacities);
        setPublished(true);
    }

    public final void addResponsibleEmployee(final ResponsibleEmployee responsibleEmployee){
        assertArgumentNotNull(responsibleEmployee, "responsible employee can not be null");
        this.responsibleEmployees.add(responsibleEmployee);
    }

    public final void removeResponsibleEmployee(final ResponsibleEmployee responsibleEmployee){
        assertArgumentNotNull(responsibleEmployee, "responsible employee can not be null");
        this.responsibleEmployees.remove(responsibleEmployee);
    }

    private boolean capacitiesAvailable() {
        return neededCapacities > 0;
    }

    public void setJobId(JobId pJobId) {
        assertArgumentNotNull(pJobId, "job id can not be null");
        this.jobId = pJobId;
    }

    private void setJobName(String pJobName) {
        assertArgumentNotNull(pJobName, "job name can not be null");
        assertArgumentLength(pJobName, 3, 30, "job name must be at least 1 and maximum 30 characters long");
        this.jobName = pJobName;
    }

    private void setNeededCapacities(int pNeedCapacities) {
        assertArgumentNotNull(pNeedCapacities, "need capacities can not be null");
        assertArgumentRange(pNeedCapacities, 0, 99, "needed capacities minimum is 0 or maximum 99");
        this.neededCapacities = pNeedCapacities;
    }

    private void setPublished(boolean pPublished) {
        assertArgumentNotNull(pPublished, "Published can not be null");
        this.published = pPublished;
    }

    public JobId getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getNeededCapacities() {
        return neededCapacities;
    }

    public boolean isPublished() {
        return published;
    }

    public Collection<ResponsibleEmployee> getResponsibleEmployees() {
        return responsibleEmployees;
    }
}
