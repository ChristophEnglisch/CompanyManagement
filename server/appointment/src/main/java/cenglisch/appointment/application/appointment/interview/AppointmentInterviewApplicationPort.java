package cenglisch.appointment.application.appointment.interview;

import cenglisch.appointment.domain.appointment.AppointmentService;
import cenglisch.appointment.domain.appointment.AppointmentState;
import cenglisch.appointment.domain.appointment.event.AppointmentAccepted;
import cenglisch.appointment.domain.appointment.event.AppointmentFinished;
import cenglisch.appointment.domain.appointment.event.AppointmentLaunched;
import cenglisch.appointment.domain.appointment.interview.AppointmentInterviewService;
import cenglisch.appointment.domain.participant.ParticipantService;
import cenglisch.domain.model.EventHandler;

public class AppointmentInterviewApplicationPort {

    private final ParticipantService participantService;

    private final AppointmentInterviewService appointmentInterviewService;

    private final AppointmentService appointmentService;

    public AppointmentInterviewApplicationPort(ParticipantService participantService, AppointmentInterviewService appointmentInterviewService, AppointmentService appointmentService, EventHandler eventHandler) {
        this.participantService = participantService;
        this.appointmentInterviewService = appointmentInterviewService;
        this.appointmentService = appointmentService;

        eventHandler.subscribe(AppointmentAccepted.class, this::acceptAppointmentInterview);
        eventHandler.subscribe(AppointmentLaunched.class, this::launchAppointmentInterview);
        eventHandler.subscribe(AppointmentFinished.class, this::finishAppointmentInterview);
    }

    public void generateAppointmentInterview(GenerateInterviewAppointment generateInterviewAppointment) {
        appointmentInterviewService.generateAppointmentInterview(
                generateInterviewAppointment.interviewId(),
                appointmentService.initializeAppointment(
                        participantService.newParticipant(
                                generateInterviewAppointment.candidateFullName(),
                                generateInterviewAppointment.candidateEmail()
                        )
                )
        );
    }

    private void acceptAppointmentInterview(AppointmentAccepted appointmentAccepted) {
        appointmentInterviewService.publishEventChange(
                appointmentAccepted.appointmentId(),
                AppointmentState.ACCEPTED
        );
    }

    private void launchAppointmentInterview(AppointmentLaunched appointmentLaunched) {
        appointmentInterviewService.publishEventChange(
                appointmentLaunched.appointmentId(),
                AppointmentState.LAUNCHED
        );
    }

    private void finishAppointmentInterview(AppointmentFinished appointmentFinished) {
        appointmentInterviewService.publishEventChange(
                appointmentFinished.appointmentId(),
                AppointmentState.FINISHED
        );
    }
}