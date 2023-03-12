package cenglisch.hiring.startup;

import cenglisch.hiring.application.candidate.CandidateCommandApplicationPort;
import cenglisch.hiring.application.interview.state.InterviewStateCommandApplicationPort;
import cenglisch.hiring.application.interview.type.InterviewTypeCommandApplicationPort;
import cenglisch.hiring.application.job.JobCommandApplicationPort;
import cenglisch.hiring.application.person.PersonCommandApplicationPort;
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
    PersonCommandApplicationPort personApplicationPort() {
        return new PersonCommandApplicationPort(personService());
    }


    @Autowired
    private CandidateRepositoryAdapter candidateRepositoryAdapter;

    @Bean
    CandidateCommandApplicationPort candidateApplicationPort() {
        return new CandidateCommandApplicationPort(candidateService(), interviewService(), jobService());
    }

    @Bean
    CandidateService candidateService() {
        return new CandidateService(candidateRepositoryAdapter, eventHandler);
    }


    @Autowired
    private InterviewRepositoryAdapter interviewRepositoryAdapter;

    @Bean
    InterviewTypeCommandApplicationPort interviewTypeApplicationPort() {
        return new InterviewTypeCommandApplicationPort(interviewService());
    }

    @Bean
    InterviewStateCommandApplicationPort interviewStateApplicationPort() {
        return new InterviewStateCommandApplicationPort(
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
    JobCommandApplicationPort jobApplicationPort() {
        return new JobCommandApplicationPort(jobService(), candidateRepositoryAdapter, eventHandler);
    }
}