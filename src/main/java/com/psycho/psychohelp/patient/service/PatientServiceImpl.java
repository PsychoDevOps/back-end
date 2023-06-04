package com.psycho.psychohelp.patient.service;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.patient.domain.persistence.PatientRepository;
import com.psycho.psychohelp.patient.domain.service.PatientService;
import com.psycho.psychohelp.shared.exception.ResourceNotFoundException;
import java.util.List;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * <p>Service implementation class for patient.</p>
 *
 */
@Service
public class PatientServiceImpl implements PatientService {

  private static final String ENTITY = "Patient";

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private Validator validator;

  @Override
  public List<Patient> getAll() {
    return patientRepository.findAll();
  }

  @Override
  public Page<Patient> getAll(Pageable pageable) {
    return patientRepository.findAll(pageable);
  }

  @Override
  public Patient getById(Long patientId) {
    return patientRepository.findById(patientId)
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
  }

  @Override
  public Patient create(Patient request) {
    return patientRepository.save(request);
  }

  @Override
  public Patient update(Long patientId, Patient request) {

    return patientRepository.findById(patientId).map(patient ->
                    patientRepository.save(
                            patient.withFirstName(request.getFirstName())
                                    .withLastName(request.getLastName())
                                    .withEmail(request.getEmail())
                                    .withDate(request.getDate())
                                    .withPhone(request.getPhone())
                                    .withGender(request.getGender())
                                    .withImg(request.getImg())))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
  }

  @Override
  public Patient getByEmail(String email) {
    return patientRepository.findByEmail(email);
  }

  @Override
  public ResponseEntity<?> delete(Long patientId) {
    return patientRepository.findById(patientId).map(patient -> {
      patientRepository.delete(patient);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
  }
}
