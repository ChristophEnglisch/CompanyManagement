package cenglisch.appointment.port.adapter.secondary.persistence.appointment;

import cenglisch.appointment.domain.model.appointment.Appointment;
import cenglisch.appointment.domain.model.participant.ParticipantId;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.date.AppointmentDateMapper;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantEntity;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantJpaRepository;
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
