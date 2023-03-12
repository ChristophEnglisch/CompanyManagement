package cenglisch.hiring.port.adapter.primary.person;

import cenglisch.hiring.application.person.DeposePersonalInformation;
import cenglisch.hiring.application.person.PersonCommandApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/person")
public class PersonV1RestAdapter {
    @Autowired
    private PersonCommandApplicationPort personCommandApplicationPort;
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deposePersonalInformation(@RequestBody DeposePersonalInformation deposePersonalInformation) {
        personCommandApplicationPort.deposePersonalInformation(deposePersonalInformation);
    }

}
