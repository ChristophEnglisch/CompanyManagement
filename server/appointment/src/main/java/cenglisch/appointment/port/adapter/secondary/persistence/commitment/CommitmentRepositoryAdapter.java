package cenglisch.appointment.port.adapter.secondary.persistence.commitment;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.commitment.Commitment;
import cenglisch.appointment.domain.model.commitment.CommitmentId;
import cenglisch.appointment.domain.model.commitment.CommitmentRepository;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentJpaRepository;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CommitmentRepositoryAdapter implements CommitmentRepository {

    @Autowired
    private CommitmentJpaRepository commitmentJpaRepository;

    @Autowired
    private ParticipantJpaRepository participantJpaRepository;

    @Autowired
    private AppointmentJpaRepository appointmentJpaRepository;

    @Autowired
    private CommitmentMapper commitmentMapper;

    public Optional<Commitment> findById(CommitmentId commitmentId) {
        Optional<CommitmentEntity> optionalCommitmentEntity = commitmentJpaRepository.findById(commitmentId.getId());
        return optionalCommitmentEntity.map(commitmentEntity -> commitmentMapper.toCommitment(commitmentEntity));
    }

    @Override
    public Optional<Commitment> find(CommitmentId id) {
        return Optional.empty();
    }

    public Commitment save(Commitment commitment) {
        if (commitment.getCommitmentId() == null){
            commitment.setCommitmentId(new CommitmentId(generateId()));
        }
        commitmentJpaRepository.save(commitmentMapper.toCommitmentEntity(commitment, appointmentJpaRepository, participantJpaRepository));
        return commitment;
    }

    @Override
    public void remove(Commitment commitment) {

    }

    public Collection<Commitment> findByAppointmentId(AppointmentId appointmentId) {
        return commitmentMapper.toCommitmentCollection(commitmentJpaRepository.findByAppointmentId(appointmentId.getId()));
    }
}
