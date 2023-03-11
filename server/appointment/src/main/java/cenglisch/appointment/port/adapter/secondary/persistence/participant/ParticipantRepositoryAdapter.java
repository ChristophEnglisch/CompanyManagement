package cenglisch.appointment.port.adapter.secondary.persistence.participant;

import cenglisch.appointment.domain.model.participant.Participant;
import cenglisch.appointment.domain.model.participant.ParticipantId;
import cenglisch.appointment.domain.model.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParticipantRepositoryAdapter implements ParticipantRepository {
    @Autowired
    private ParticipantJpaRepository participantJpaRepository;

    @Autowired
    private ParticipantMapper participantMapper;

    public Optional<Participant> find(ParticipantId participantId) {
        Optional<ParticipantEntity> optionalParticipant = participantJpaRepository.findById(participantId.getId());
        return optionalParticipant.map(participantEntity -> participantMapper.toParticipant(participantEntity));
    }

    public Participant save(Participant participant) {
        participant.setParticipantId(new ParticipantId(generateId()));
        ParticipantEntity participantEntity = participantMapper.toParticipantEntity(participant);
        participantJpaRepository.saveAndFlush(participantEntity);
        return participantMapper.toParticipant(participantEntity);
    }

    @Override
    public void remove(Participant participant) {

    }
}
