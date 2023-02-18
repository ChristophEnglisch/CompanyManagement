package cenglisch.hiring.port.adapter.secondary.database.candidate;

import cenglisch.common.domain.Default;
import cenglisch.hiring.domain.candidate.CandidateState;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String personId;

    private String jobId;

    @Enumerated
    private CandidateState candidateState;

    public CandidateEntity() {
    }

    @Default
    public CandidateEntity(String id, String jobId, String personId, CandidateState candidateState) {
        this.id = id;
        this.jobId = jobId;
        this.personId = personId;
        this.candidateState = candidateState;
    }

    public String getId() {
        return id;
    }

    public String getJobId() {
        return jobId;
    }

    public String getPersonId() {
        return personId;
    }

    public CandidateState getCandidateState() {
        return candidateState;
    }
}