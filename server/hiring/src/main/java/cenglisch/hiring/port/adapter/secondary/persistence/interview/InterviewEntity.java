package cenglisch.hiring.port.adapter.secondary.persistence.interview;

import cenglisch.Default;
import cenglisch.hiring.domain.model.interview.state.InterviewState;
import cenglisch.hiring.domain.model.interview.type.InterviewType;

import jakarta.persistence.*;

@Entity
@Table(name = "interview")
public class InterviewEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String candidateId;

    @Enumerated
    private InterviewState interviewState;

    @Enumerated
    private InterviewType interviewType;

    public InterviewEntity() {
    }

    @Default
    public InterviewEntity(String id, String candidateId, InterviewState interviewState, InterviewType interviewType) {
        this.id = id;
        this.candidateId = candidateId;
        this.interviewState = interviewState;
        this.interviewType = interviewType;
    }

    public String getId() {
        return id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public InterviewState getInterviewState() {
        return interviewState;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

}
