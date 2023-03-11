package cenglisch.hiring.startup;

import cenglisch.hiring.application.candidate.CandidateApplicationPort;
import cenglisch.hiring.application.interview.state.InterviewStateApplicationPort;
import cenglisch.hiring.application.interview.type.InterviewTypeApplicationPort;
import cenglisch.hiring.application.job.JobApplicationPort;
import cenglisch.hiring.application.person.PersonApplicationPort;
import cenglisch.hiring.domain.model.candidate.CandidateService;
import cenglisch.hiring.domain.model.interview.InterviewService;
import cenglisch.hiring.domain.model.job.JobService;
import cenglisch.hiring.domain.model.person.PersonService;
import cenglisch.hiring.port.adapter.secondary.persistence.candidate.CandidateRepositoryAdapter;
import cenglisch.hiring.port.adapter.secondary.persistence.interview.InterviewRepositoryAdapter;
import cenglisch.hiring.port.adapter.secondary.persistence.job.JobRepositoryAdapter;
import cenglisch.hiring.port.adapter.secondary.persistence.person.PersonRepositoryAdapter;
import cenglisch.hiring.port.adapter.secondary.messaging.JmsEventPublisherAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private PersonRepositoryAdapter personRepositoryAdapter;

    @Autowired
    private JmsEventPublisherAdapter eventHandler;

    @Bean
    PersonService personService() {
        return new PersonService(personRepositoryAdapter, eventHandler);
    }

    @Bean
    PersonApplicationPort personApplicationPort() {
        return new PersonApplicationPort(personService());
    }


    @Autowired
    private CandidateRepositoryAdapter candidateRepositoryAdapter;

    @Bean
    CandidateApplicationPort candidateApplicationPort() {
        return new CandidateApplicationPort(candidateService(), interviewService(), jobService());
    }

    @Bean
    CandidateService candidateService() {
        return new CandidateService(candidateRepositoryAdapter, eventHandler);
    }


    @Autowired
    private InterviewRepositoryAdapter interviewRepositoryAdapter;

    @Bean
    InterviewTypeApplicationPort interviewTypeApplicationPort() {
        return new InterviewTypeApplicationPort(interviewService());
    }

    @Bean
    InterviewStateApplicationPort interviewStateApplicationPort() {
        return new InterviewStateApplicationPort(
                interviewService(),
                candidateService(),
                personService(),
                eventHandler
        );
    }

    @Bean
    InterviewService interviewService() {
        return new InterviewService(interviewRepositoryAdapter, eventHandler);
    }

    @Autowired
    private JobRepositoryAdapter jobRepositoryAdapter;

    @Bean
    JobService jobService() {
        return new JobService(jobRepositoryAdapter, eventHandler);
    }

    @Bean
    JobApplicationPort jobApplicationPort() {
        return new JobApplicationPort(jobService(), candidateRepositoryAdapter, eventHandler);
    }
}