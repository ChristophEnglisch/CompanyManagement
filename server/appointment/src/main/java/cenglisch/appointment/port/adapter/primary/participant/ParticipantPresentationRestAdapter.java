package cenglisch.appointment.port.adapter.primary.participant;

import cenglisch.appointment.application.participant.NewParticipant;
import cenglisch.appointment.application.participant.ParticipantApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/participant")
public class ParticipantPresentationRestAdapter {

    @Autowired
    private ParticipantApplicationPort participantApplicationPort;

    @PostMapping("newParticipant")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void newParticipant(@RequestBody NewParticipant newParticipant){
        participantApplicationPort.newParticipant(newParticipant);
    }
}
