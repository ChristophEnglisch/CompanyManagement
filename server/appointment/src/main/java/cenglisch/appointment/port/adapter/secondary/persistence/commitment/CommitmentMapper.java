package cenglisch.appointment.port.adapter.secondary.persistence.commitment;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.commitment.Commitment;
import cenglisch.appointment.domain.model.participant.ParticipantId;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentEntity;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentJpaRepository;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantEntity;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantJpaRepository;
import org.mapstruct.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CommitmentMapper {
    @Mapping(target = "commitmentId.id", source = "id")
    @Mapping(target = "appointmentId.id", source = "appointment.id")
    @Mapping(target = "participantId.id", source = "participant.id")
    Commitment toCommitment(CommitmentEntity commitmentEntity);

    @Mapping(target = "id", source = "commitmentId.id")
    @Mapping(target = "appointment", source = "appointmentId", qualifiedByName = "mapAppointmentIdToAppointmentEntity")
    @Mapping(target = "participant", source = "participantId", qualifiedByName = "mapParticipantIdToParticipantEntity")
    CommitmentEntity toCommitmentEntity(
            Commitment commitment,
            @Context AppointmentJpaRepository appointmentRepository,
            @Context ParticipantJpaRepository participantRepository
    );

    @Named("mapAppointmentIdToAppointmentEntity")
    default AppointmentEntity mapAppointmentIdToAppointmentEntity(AppointmentId appointmentId, @Context AppointmentJpaRepository appointmentRepository) {
        return appointmentRepository.findById(appointmentId.getId()).orElse(null);
    }

    @Named("mapParticipantIdToParticipantEntity")
    default ParticipantEntity mapParticipantIdToParticipantEntity(ParticipantId participantId, @Context ParticipantJpaRepository participantRepository) {
        return participantRepository.findById(participantId.getId()).orElse(null);
    }

    default Collection<Commitment> toCommitmentCollection(Collection<CommitmentEntity> commitmentEntityCollection){
            return commitmentEntityCollection.stream()
                    .map(this::toCommitment)
                    .collect(Collectors.toList());
    }
}
