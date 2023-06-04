package com.psycho.psychohelp.patient.domain.persistence;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * <p>Repository class for patient.</p>
 *
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
  Patient findByEmail(String email);

  @Query(value = "select * from patients where id in (select patient_id from"
          + " appointments where psychologist_id = ?1)", nativeQuery = true)
  List<Patient> findPatientsByPsychologistId(Long psychologistId);


}
