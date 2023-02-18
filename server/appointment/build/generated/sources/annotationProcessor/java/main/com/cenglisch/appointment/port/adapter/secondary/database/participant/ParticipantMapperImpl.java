package com.cenglisch.appointment.port.adapter.secondary.database.participant;

import com.cenglisch.appointment.domain.participant.Participant;
import com.cenglisch.appointment.domain.participant.ParticipantId;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T14:18:13+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Override
    public ParticipantEntity toParticipantEntity(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String email = null;

        id = participantParticipantIdId( participant );
        name = participant.getName();
        email = participant.getEmail();

        ParticipantEntity participantEntity = new ParticipantEntity( id, name, email );

        return participantEntity;
    }

    @Override
    public Participant toParticipant(ParticipantEntity participantEntity) {
        if ( participantEntity == null ) {
            return null;
        }

        ParticipantId participantId = null;
        String name = null;
        String email = null;

        participantId = participantEntityToParticipantId( participantEntity );
        name = participantEntity.getName();
        email = participantEntity.getEmail();

        Participant participant = new Participant( participantId, name, email );

        return participant;
    }

    private String participantParticipantIdId(Participant participant) {
        if ( participant == null ) {
            return null;
        }
        ParticipantId participantId = participant.getParticipantId();
        if ( participantId == null ) {
            return null;
        }
        String id = participantId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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
}
