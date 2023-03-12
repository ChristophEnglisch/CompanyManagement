package cenglisch.appointment.port.adapter.primary.participant;

import cenglisch.appointment.application.participant.NewParticipant;
import cenglisch.appointment.application.participant.ParticipantCommandApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/participant")
public class ParticipantV1RestAdapter {

    @Autowired
    private ParticipantCommandApplicationPort participantCommandApplicationPort;

    @PostMapping("newParticipant")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void newParticipant(@RequestBody NewParticipant newParticipant){
        participantCommandApplicationPort.newParticipant(newParticipant);
    }
}
