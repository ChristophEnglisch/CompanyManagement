package com.cenglisch.appointment.startup;

import com.cenglisch.appointment.application.appointment.AppointmentApplicationPort;
import com.cenglisch.appointment.application.appointment.interview.AppointmentInterviewApplicationPort;
import com.cenglisch.appointment.application.participant.ParticipantApplicationPort;
import com.cenglisch.appointment.domain.appointment.AppointmentService;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewService;
import com.cenglisch.appointment.domain.commitment.CommitmentService;
import com.cenglisch.appointment.domain.participant.ParticipantService;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.AppointmentRepositoryAdapter;
import com.cenglisch.appointment.port.adapter.secondary.database.appointment.interview.AppointmentInterviewRepositoryAdapter;
import com.cenglisch.appointment.port.adapter.secondary.database.commitment.CommitmentRepositoryAdapter;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantRepositoryAdapter;
import com.cenglisch.appointment.port.adapter.secondary.messaging.JmsEventPublisherAdapter;
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
    public AppointmentApplicationPort appointmentApplicationPort(){
        return new AppointmentApplicationPort(appointmentService(), commitmentService(), jmsEventPublisherAdapter);
    }

    @Autowired
    private ParticipantRepositoryAdapter participantRepositoryAdapter;

    @Bean
    public ParticipantService participantService(){
        return new ParticipantService(participantRepositoryAdapter, jmsEventPublisherAdapter);
    }

    @Bean
    public ParticipantApplicationPort participantApplicationPort(){
        return new ParticipantApplicationPort(participantService());
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
    public AppointmentInterviewApplicationPort appointmentInterviewApplicationPort(){
        return new AppointmentInterviewApplicationPort(participantService(), appointmentInterviewService(), appointmentService(), jmsEventPublisherAdapter);
    }
}
