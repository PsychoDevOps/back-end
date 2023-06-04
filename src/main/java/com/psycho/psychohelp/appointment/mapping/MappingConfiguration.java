package com.psycho.psychohelp.appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * <p>Mapping configuration class for appointment.</p>
 *
 */
@Configuration("appointmentMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public AppointmentMapper appointmentMapper() {
    return new AppointmentMapper();
  }
}
