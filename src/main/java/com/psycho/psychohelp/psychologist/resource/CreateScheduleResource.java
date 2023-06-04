package com.psycho.psychohelp.psychologist.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Create schedule resource class for appointment.</p>
 *
 */
@Getter
@Setter
public class CreateScheduleResource {

  @NotNull
  @NotBlank
  private String time;
}
