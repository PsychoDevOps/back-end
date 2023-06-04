package com.psycho.psychohelp.publication.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.shared.domain.model.AuditModel;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

/**
 *
 * <p>Model class for publication.</p>
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "publications")
public class Publication extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 150)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 250)
  private String description;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String tags;

  @NotNull
  @NotBlank
  private String photoUrl;
  @NotNull
  @NotBlank
  @Lob
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "psychologist_id", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Psychologist psychologist;

  /**
   *
   * <p>Method constructor for publication model class.</p>
   *
   */
  public Publication(Long id, String title, String description, String tags,
                     String photoUrl, String content) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.tags = tags;
    this.photoUrl = photoUrl;
    this.content = content;
  }
}
