package com.psycho.psychohelp.patient.mapping;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.patient.resource.CreatePatientResource;
import com.psycho.psychohelp.patient.resource.PatientResource;
import com.psycho.psychohelp.patient.resource.UpdatePatientResource;
import com.psycho.psychohelp.shared.mapping.EnhancedModelMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * <p>Mapper class for patient.</p>
 *
 */
public class PatientMapper {

  @Autowired
  private EnhancedModelMapper mapper;

  /**
   *
   * <p>Method to convert a model list to page.</p>
   *
   */
  public Page<PatientResource> modelListToPage(List<Patient> modelList, Pageable pageable) {
    return new PageImpl<>(
            mapper.mapList(modelList, PatientResource.class),
            pageable,
            modelList.size());
  }

  public PatientResource toResource(Patient model) {
    return mapper.map(model, PatientResource.class);
  }

  public List<PatientResource> toResource(List<Patient> model) {
    return mapper.mapList(model, PatientResource.class);
  }

  public Patient toModel(CreatePatientResource resource) {
    return mapper.map(resource, Patient.class);
  }

  public Patient toModel(PatientResource resource) {
    return mapper.map(resource, Patient.class);
  }

  public Patient toModel(UpdatePatientResource resource) {
    return mapper.map(resource, Patient.class);
  }
}
