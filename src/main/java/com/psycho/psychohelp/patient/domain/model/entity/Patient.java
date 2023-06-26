package com.psycho.psychohelp.patient.domain.model.entity;

import com.psycho.psychohelp.shared.domain.model.AuditModel;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

/**
 *
 * <p>Model class for patient.</p>
 *
 */
@Getter
@Setter
@NoArgsConstructor
@With
@Entity
@Table(name = "patients")
public class Patient extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 20)
  private String firstName;

  @NotNull
  @NotBlank
  @Size(max = 20)
  private String lastName;

  @NotNull
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 20) //check
  private String password;

  @NotNull
  @NotBlank
  @Size(max = 9) //check
  private String phone;

  @NotNull
  private String date;

  @NotNull
  @NotBlank
  @Size(max = 20)
  private String gender;

  @NotNull
  @NotBlank
  @Size(max = 200)
  private String img;


  private Boolean panic = false;

  /**
   *
   * <p>Method constructor for patient model class.</p>
   *
   */
  public Patient(Long id, String firstName, String lastName, String email,
                 String password, String phone, String date, String gender, String img
                 , Boolean panic) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.date = date;
    this.gender = gender;
    this.img = img;
    this.panic = panic;
  }
}
