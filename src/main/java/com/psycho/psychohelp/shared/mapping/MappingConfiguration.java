package com.psycho.psychohelp.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * <p>Enhance model mapper configuration class.</p>
 *
 */
@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }
}

