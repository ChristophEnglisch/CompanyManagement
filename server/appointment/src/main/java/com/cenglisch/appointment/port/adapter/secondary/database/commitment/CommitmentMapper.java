package com.cenglisch.appointment.port.adapter.secondary.database.commitment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.commitment.Commitment;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentJpaRepository;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
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
