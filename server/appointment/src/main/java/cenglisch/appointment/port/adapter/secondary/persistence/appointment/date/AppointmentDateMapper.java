package cenglisch.appointment.port.adapter.secondary.persistence.appointment.date;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.appointment.date.AppointmentDate;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentEntity;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentJpaRepository;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AppointmentDateMapper {

    @Mapping(target = "appointmentDateId.id", source = "id")
    @Mapping(target = "appointmentId.id", source = "appointment.id")
    @Named("mapToAppointmentDate")
    AppointmentDate mapToAppointmentDate(AppointmentDateEntity appointmentDateEntity);

    @Mapping(target = "id", source = "appointmentDateId.id")
    @Mapping(target = "appointment", source = "appointmentId", qualifiedByName = "mapAppointmentIdToAppointmentEntity")
    @Named("mapToAppointmentDateEntity")
    AppointmentDateEntity mapToAppointmentDateEntity(AppointmentDate appointmentDate, @Context AppointmentJpaRepository appointmentRepository);

    @Named("mapAppointmentIdToAppointmentEntity")
    default AppointmentEntity mapAppointmentIdToAppointmentEntity(AppointmentId appointmentId, @Context AppointmentJpaRepository appointmentRepository) {
        return appointmentRepository.findById(appointmentId.getId()).orElse(null);
    }
}
