package com.psycho.psychohelp.psychologist.domain.service;

import com.psycho.psychohelp.psychologist.domain.model.entity.Schedule;
import java.util.List;

/**
 *
 * <p>Service interface for schedule.</p>
 *
 */
public interface ScheduleService {
  List<Schedule> getAll();

  Schedule create(Schedule schedule);

  Schedule getById(Long scheduleId);
}
