package com.psycho.psychohelp.patient.resource;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Repository class for patient.</p>
 *
 */
@Getter
@Setter
public class PatientResource {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private String date;
  private String gender;
  private String img;
}
