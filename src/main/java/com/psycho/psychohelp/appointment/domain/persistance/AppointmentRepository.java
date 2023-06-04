package com.psycho.psychohelp.appointment.domain.persistance;

import com.psycho.psychohelp.appointment.domain.model.entity.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * <p>Repository interface for appointment.</p>
 *
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  List<Appointment> findByPsychologistId(Long psychologistId);

  List<Appointment> findByPatientId(Long patientId);

  List<Appointment> findByPatientIdAndPsychologistId(Long patientId, Long psychologistId);
}
