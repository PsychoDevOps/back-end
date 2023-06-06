package com.psycho.psychohelp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * <p>Psychohelp api application class.</p>
 *
 */
@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class PsychohelpApiApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(PsychohelpApiApplication.class, args);
  }

  /**
   *
   * <p>Cors configuration method.</p>
   *
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("https://psychohelp-488a9.web.app").allowedMethods("*").allowedHeaders("*");
      }
    };
  }

}
