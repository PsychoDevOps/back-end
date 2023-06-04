package com.psycho.psychohelp.appointment.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Create appointment resource class for appointment.</p>
 *
 */
@Getter
@Setter
public class CreateAppointmentResource {
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String meetUrl;
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String motive;
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String personalHistory;
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String testRealized;
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String treatment;
  @NotNull
  @NotBlank
  @Size(max = 100)
  private String scheduleDate;
}
