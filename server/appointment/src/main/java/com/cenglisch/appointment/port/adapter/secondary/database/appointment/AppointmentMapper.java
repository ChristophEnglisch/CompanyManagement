package com.cenglisch.appointment.port.adapter.secondary.database.appointment;

import com.cenglisch.appointment.domain.appointment.Appointment;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.date.AppointmentDateMapper;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = AppointmentDateMapper.class
)
public interface AppointmentMapper {

    @Mapping(target = "appointmentId.id", source = "id")
    @Mapping(target = "schedulingParticipant.id", source = "schedulingParticipant.id")
    @Mapping(target = "participants", source = "participants", qualifiedByName = "mapParticipantEntityToParticipantId")
    @Mapping(target = "appointmentDate", source = "publishedAppointmentDate", qualifiedByName = "mapToAppointmentDate")
    Appointment mapToAppointment(AppointmentEntity appointmentEntity);

    @Named("mapParticipantEntityToParticipantId")
    default List<ParticipantId> mapParticipantEntityToParticipantId(Collection<ParticipantEntity> participantEntities) {
        return participantEntities.stream()
                .map(participantEntity -> new ParticipantId(participantEntity.getId()))
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", source = "appointmentId.id")
    @Mapping(target = "schedulingParticipant", source = "schedulingParticipant", qualifiedByName = "mapParticipantIdToParticipantEntity")
    @Mapping(target = "participants", source = "participants", qualifiedByName = "mapParticipantIdToParticipantEntity")
    @Mapping(target = "publishedAppointmentDate", source = "appointmentDate", qualifiedByName = "mapToAppointmentDateEntity")
    AppointmentEntity mapToAppointmentEntity(
            Appointment appointment,
            @Context ParticipantJpaRepository participantRepository,
            @Context AppointmentJpaRepository appointmentJpaRepository
    );

    @Named("mapParticipantIdToParticipantEntity")
    default ParticipantEntity mapParticipantIdToParticipantEntity(ParticipantId participantId, @Context ParticipantJpaRepository participantRepository) {
        if (participantId == null || participantId.getId() == null){
            return null;
        }
        return participantRepository.findById(participantId.getId()).orElse(null);
    }
}
