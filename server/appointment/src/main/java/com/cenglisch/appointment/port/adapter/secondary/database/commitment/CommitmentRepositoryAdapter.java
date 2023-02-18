package com.cenglisch.appointment.port.adapter.secondary.database.commitment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.commitment.Commitment;
import com.cenglisch.appointment.domain.commitment.CommitmentId;
import com.cenglisch.appointment.domain.commitment.CommitmentRepository;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentJpaRepository;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Commitment save(Commitment commitment) {
        if (commitment.getCommitmentId() == null){
            commitment.setCommitmentId(new CommitmentId(generateId()));
        }
        commitmentJpaRepository.save(commitmentMapper.toCommitmentEntity(commitment, appointmentJpaRepository, participantJpaRepository));
        return commitment;
    }

    public Collection<Commitment> findByAppointmentId(AppointmentId appointmentId) {
        return commitmentMapper.toCommitmentCollection(commitmentJpaRepository.findByAppointmentId(appointmentId.getId()));
    }
}
