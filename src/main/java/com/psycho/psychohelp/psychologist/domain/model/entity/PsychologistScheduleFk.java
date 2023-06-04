package com.psycho.psychohelp.psychologist.domain.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



/**
 *
 * <p>Model class for psychologist schedule fk.</p>
 *
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PsychologistScheduleFk implements Serializable {

  @Column(name = "psychologist_id", nullable = false)
  private Long psychologistId;

  @Column(name = "schedule_id", nullable = false)
  private Long scheduleId;
}
