package com.cenglisch.appointment.port.adapter.secondary.database.appointment;

import com.cenglisch.appointment.domain.appointment.Appointment;
import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.AppointmentRepository;
import com.cenglisch.appointment.port.adapter.secondary.database.participant.ParticipantJpaRepository;
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
    public Optional<Appointment> findById(AppointmentId appointmentId) {
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
}
