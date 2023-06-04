package com.psycho.psychohelp.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * <p>Mapping configuration class for patient.</p>
 *
 */
@Configuration("patientMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public PatientMapper patientMapper() {
    return new PatientMapper();
  }

}
