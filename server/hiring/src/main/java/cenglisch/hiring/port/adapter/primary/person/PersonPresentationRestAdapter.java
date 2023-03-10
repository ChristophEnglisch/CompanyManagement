package cenglisch.hiring.port.adapter.primary.person;

import cenglisch.hiring.application.person.DeposePersonalInformation;
import cenglisch.hiring.application.person.PersonApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/person")
public class PersonPresentationRestAdapter {
    @Autowired
    private PersonApplicationPort personApplicationPort;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deposePersonalInformation(@RequestBody DeposePersonalInformation deposePersonalInformation) {
        personApplicationPort.deposePersonalInformation(deposePersonalInformation);
    }

}
