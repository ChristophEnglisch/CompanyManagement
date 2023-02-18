package com.cenglisch.appointment.port.adapter.secondary.database.appointment;

import com.cenglisch.appointment.domain.appointment.Appointment;
import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.AppointmentInformation;
import com.cenglisch.appointment.domain.appointment.AppointmentState;
import com.cenglisch.appointment.domain.appointment.AppointmentType;
import com.cenglisch.appointment.domain.appointment.date.AppointmentDate;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.date.AppointmentDateEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.date.AppointmentDateMapper;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T14:18:13+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    private final AppointmentDateMapper appointmentDateMapper;

    @Autowired
    public AppointmentMapperImpl(AppointmentDateMapper appointmentDateMapper) {

        this.appointmentDateMapper = appointmentDateMapper;
    }

    @Override
    public Appointment mapToAppointment(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        AppointmentId appointmentId = null;
        ParticipantId schedulingParticipant = null;
        Collection<ParticipantId> participants = null;
        AppointmentDate appointmentDate = null;
        AppointmentType appointmentType = null;
        AppointmentState appointmentState = null;
        AppointmentInformation appointmentInformation = null;

        appointmentId = appointmentEntityToAppointmentId( appointmentEntity );
        schedulingParticipant = participantEntityToParticipantId( appointmentEntity.getSchedulingParticipant() );
        participants = mapParticipantEntityToParticipantId( appointmentEntity.getParticipants() );
        appointmentDate = appointmentDateMapper.mapToAppointmentDate( appointmentEntity.getPublishedAppointmentDate() );
        appointmentType = appointmentEntity.getAppointmentType();
        appointmentState = appointmentEntity.getAppointmentState();
        appointmentInformation = appointmentEntity.getAppointmentInformation();

        Appointment appointment = new Appointment( appointmentId, schedulingParticipant, participants, appointmentDate, appointmentType, appointmentState, appointmentInformation );

        return appointment;
    }

    @Override
    public AppointmentEntity mapToAppointmentEntity(Appointment appointment, ParticipantJpaRepository participantRepository, AppointmentJpaRepository appointmentJpaRepository) {
        if ( appointment == null ) {
            return null;
        }

        String id = null;
        ParticipantEntity schedulingParticipant = null;
        Collection<ParticipantEntity> participants = null;
        AppointmentDateEntity publishedAppointmentDate = null;
        AppointmentType appointmentType = null;
        AppointmentState appointmentState = null;
        AppointmentInformation appointmentInformation = null;

        id = appointmentAppointmentIdId( appointment );
        schedulingParticipant = mapParticipantIdToParticipantEntity( appointment.getSchedulingParticipant(), participantRepository );
        participants = participantIdCollectionToParticipantEntityCollection( appointment.getParticipants(), participantRepository, appointmentJpaRepository );
        publishedAppointmentDate = appointmentDateMapper.mapToAppointmentDateEntity( appointment.getAppointmentDate(), appointmentJpaRepository );
        appointmentType = appointment.getAppointmentType();
        appointmentState = appointment.getAppointmentState();
        appointmentInformation = appointment.getAppointmentInformation();

        AppointmentEntity appointmentEntity = new AppointmentEntity( id, schedulingParticipant, participants, publishedAppointmentDate, appointmentType, appointmentState, appointmentInformation );

        return appointmentEntity;
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

    protected ParticipantId participantEntityToParticipantId(ParticipantEntity participantEntity) {
        if ( participantEntity == null ) {
            return null;
        }

        String id = null;

        id = participantEntity.getId();

        ParticipantId participantId = new ParticipantId( id );

        return participantId;
    }

    private String appointmentAppointmentIdId(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        AppointmentId appointmentId = appointment.getAppointmentId();
        if ( appointmentId == null ) {
            return null;
        }
        String id = appointmentId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Collection<ParticipantEntity> participantIdCollectionToParticipantEntityCollection(Collection<ParticipantId> collection, ParticipantJpaRepository participantRepository, AppointmentJpaRepository appointmentJpaRepository) {
        if ( collection == null ) {
            return null;
        }

        Collection<ParticipantEntity> collection1 = new ArrayList<ParticipantEntity>( collection.size() );
        for ( ParticipantId participantId : collection ) {
            collection1.add( mapParticipantIdToParticipantEntity( participantId, participantRepository ) );
        }

        return collection1;
    }
}
