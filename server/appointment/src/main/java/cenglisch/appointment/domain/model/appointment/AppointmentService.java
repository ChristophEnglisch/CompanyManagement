package cenglisch.appointment.domain.model.appointment;

import cenglisch.appointment.domain.model.appointment.date.AppointmentDate;
import cenglisch.appointment.domain.model.appointment.exception.AppointmentNotFoundException;
import cenglisch.appointment.domain.model.appointment.event.*;
import cenglisch.appointment.domain.model.participant.ParticipantId;
import cenglisch.appointment.domain.appointment.event.*;
import cenglisch.domain.model.EventHandler;
import org.jmolecules.ddd.annotation.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final EventHandler eventHandler;

    public AppointmentService(AppointmentRepository appointmentRepository, EventHandler eventHandler) {
        this.appointmentRepository = appointmentRepository;
        this.eventHandler = eventHandler;
    }

    public Optional<Appointment> find(AppointmentId appointmentId) {
        return appointmentRepository.find(appointmentId);
    }

    public AppointmentId initializeAppointment(ParticipantId participantId) {
        Appointment appointment = appointmentRepository.save(new Appointment(participantId));
        return appointment.getAppointmentId();
    }

    public void appointmentRegistration(
            AppointmentId appointmentId,
            ParticipantId schedulingParticipant,
            AppointmentDate appointmentDate,
            AppointmentType appointmentType,
            AppointmentInformation appointmentInformation
    ) {
        Appointment appointment = new Appointment(
                schedulingParticipant,
                appointmentDate,
                appointmentType,
                appointmentInformation
        );
        if(appointmentId != null){
            appointment.setAppointmentId(appointmentId);
        }
        appointmentRepository.save(appointment);
        eventHandler.publish(new AppointmentCreated(appointment.getAppointmentId()));
    }

    public void rescheduleAppointment(AppointmentId appointmentId, AppointmentDate appointmentDate) {
        manageAppointment(
                appointmentId,
                appointment -> appointment.rescheduleAppointment(appointmentDate),
                new AppointmentRescheduled(appointmentId)
        );
    }

    public void cancelAppointment(AppointmentId appointmentId) {
        manageAppointment(
                appointmentId,
                Appointment::cancelAppointment,
                new AppointmentCanceled(appointmentId)
        );
    }
    public void acceptAppointment(AppointmentId appointmentId){
        manageAppointment(
                appointmentId,
                Appointment::acceptAppointment,
                new AppointmentAccepted(appointmentId)
        );
    }

    public void launchAppointment(AppointmentId appointmentId) {
        manageAppointment(
                appointmentId,
                Appointment::launchAppointment,
                new AppointmentLaunched(appointmentId)
        );
    }

    public void finishAppointment(AppointmentId appointmentId) {
        manageAppointment(
                appointmentId,
                Appointment::finishAppointment,
                new AppointmentFinished(appointmentId)
        );
    }

    public void addParticipant(AppointmentId appointmentId, ParticipantId participantId) {
        manageAppointment(
                appointmentId,
                appointment -> appointment.addParticipant(participantId),
                new ParticipantAddedToAppointment(appointmentId, participantId)
        );
    }

    private void manageAppointment(AppointmentId appointmentId, Consumer<Appointment> appointmentConsumer, AppointmentEvent appointmentEvent) {
        Appointment appointment = find(appointmentId).orElseThrow(AppointmentNotFoundException::new);
        appointmentConsumer.accept(appointment);
        appointmentRepository.save(appointment);
        eventHandler.publish(appointmentEvent);
    }
}