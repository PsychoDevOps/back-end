package com.psycho.psychohelp.patient.resource;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchPanicResource {
  @NotNull
  private Boolean panic;
}
