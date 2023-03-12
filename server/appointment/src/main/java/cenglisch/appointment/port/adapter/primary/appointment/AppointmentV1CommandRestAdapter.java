package cenglisch.appointment.port.adapter.primary.appointment;

import cenglisch.appointment.application.appointment.AddParticipant;
import cenglisch.appointment.application.appointment.AppointmentCommandApplicationPort;
import cenglisch.appointment.application.appointment.AppointmentRegistration;
import cenglisch.appointment.application.appointment.RescheduleAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/appointment")
public class AppointmentV1CommandRestAdapter {
    @Autowired
    private AppointmentCommandApplicationPort appointmentCommandApplicationPort;

    @PostMapping("appointmentRegistration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void appointmentRegistration(@RequestBody AppointmentRegistration appointmentRegistration) {
        appointmentCommandApplicationPort.appointmentRegistration(appointmentRegistration);
    }

    @PostMapping("rescheduleAppointment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rescheduleAppointment(@RequestBody RescheduleAppointment rescheduleAppointment){
        appointmentCommandApplicationPort.rescheduleAppointment(rescheduleAppointment);
    }

    @PostMapping("addParticipant")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addParticipant(@RequestBody AddParticipant addParticipant){
        appointmentCommandApplicationPort.addParticipant(addParticipant);
    }
}
