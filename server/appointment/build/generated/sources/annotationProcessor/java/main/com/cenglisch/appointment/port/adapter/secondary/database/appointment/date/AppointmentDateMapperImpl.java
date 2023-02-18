package com.cenglisch.appointment.port.adapter.secondary.database.appointment.date;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.date.AppointmentDate;
import com.cenglisch.appointment.domain.appointment.date.AppointmentDateId;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentJpaRepository;
import java.sql.Date;
import java.sql.Time;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T14:18:14+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class AppointmentDateMapperImpl implements AppointmentDateMapper {

    @Override
    public AppointmentDate mapToAppointmentDate(AppointmentDateEntity appointmentDateEntity) {
        if ( appointmentDateEntity == null ) {
            return null;
        }

        AppointmentId appointmentId = null;
        Date date = null;
        Time startTime = null;
        Time endTime = null;

        appointmentId = appointmentEntityToAppointmentId( appointmentDateEntity.getAppointment() );
        date = appointmentDateEntity.getDate();
        startTime = appointmentDateEntity.getStartTime();
        endTime = appointmentDateEntity.getEndTime();

        AppointmentDate appointmentDate = new AppointmentDate( appointmentId, date, startTime, endTime );

        appointmentDate.setAppointmentDateId( appointmentDateEntityToAppointmentDateId( appointmentDateEntity ) );

        return appointmentDate;
    }

    @Override
    public AppointmentDateEntity mapToAppointmentDateEntity(AppointmentDate appointmentDate, AppointmentJpaRepository appointmentRepository) {
        if ( appointmentDate == null ) {
            return null;
        }

        String id = null;
        AppointmentEntity appointment = null;
        Date date = null;
        Time startTime = null;
        Time endTime = null;

        id = appointmentDateAppointmentDateIdId( appointmentDate );
        appointment = mapAppointmentIdToAppointmentEntity( appointmentDate.getAppointmentId(), appointmentRepository );
        date = appointmentDate.getDate();
        startTime = appointmentDate.getStartTime();
        endTime = appointmentDate.getEndTime();

        AppointmentDateEntity appointmentDateEntity = new AppointmentDateEntity( id, appointment, date, startTime, endTime );

        return appointmentDateEntity;
    }

    protected AppointmentDateId appointmentDateEntityToAppointmentDateId(AppointmentDateEntity appointmentDateEntity) {
        if ( appointmentDateEntity == null ) {
            return null;
        }

        String id = null;

        id = appointmentDateEntity.getId();

        AppointmentDateId appointmentDateId = new AppointmentDateId( id );

        return appointmentDateId;
    }

    protected AppointmentId appointmentEntityToAppointmentId(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        String id = null;

        id = appointmentEntity.getId();

        AppointmentId appointmentId = new AppointmentId( id );

        return appointmentId;
    }

    private String appointmentDateAppointmentDateIdId(AppointmentDate appointmentDate) {
        if ( appointmentDate == null ) {
            return null;
        }
        AppointmentDateId appointmentDateId = appointmentDate.getAppointmentDateId();
        if ( appointmentDateId == null ) {
            return null;
        }
        String id = appointmentDateId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
