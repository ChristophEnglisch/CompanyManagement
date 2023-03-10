package cenglisch.appointment.domain.model.appointment.interview;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.appointment.AppointmentState;
import cenglisch.appointment.domain.model.appointment.interview.event.AppointmentInterviewEventFactory;
import cenglisch.appointment.domain.model.appointment.interview.event.AppointmentInterviewGenerated;
import cenglisch.domain.model.EventHandler;
import org.jmolecules.ddd.annotation.Service;

@Service
public class AppointmentInterviewService {

    private final AppointmentInterviewRepository appointmentInterviewRepository;

    private final EventHandler eventHandler;

    public AppointmentInterviewService(AppointmentInterviewRepository appointmentInterviewRepository, EventHandler eventHandler) {
        this.appointmentInterviewRepository = appointmentInterviewRepository;
        this.eventHandler = eventHandler;
    }

    public void generateAppointmentInterview(AppointmentInterviewId appointmentInterviewId, AppointmentId appointmentId) {
        appointmentInterviewRepository.save(new AppointmentInterview(appointmentInterviewId, appointmentId));
        eventHandler.publish(new AppointmentInterviewGenerated(appointmentInterviewId, appointmentId));
    }

    public void publishEventChange(AppointmentId appointmentId, AppointmentState appointmentState){
        AppointmentInterview appointmentInterview = appointmentInterviewRepository.findByAppointmentId(appointmentId)
                                                                                  .orElseThrow(AppointmentInterviewNotFoundException::new);
        eventHandler.publish(
                AppointmentInterviewEventFactory.make(
                        appointmentState,
                        appointmentInterview.getAppointmentInterviewId()
                )
        );
    }
}
