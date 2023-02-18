package com.cenglisch.appointment.port.adapter.secondary.database.participant;

import com.cenglisch.appointment.domain.participant.Participant;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import com.cenglisch.appointment.domain.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParticipantRepositoryAdapter implements ParticipantRepository {
    @Autowired
    private ParticipantJpaRepository participantJpaRepository;

    @Autowired
    private ParticipantMapper participantMapper;

    public Optional<Participant> findById(ParticipantId participantId) {
        Optional<ParticipantEntity> optionalParticipant = participantJpaRepository.findById(participantId.getId());
        return optionalParticipant.map(participantEntity -> participantMapper.toParticipant(participantEntity));
    }

    public Participant save(Participant participant) {
        participant.setParticipantId(new ParticipantId(generateId()));
        ParticipantEntity participantEntity = participantMapper.toParticipantEntity(participant);
        participantJpaRepository.saveAndFlush(participantEntity);
        return participantMapper.toParticipant(participantEntity);
    }
}
