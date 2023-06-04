package com.psycho.psychohelp.patient.domain.service;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * <p>Service interface for patient.</p>
 *
 */
public interface PatientService {
  List<Patient> getAll();

  Page<Patient> getAll(Pageable pageable);

  Patient getById(Long patientId);

  Patient create(Patient request);

  Patient update(Long patientId, Patient request);

  Patient getByEmail(String email);

  ResponseEntity<?> delete(Long logbookId);
}
