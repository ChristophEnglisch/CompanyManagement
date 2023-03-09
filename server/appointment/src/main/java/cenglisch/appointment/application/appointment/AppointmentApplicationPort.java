package cenglisch.appointment.application.appointment;

import cenglisch.appointment.domain.EventHandler;
import cenglisch.appointment.domain.appointment.Appointment;
import cenglisch.appointment.domain.appointment.exception.AppointmentNotFoundException;
import cenglisch.appointment.domain.appointment.AppointmentService;
import cenglisch.appointment.domain.commitment.CommitmentService;
import cenglisch.appointment.domain.commitment.event.ConfirmedCommitment;

public class AppointmentApplicationPort {
    private final AppointmentService appointmentService;

    private final CommitmentService commitmentService;

    public AppointmentApplicationPort(AppointmentService appointmentService, CommitmentService commitmentService, EventHandler eventHandler) {
        this.appointmentService = appointmentService;
        this.commitmentService = commitmentService;

        eventHandler.subscribe(ConfirmedCommitment.class, confirmedCommitment -> {
            acceptAppointment(new AcceptAppointment(confirmedCommitment.appointmentId()));
        });
    }

    public void appointmentRegistration(AppointmentRegistration appointmentRegistration) {
        appointmentService.appointmentRegistration(
                appointmentRegistration.appointmentId(),
                appointmentRegistration.schedulingParticipant(),
                appointmentRegistration.appointmentDate(),
                appointmentRegistration.appointmentType(),
                appointmentRegistration.appointmentInformation()
        );
    }

    public void rescheduleAppointment(RescheduleAppointment rescheduleAppointment){
        //das appointment date muss noch erstellt werden, es existsiert bis jetzt noch nicht in der db
        //entweder wird von hier aus direkt der service angestoßen oder man lauscht auf das event, dass ein neues date erstellt wurde
        appointmentService.rescheduleAppointment(
                rescheduleAppointment.appointmentId(),
                rescheduleAppointment.appointmentDate()
        );
    }

    public void acceptAppointment(AcceptAppointment acceptAppointment) {
        Appointment appointment = appointmentService.find(acceptAppointment.appointmentId()).orElseThrow(AppointmentNotFoundException::new);
        if(!commitmentService.allParticipantAcceptedCommitment(acceptAppointment.appointmentId(), appointment.getParticipants().size())){
            return;
        }
        appointmentService.acceptAppointment(acceptAppointment.appointmentId());
    }

    public void launchAppointment(LaunchAppointment launchAppointment) {
        appointmentService.launchAppointment(
                launchAppointment.appointmentId()
        );
    }

    public void finishAppointment(FinishAppointment finishAppointment) {
        appointmentService.finishAppointment(
                finishAppointment.appointmentId()
        );
    }

    public void addParticipant(AddParticipant addParticipant) {
        appointmentService.addParticipant(
                addParticipant.appointmentId(),
                addParticipant.participantId()
        );
    }
}
