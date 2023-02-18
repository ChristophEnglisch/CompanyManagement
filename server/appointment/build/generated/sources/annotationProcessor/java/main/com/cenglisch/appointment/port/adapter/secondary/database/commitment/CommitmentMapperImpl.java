package com.cenglisch.appointment.port.adapter.secondary.database.commitment;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.commitment.Commitment;
import com.cenglisch.appointment.domain.commitment.CommitmentId;
import com.cenglisch.appointment.domain.commitment.CommitmentState;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentJpaRepository;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantEntity;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T14:24:57+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CommitmentMapperImpl implements CommitmentMapper {

    @Override
    public Commitment toCommitment(CommitmentEntity commitmentEntity) {
        if ( commitmentEntity == null ) {
            return null;
        }

        CommitmentId commitmentId = null;
        AppointmentId appointmentId = null;
        ParticipantId participantId = null;
        CommitmentState commitmentState = null;

        commitmentId = commitmentEntityToCommitmentId( commitmentEntity );
        appointmentId = appointmentEntityToAppointmentId( commitmentEntity.getAppointment() );
        participantId = participantEntityToParticipantId( commitmentEntity.getParticipant() );
        commitmentState = commitmentEntity.getCommitmentState();

        Commitment commitment = new Commitment( commitmentId, appointmentId, participantId, commitmentState );

        return commitment;
    }

    @Override
    public CommitmentEntity toCommitmentEntity(Commitment commitment, AppointmentJpaRepository appointmentRepository, ParticipantJpaRepository participantRepository) {
        if ( commitment == null ) {
            return null;
        }

        String id = null;
        AppointmentEntity appointment = null;
        ParticipantEntity participant = null;
        CommitmentState commitmentState = null;

        id = commitmentCommitmentIdId( commitment );
        appointment = mapAppointmentIdToAppointmentEntity( commitment.getAppointmentId(), appointmentRepository );
        participant = mapParticipantIdToParticipantEntity( commitment.getParticipantId(), participantRepository );
        commitmentState = commitment.getCommitmentState();

        CommitmentEntity commitmentEntity = new CommitmentEntity( id, appointment, participant, commitmentState );

        return commitmentEntity;
    }

    protected CommitmentId commitmentEntityToCommitmentId(CommitmentEntity commitmentEntity) {
        if ( commitmentEntity == null ) {
            return null;
        }

        String id = null;

        id = commitmentEntity.getId();

        CommitmentId commitmentId = new CommitmentId( id );

        return commitmentId;
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

    private String commitmentCommitmentIdId(Commitment commitment) {
        if ( commitment == null ) {
            return null;
        }
        CommitmentId commitmentId = commitment.getCommitmentId();
        if ( commitmentId == null ) {
            return null;
        }
        String id = commitmentId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
