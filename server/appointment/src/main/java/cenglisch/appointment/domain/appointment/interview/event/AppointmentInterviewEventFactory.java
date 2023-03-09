package cenglisch.appointment.domain.appointment.interview.event;

import cenglisch.appointment.domain.appointment.AppointmentState;
import cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;

public class AppointmentInterviewEventFactory {
    public static AppointmentInterviewEvent make(AppointmentState appointmentState, AppointmentInterviewId appointmentInterviewId) {
        return switch (appointmentState){
            case ACCEPTED -> new AppointmentInterviewAccepted(appointmentInterviewId);
            case LAUNCHED -> new AppointmentInterviewLaunched(appointmentInterviewId);
            case FINISHED -> new AppointmentInterviewFinished(appointmentInterviewId);
            default -> throw new IllegalStateException("Unexpected value: " + appointmentState);
        };
    }
}
