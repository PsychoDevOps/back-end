package com.psycho.psychohelp.psychologist.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * <p>Mapping configuration class for psychologist.</p>
 *
 */
@Configuration("psychologistMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public PsychologistMapper psychologistMapper() {
    return new PsychologistMapper();
  }

  @Bean
  public ScheduleMapper scheduleMapper() {
    return new ScheduleMapper();
  }
}
