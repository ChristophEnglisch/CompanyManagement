package cenglisch.appointment.port.adapter.secondary.persistence.appointment.interview;

import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterview;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AppointmentInterviewMapper {
    @Mapping(target = "id", source = "appointmentInterviewId.id")
    @Mapping(target = "appointmentId", source = "appointmentId.id")
    AppointmentInterviewEntity toAppointmentInterviewEntity(AppointmentInterview appointmentInterview);

    @Mapping(target = "appointmentInterviewId.id", source = "id")
    @Mapping(target = "appointmentId.id", source = "appointmentId")
    AppointmentInterview toAppointmentInterview(AppointmentInterviewEntity appointmentInterviewEntity);
}
