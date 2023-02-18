package com.cenglisch.appointment.port.adapter.secondary.database.appointment.interview;

import com.cenglisch.appointment.domain.appointment.AppointmentId;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterview;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewId;
import com.cenglisch.appointment.domain.appointment.interview.AppointmentInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentInterviewRepositoryAdapter implements AppointmentInterviewRepository {

    @Autowired
    private AppointmentInterviewJpaRepository appointmentInterviewJpaRepository;

    @Autowired
    private AppointmentInterviewMapper appointmentInterviewMapper;

    @Override
    public Optional<AppointmentInterview> findById(AppointmentInterviewId appointmentInterviewId) {
        Optional<AppointmentInterviewEntity> optionalAppointment = appointmentInterviewJpaRepository.findById(appointmentInterviewId.getId());
        return optionalAppointment.map(appointmentEntity -> appointmentInterviewMapper.toAppointmentInterview(appointmentEntity));
    }

    @Override
    public Optional<AppointmentInterview> findByAppointmentId(AppointmentId appointmentId) {
        Optional<AppointmentInterviewEntity> optionalAppointment = appointmentInterviewJpaRepository.findByAppointmentId(appointmentId.getId());
        return optionalAppointment.map(appointmentEntity -> appointmentInterviewMapper.toAppointmentInterview(appointmentEntity));
    }

    @Override
    public AppointmentInterview save(AppointmentInterview appointmentInterview) {
        AppointmentInterviewEntity appointmentInterviewEntity = appointmentInterviewJpaRepository.save(appointmentInterviewMapper.toAppointmentInterviewEntity(appointmentInterview));
        return appointmentInterviewMapper.toAppointmentInterview(appointmentInterviewEntity);
    }
}