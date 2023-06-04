package com.psycho.psychohelp.psychologist.domain.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * <p>Model class for psychologist schedule.</p>
 *
 */
@Entity
@Table(name = "psychologist_schedule")
@NoArgsConstructor
@AllArgsConstructor
public class PsychologistSchedule {

  @EmbeddedId
  private PsychologistScheduleFk psychologistScheduleFk;

  @ManyToOne
  @MapsId("psychologistId")
  private Psychologist psychologist;

  @ManyToOne
  @MapsId("scheduleId")
  private Schedule schedule;
}
