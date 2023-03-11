package cenglisch.hiring.port.adapter.secondary.persistence.interview;

import cenglisch.hiring.domain.candidate.CandidateId;
import cenglisch.hiring.domain.interview.Interview;
import cenglisch.hiring.domain.interview.InterviewId;
import cenglisch.hiring.domain.interview.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterviewRepositoryAdapter implements InterviewRepository {

    @Autowired
    private InterviewJpaRepository interviewRepository;

    @Autowired
    private InterviewMapper interviewMapper;

    public Optional<Interview> find(InterviewId id) {
        Optional<InterviewEntity> optionalInterview = interviewRepository.findById(id.getId());
        return optionalInterview.map(interviewEntity -> interviewMapper.mapToInterview(interviewEntity));
    }


    public Interview save(Interview interview) {
        if (interview.getInterviewId() == null){
            interview.setInterviewId(new InterviewId(generateId()));
        }
        interviewRepository.saveAndFlush(
                interviewMapper.mapToInterviewEntity(interview)
        );
        return interview;
    }

    @Override
    public void remove(Interview interview) {

    }

    public Optional<Interview> findByCandidateId(CandidateId candidateId) {
        Optional<InterviewEntity> optionalInterview = interviewRepository.findByCandidateId(candidateId.getId());
        return optionalInterview.map(interviewEntity -> interviewMapper.mapToInterview(interviewEntity));
    }
}
