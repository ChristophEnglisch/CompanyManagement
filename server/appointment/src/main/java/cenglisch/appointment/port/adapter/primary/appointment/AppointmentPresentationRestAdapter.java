package cenglisch.appointment.port.adapter.primary.appointment;

import cenglisch.appointment.application.appointment.AddParticipant;
import cenglisch.appointment.application.appointment.AppointmentApplicationPort;
import cenglisch.appointment.application.appointment.AppointmentRegistration;
import cenglisch.appointment.application.appointment.RescheduleAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/appointment")
public class AppointmentPresentationRestAdapter {
    @Autowired
    private AppointmentApplicationPort appointmentApplicationPort;

    @PostMapping("appointmentRegistration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void appointmentRegistration(@RequestBody AppointmentRegistration appointmentRegistration) {
        appointmentApplicationPort.appointmentRegistration(appointmentRegistration);
    }

    @PostMapping("rescheduleAppointment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rescheduleAppointment(@RequestBody RescheduleAppointment rescheduleAppointment){
        appointmentApplicationPort.rescheduleAppointment(rescheduleAppointment);
    }

    @PostMapping("addParticipant")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addParticipant(@RequestBody AddParticipant addParticipant){
        appointmentApplicationPort.addParticipant(addParticipant);
    }
}
