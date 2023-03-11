package cenglisch.appointment.port.adapter.secondary.persistence.appointment;

import cenglisch.appointment.domain.model.appointment.Appointment;
import cenglisch.appointment.domain.model.appointment.AppointmentId;
import cenglisch.appointment.domain.model.appointment.AppointmentRepository;
import cenglisch.appointment.port.adapter.secondary.persistence.participant.ParticipantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentRepositoryAdapter implements AppointmentRepository {

    @Autowired
    private AppointmentJpaRepository appointmentJpaRepository;

    @Autowired
    private ParticipantJpaRepository participantRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Optional<Appointment> find(AppointmentId appointmentId) {
        Optional<AppointmentEntity> optionalAppointment = appointmentJpaRepository.findById(appointmentId.getId());
        return optionalAppointment.map(appointmentEntity -> appointmentMapper.mapToAppointment(appointmentEntity));
    }

    @Override
    public Appointment save(Appointment appointment) {
        if(appointment.getAppointmentId() == null){
            appointment.setAppointmentId(new AppointmentId(generateId()));
        }
        AppointmentEntity appointmentEntity = appointmentMapper.mapToAppointmentEntity(appointment, participantRepository, appointmentJpaRepository);
        return appointmentMapper.mapToAppointment(appointmentJpaRepository.save(appointmentEntity));
    }

    @Override
    public void remove(Appointment appointment) {

    }
}
