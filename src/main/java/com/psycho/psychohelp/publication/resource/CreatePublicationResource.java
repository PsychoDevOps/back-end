package com.psycho.psychohelp.publication.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Create publication resource class for appointment.</p>
 *
 */
@Getter
@Setter
public class CreatePublicationResource {
  @NotNull
  @NotBlank
  private String photoUrl;

  @NotNull
  @NotBlank
  @Size(max = 150)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String tags;

  @NotNull
  @NotBlank
  @Size(max = 250)
  private String description;

  @NotNull
  @NotBlank
  private String content;
}
