package com.psycho.psychohelp.psychologist.service;

import com.psycho.psychohelp.psychologist.domain.model.entity.Schedule;
import com.psycho.psychohelp.psychologist.domain.persistence.ScheduleRepository;
import com.psycho.psychohelp.psychologist.domain.service.ScheduleService;
import com.psycho.psychohelp.shared.exception.ResourceNotFoundException;
import java.util.List;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * <p>Service interface for schedule.</p>
 *
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

  private static final String ENTITY = "Schedule";

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private Validator validator;

  @Override
  public List<Schedule> getAll() {
    return scheduleRepository.findAll();
  }

  @Override
  public Schedule create(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }

  @Override
  public Schedule getById(Long scheduleId) {
    return scheduleRepository.findById(scheduleId)
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, scheduleId));
  }
}
