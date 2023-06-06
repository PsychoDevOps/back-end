package com.psycho.psychohelp.psychologist.api;

import com.psycho.psychohelp.psychologist.domain.service.ScheduleService;
import com.psycho.psychohelp.psychologist.mapping.ScheduleMapper;
import com.psycho.psychohelp.psychologist.resource.CreateScheduleResource;
import com.psycho.psychohelp.psychologist.resource.ScheduleResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>Controller class for schedule.</p>
 *
 */
@Tag(name = "Schedule")
@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

  @Autowired
  private ScheduleService scheduleService;

  @Autowired
  private ScheduleMapper scheduleMapper;

  @Operation(summary = "Create schedule", description = "Create schedule")
  @PostMapping
  public ScheduleResource createSchedule(@RequestBody CreateScheduleResource request) {
    return scheduleMapper.toResource(scheduleService.create(scheduleMapper.toModel(request)));
  }
}
