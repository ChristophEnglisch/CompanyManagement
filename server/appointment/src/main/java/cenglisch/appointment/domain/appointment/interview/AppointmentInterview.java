package cenglisch.appointment.domain.appointment.interview;

import cenglisch.appointment.domain.appointment.AppointmentId;
import cenglisch.Default;
import org.jmolecules.ddd.annotation.Entity;

@Entity
/** is a class for notation of foreign system id */
public class AppointmentInterview {
    private final AppointmentInterviewId appointmentInterviewId;

    private final AppointmentId appointmentId;

    @Default
    public AppointmentInterview(AppointmentInterviewId appointmentInterviewId, AppointmentId appointmentId) {
        this.appointmentInterviewId = appointmentInterviewId;
        this.appointmentId = appointmentId;
    }

    public AppointmentInterviewId getAppointmentInterviewId() {
        return appointmentInterviewId;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }
}
