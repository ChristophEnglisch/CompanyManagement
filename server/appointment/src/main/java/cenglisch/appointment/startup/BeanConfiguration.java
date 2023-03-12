package cenglisch.appointment.startup;

import cenglisch.appointment.application.appointment.AppointmentCommandApplicationPort;
import cenglisch.appointment.application.appointment.interview.AppointmentCommandInterviewApplicationPort;
import cenglisch.appointment.application.participant.ParticipantCommandApplicationPort;
import cenglisch.appointment.domain.model.appointment.AppointmentService;
import cenglisch.appointment.domain.model.appointment.interview.AppointmentInterviewService;
import cenglisch.appointment.domain.model.commitment.CommitmentService;
import cenglisch.appointment.domain.model.participant.ParticipantService;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.AppointmentRepositoryAdapter;
import cenglisch.appointment.port.adapter.secondary.persistence.appointment.interview.AppointmentInterviewRepositoryAdapter;
import cenglisch.appointment.port.adapter.secondary.persistence.commitment.CommitmentRepositoryAdapter;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantRepositoryAdapter;
import cenglisch.appointment.port.adapter.secondary.messaging.JmsEventPublisherAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private JmsEventPublisherAdapter jmsEventPublisherAdapter;

    @Autowired
    private AppointmentRepositoryAdapter appointmentRepositoryAdapter;

    @Bean
    public AppointmentService appointmentService(){
        return new AppointmentService(appointmentRepositoryAdapter, jmsEventPublisherAdapter);
    }

    @Bean
    public AppointmentCommandApplicationPort appointmentApplicationPort(){
        return new AppointmentCommandApplicationPort(appointmentService(), commitmentService(), jmsEventPublisherAdapter);
    }

    @Autowired
    private ParticipantRepositoryAdapter participantRepositoryAdapter;

    @Bean
    public ParticipantService participantService(){
        return new ParticipantService(participantRepositoryAdapter, jmsEventPublisherAdapter);
    }

    @Bean
    public ParticipantCommandApplicationPort participantApplicationPort(){
        return new ParticipantCommandApplicationPort(participantService());
    }

    @Autowired
    private CommitmentRepositoryAdapter commitmentRepositoryAdapter;

    @Bean
    public CommitmentService commitmentService(){
        return new CommitmentService(commitmentRepositoryAdapter, jmsEventPublisherAdapter);
    }

    @Autowired
    private AppointmentInterviewRepositoryAdapter appointmentInterviewRepositoryAdapter;

    @Bean
    public AppointmentInterviewService appointmentInterviewService(){
        return new AppointmentInterviewService(appointmentInterviewRepositoryAdapter, jmsEventPublisherAdapter);
    }

    @Bean
    public AppointmentCommandInterviewApplicationPort appointmentInterviewApplicationPort(){
        return new AppointmentCommandInterviewApplicationPort(participantService(), appointmentInterviewService(), appointmentService(), jmsEventPublisherAdapter);
    }
}
