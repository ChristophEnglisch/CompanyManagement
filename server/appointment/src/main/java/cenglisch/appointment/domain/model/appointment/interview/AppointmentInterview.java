package cenglisch.appointment.domain.model.appointment.interview;

import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.Default;

@org.jmolecules.ddd.annotation.Entity
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
