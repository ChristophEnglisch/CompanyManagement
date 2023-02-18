package cenglisch.hiring.port.adapter.primary.person;

import cenglisch.hiring.application.person.DeposePersonalInformation;
import cenglisch.hiring.application.person.PersonApplicationPort;
import cenglisch.hiring.domain.person.PersonId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/person")
public class PersonPresentationRestAdapter {
    @Autowired
    private PersonApplicationPort personApplicationPort;

    @PostMapping
    public void deposePersonalInformation(@RequestBody DeposePersonalInformation deposePersonalInformation) {
        personApplicationPort.deposePersonalInformation(deposePersonalInformation);
    }

}
