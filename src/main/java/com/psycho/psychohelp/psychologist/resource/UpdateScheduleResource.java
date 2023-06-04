package com.psycho.psychohelp.psychologist.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Update resource class for schedule.</p>
 *
 */
@Getter
@Setter
public class UpdateScheduleResource {

  private Long id;

  @NotNull
  @NotBlank
  private String time;
}
