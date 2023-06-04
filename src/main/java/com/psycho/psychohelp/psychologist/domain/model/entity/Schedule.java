package com.psycho.psychohelp.psychologist.domain.model.entity;

import com.psycho.psychohelp.shared.domain.model.AuditModel;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

/**
 *
 * <p>Model class for schedule.</p>
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "schedule")
public class Schedule extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  private String time;

  @OneToMany(mappedBy = "schedule")
  private List<PsychologistSchedule> psychologistSchedules;
}
