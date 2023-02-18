package com.cenglisch.appointment.port.adapter.primary.participant;

import com.cenglisch.appointment.application.participant.NewParticipant;
import com.cenglisch.appointment.application.participant.ParticipantApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/participant")
public class ParticipantPresentationRestAdapter {

    @Autowired
    private ParticipantApplicationPort participantApplicationPort;

    @PostMapping("newParticipant")
    public void newParticipant(@RequestBody NewParticipant newParticipant){
        participantApplicationPort.newParticipant(newParticipant);
    }
}
