package com.cenglisch.appointment.port.adapter.secondary.database.appointment.interview;

import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterview;
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
