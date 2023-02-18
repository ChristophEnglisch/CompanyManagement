package com.cenglisch.appointment.port.adapter.primary.appointment.interview;


import com.cenglisch.appointment.application.appointment.interview.AppointmentInterviewApplicationPort;
import com.cenglisch.appointment.application.appointment.interview.GenerateInterviewAppointment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentInterviewQueueListener {

    @Autowired
    private AppointmentInterviewApplicationPort appointmentInterviewApplicationPort;

    @RabbitListener(queues = "hiring.interview.state.generated")
    public void generateAppointmentInterview(GenerateInterviewAppointment generateInterviewAppointment){
        appointmentInterviewApplicationPort.generateAppointmentInterview(generateInterviewAppointment);
    }

    /*
    @RabbitListener(queues = "hiring.interview.appointment.participant")
    public void addParticipant(ParticipantInformations participantInformations){
        appointmentInterviewApplicationPort.addParticipants(participantInformations);
    }
    */
}
