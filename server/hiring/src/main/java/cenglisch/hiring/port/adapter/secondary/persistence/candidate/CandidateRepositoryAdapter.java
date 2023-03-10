package cenglisch.hiring.port.adapter.secondary.persistence.candidate;

import cenglisch.hiring.domain.model.candidate.Candidate;
import cenglisch.hiring.domain.model.candidate.CandidateId;
import cenglisch.hiring.domain.model.candidate.CandidateRepository;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.domain.model.PersonId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateRepositoryAdapter implements CandidateRepository {
    @Autowired
    private CandidateJpaRepository candidateRepository;
    @Autowired
    private CandidateMapper candidateMapper;


    public Optional<Candidate> find(CandidateId id) {
        Optional<CandidateEntity> optionalPerson = candidateRepository.findById(id.getId());
        return optionalPerson.map(candidateEntity -> candidateMapper.mapToCandidate(candidateEntity));
    }

    public Candidate save(Candidate candidate) {
        if (candidate.getCandidateId() == null){
            candidate.setCandidateId(new CandidateId(generateId()));
        }
        candidateRepository.saveAndFlush(
                candidateMapper.mapToCandidateEntity(candidate)
        );
        return candidate;
    }

    @Override
    public void remove(Candidate candidate) {

    }

    public String generateId() {
        return CandidateRepository.super.generateId();
    }

    @Override
    public boolean existsByJobId(JobId jobId) {
        return candidateRepository.existsByJobId(jobId.getId());
    }

    @Override
    public boolean existsByPersonIdAndJobId(PersonId personId, JobId jobId) {
        return candidateRepository.existsByPersonIdAndJobId(personId.getId(), jobId.getId());
    }
}
