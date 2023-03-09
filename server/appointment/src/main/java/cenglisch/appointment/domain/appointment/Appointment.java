package cenglisch.appointment.domain.appointment;

import cenglisch.appointment.domain.appointment.date.AppointmentDate;
import cenglisch.appointment.domain.appointment.exception.AppointmentException;
import cenglisch.appointment.domain.participant.ParticipantId;
import cenglisch.Default;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.ArrayList;
import java.util.Collection;

@AggregateRoot
public class Appointment {
    @Identity
    private AppointmentId appointmentId;
    private ParticipantId schedulingParticipant;
    private Collection<ParticipantId> participants;
    private AppointmentDate appointmentDate;
    private AppointmentType appointmentType;
    private AppointmentState appointmentState;
    private AppointmentInformation appointmentInformation;

    @Default
    public Appointment(
            AppointmentId appointmentId,
            ParticipantId schedulingParticipant,
            Collection<ParticipantId> participants,
            AppointmentDate appointmentDate,
            AppointmentType appointmentType,
            AppointmentState appointmentState,
            AppointmentInformation appointmentInformation
    ) {
        this.appointmentId = appointmentId;
        this.schedulingParticipant = schedulingParticipant;
        this.participants = participants;
        this.appointmentDate = appointmentDate;
        this.appointmentType = appointmentType;
        this.appointmentState = appointmentState;
        this.appointmentInformation = appointmentInformation;
    }

    public Appointment(
            final ParticipantId participant,
            final AppointmentDate appointmentDate,
            final AppointmentType appointmentType,
            final AppointmentInformation appointmentInformation
    ) {
        this();
        setSchedulingParticipant(participant);
        setAppointmentDate(appointmentDate);
        setAppointmentType(appointmentType);
        setAppointmentState(AppointmentState.PENDING);
        setAppointmentInformation(appointmentInformation);
    }

    /**
     * this constructor gets called by interview message bus
     */
    public Appointment(ParticipantId participantId){
        setAppointmentState(AppointmentState.PENDING);
        setAppointmentType(AppointmentType.COMPULSORY_ATTENDANCE);
        setSchedulingParticipant(participantId);
    }

    public Appointment() {
        participants = new ArrayList<>();
    }

    public void rescheduleAppointment(AppointmentDate pAppointmentDate) {
        if (isLaunched() || isFinished()){
            throw new AppointmentException("invalid state change for appointment");
        }
        if (pAppointmentDate.equals(appointmentDate)) {
            return;
        }
        setAppointmentDate(appointmentDate);
    }

    public void acceptAppointment(){
        if (!isPending()) {
            throw new AppointmentException("invalid state change for appointment");
        }
        setAppointmentState(AppointmentState.ACCEPTED);
    }

    public void cancelAppointment() {
        if (!isPending()) {
            throw new AppointmentException("invalid state change for appointment");
        }
        setAppointmentState(AppointmentState.CANCELED);
    }

    public void launchAppointment() {
        if (!isPending()) {
            throw new AppointmentException("invalid state change for appointment");
        }
        setAppointmentState(AppointmentState.LAUNCHED);
    }

    public void finishAppointment() {
        if (!isLaunched()) {
            throw new AppointmentException("invalid state change for appointment");
        }
        setAppointmentState(AppointmentState.FINISHED);
    }

    public void addParticipant(ParticipantId participantId) {
        if (!isPending()) {
            throw new AppointmentException("appointment is not in a valid state for adding more participants");
        }
        if (participants.contains(participantId)) {
            throw new AppointmentException("participant already added to appointment");
        }
        participants.add(participantId);
    }


    public boolean isCompulsoryAttendanceRequired() {
        return appointmentType == AppointmentType.COMPULSORY_ATTENDANCE;
    }

    public boolean isPending() {
        return appointmentState == AppointmentState.PENDING;
    }

    public boolean isConflict() {
        return appointmentState == AppointmentState.CONFLICT;
    }

    public boolean isCanceled() {
        return appointmentState == AppointmentState.CANCELED;
    }

    public boolean isLaunched() {
        return appointmentState == AppointmentState.LAUNCHED;
    }

    public boolean isFinished() {
        return appointmentState == AppointmentState.FINISHED;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    private void setSchedulingParticipant(ParticipantId schedulingParticipant) {
        this.schedulingParticipant = schedulingParticipant;
    }

    private void setAppointmentDate(AppointmentDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    private void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    private void setAppointmentState(AppointmentState appointmentState) {
        this.appointmentState = appointmentState;
    }

    private void setAppointmentInformation(AppointmentInformation appointmentInformation) {
        this.appointmentInformation = appointmentInformation;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public ParticipantId getSchedulingParticipant() {
        return schedulingParticipant;
    }

    public Collection<ParticipantId> getParticipants() {
        return participants;
    }

    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public AppointmentState getAppointmentState() {
        return appointmentState;
    }

    public AppointmentInformation getAppointmentInformation() {
        return appointmentInformation;
    }
}