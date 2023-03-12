package cenglisch.hiring.port.adapter.primary.candidate;

import cenglisch.hiring.application.candidate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/candidate")
public class CandidateV1RestAdapter {
    @Autowired
    private CandidateCommandApplicationPort candidateCommandApplicationPort;

    @PostMapping("candidateApplies")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void candidateApplies(@RequestBody CandidateApplies candidateApplies) {
        candidateCommandApplicationPort.candidateApplies(candidateApplies);
    }

    @PostMapping("approveCandidateApplication")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void approveCandidateApplication(@RequestBody ApproveCandidateApplication approveCandidateApplication) {
        candidateCommandApplicationPort.approveCandidateApplication(approveCandidateApplication);
    }

    @PostMapping("rejectCandidateApplication")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rejectCandidateApplication(@RequestBody RejectCandidateApplication rejectCandidateApplication) {
        candidateCommandApplicationPort.rejectCandidateApplication(rejectCandidateApplication);
    }

    @PostMapping("adoptCandidate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adoptCandidate(@RequestBody AdoptCandidate adoptCandidate) {
        candidateCommandApplicationPort.adoptCandidate(adoptCandidate);
    }

    @PostMapping("rejectCandidate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rejectCandidate(@RequestBody RejectCandidate rejectCandidate) {
        candidateCommandApplicationPort.rejectCandidate(rejectCandidate);
    }
}