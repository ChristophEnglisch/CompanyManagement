package cenglisch.hiring.port.adapter.secondary.persistence.job;

import cenglisch.Default;
import cenglisch.hiring.port.adapter.secondary.persistence.person.PersonEntity;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "job")
public class JobEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column
    private String jobName;

    @Column
    private int neededCapacities;

    @Column
    private boolean published;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "responsible_employees",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "responsible_employee_id")
    )
    private Collection<PersonEntity> responsibleEmployees;

    public JobEntity() {}

    @Default
    public JobEntity(String id, String jobName, int neededCapacities, boolean published, Collection<PersonEntity> responsibleEmployees) {
        this.id = id;
        this.jobName = jobName;
        this.neededCapacities = neededCapacities;
        this.published = published;
        this.responsibleEmployees = responsibleEmployees;
    }

    public String getId() {
        return id;
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

    public Collection<PersonEntity> getResponsibleEmployees() {
        return responsibleEmployees;
    }
}