package cenglisch.appointment.port.adapter.secondary.persistence.participant;

import cenglisch.appointment.domain.model.participant.Participant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ParticipantMapper {
    @Mapping(source = "participantId.id", target = "id")
    ParticipantEntity toParticipantEntity(Participant participant);

    @Mapping(source = "id", target = "participantId.id")
    Participant toParticipant(ParticipantEntity participantEntity);

}
