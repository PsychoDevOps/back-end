package com.psycho.psychohelp.publication.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * <p>Mapping configuration class for publication.</p>
 *
 */
@Configuration("publicationMappingConfiguration")
public class MappingConfiguration {

  @Bean
  public PublicationMapper publicationMapper() {
    return new PublicationMapper();
  }


}
