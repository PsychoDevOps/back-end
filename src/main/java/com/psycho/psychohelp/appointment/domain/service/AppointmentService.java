package com.psycho.psychohelp.appointment.domain.service;

import com.psycho.psychohelp.appointment.domain.model.entity.Appointment;
import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * <p>Service interface for appointment.</p>
 *
 */
public interface AppointmentService {
  List<Appointment> getAll();

  Appointment getById(Long appointmentId);

  Appointment create(Appointment request, Long psychologistId, Long patientId);

  Appointment update(Long appointmentId, Appointment request);

  List<Appointment> getByPsychologistId(Long psychologistId);

  List<Appointment> getByPatientId(Long patientId);

  List<Appointment> getByPatientIdAndPsychologistId(Long patientId, Long psychologistId);

  List<Patient> getPatientsByPsychologistId(Long psychologistId);

  ResponseEntity<?> delete(Long appointmentId);
}
