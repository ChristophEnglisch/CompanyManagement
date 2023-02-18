package com.cenglisch.appointment.port.adapter.primary.appointment;

import com.cenglisch.appointment.application.appointment.AddParticipant;
import com.cenglisch.appointment.application.appointment.AppointmentApplicationPort;
import com.cenglisch.appointment.application.appointment.AppointmentRegistration;
import com.cenglisch.appointment.application.appointment.RescheduleAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/appointment")
public class AppointmentPresentationRestAdapter {
    @Autowired
    private AppointmentApplicationPort appointmentApplicationPort;

    @PostMapping("appointmentRegistration")
    public void appointmentRegistration(@RequestBody AppointmentRegistration appointmentRegistration) {
        appointmentApplicationPort.appointmentRegistration(appointmentRegistration);
    }

    @PostMapping("rescheduleAppointment")
    public void rescheduleAppointment(@RequestBody RescheduleAppointment rescheduleAppointment){
        appointmentApplicationPort.rescheduleAppointment(rescheduleAppointment);
    }

    @PostMapping("addParticipant")
    public void addParticipant(@RequestBody AddParticipant addParticipant){
        appointmentApplicationPort.addParticipant(addParticipant);
    }
}
