package cenglisch.hiring.port.adapter.primary.candidate;

import cenglisch.hiring.application.candidate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/candidate")
public class CandidatePresentationRestAdapter {
    @Autowired
    private CandidateApplicationPort candidateApplicationPort;

    @PostMapping("candidateApplies")
    public void candidateApplies(@RequestBody CandidateApplies candidateApplies) {
        candidateApplicationPort.candidateApplies(candidateApplies);
    }

    @PostMapping("approveCandidateApplication")
    public void approveCandidateApplication(@RequestBody ApproveCandidateApplication approveCandidateApplication) {
        candidateApplicationPort.approveCandidateApplication(approveCandidateApplication);
    }

    @PostMapping("rejectCandidateApplication")
    public void rejectCandidateApplication(@RequestBody RejectCandidateApplication rejectCandidateApplication) {
        candidateApplicationPort.rejectCandidateApplication(rejectCandidateApplication);
    }

    @PostMapping("adoptCandidate")
    public void adoptCandidate(@RequestBody AdoptCandidate adoptCandidate) {
        candidateApplicationPort.adoptCandidate(adoptCandidate);
    }

    @PostMapping("rejectCandidate")
    public void rejectCandidate(@RequestBody RejectCandidate rejectCandidate) {
        candidateApplicationPort.rejectCandidate(rejectCandidate);
    }
}