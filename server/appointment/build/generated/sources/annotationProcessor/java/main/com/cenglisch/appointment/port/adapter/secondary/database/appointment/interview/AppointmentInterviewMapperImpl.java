package com.cenglisch.appointment.port.adapter.secondary.database.appointment.interview;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterview;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T14:18:13+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class AppointmentInterviewMapperImpl implements AppointmentInterviewMapper {

    @Override
    public AppointmentInterviewEntity toAppointmentInterviewEntity(AppointmentInterview appointmentInterview) {
        if ( appointmentInterview == null ) {
            return null;
        }

        String id = null;
        String appointmentId = null;

        id = appointmentInterviewAppointmentInterviewIdId( appointmentInterview );
        appointmentId = appointmentInterviewAppointmentIdId( appointmentInterview );

        AppointmentInterviewEntity appointmentInterviewEntity = new AppointmentInterviewEntity( id, appointmentId );

        return appointmentInterviewEntity;
    }

    @Override
    public AppointmentInterview toAppointmentInterview(AppointmentInterviewEntity appointmentInterviewEntity) {
        if ( appointmentInterviewEntity == null ) {
            return null;
        }

        AppointmentInterviewId appointmentInterviewId = null;
        AppointmentId appointmentId = null;

        appointmentInterviewId = appointmentInterviewEntityToAppointmentInterviewId( appointmentInterviewEntity );
        appointmentId = appointmentInterviewEntityToAppointmentId( appointmentInterviewEntity );

        AppointmentInterview appointmentInterview = new AppointmentInterview( appointmentInterviewId, appointmentId );

        return appointmentInterview;
    }

    private String appointmentInterviewAppointmentInterviewIdId(AppointmentInterview appointmentInterview) {
        if ( appointmentInterview == null ) {
            return null;
        }
        AppointmentInterviewId appointmentInterviewId = appointmentInterview.getAppointmentInterviewId();
        if ( appointmentInterviewId == null ) {
            return null;
        }
        String id = appointmentInterviewId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String appointmentInterviewAppointmentIdId(AppointmentInterview appointmentInterview) {
        if ( appointmentInterview == null ) {
            return null;
        }
        AppointmentId appointmentId = appointmentInterview.getAppointmentId();
        if ( appointmentId == null ) {
            return null;
        }
        String id = appointmentId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AppointmentInterviewId appointmentInterviewEntityToAppointmentInterviewId(AppointmentInterviewEntity appointmentInterviewEntity) {
        if ( appointmentInterviewEntity == null ) {
            return null;
        }

        String id = null;

        id = appointmentInterviewEntity.getId();

        AppointmentInterviewId appointmentInterviewId = new AppointmentInterviewId( id );

        return appointmentInterviewId;
    }

    protected AppointmentId appointmentInterviewEntityToAppointmentId(AppointmentInterviewEntity appointmentInterviewEntity) {
        if ( appointmentInterviewEntity == null ) {
            return null;
        }

        String id = null;

        id = appointmentInterviewEntity.getAppointmentId();

        AppointmentId appointmentId = new AppointmentId( id );

        return appointmentId;
    }
}
