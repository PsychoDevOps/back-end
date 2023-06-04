package com.psycho.psychohelp.appointment.resource;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Resource class for appointment.</p>
 *
 */
@Getter
@Setter
public class AppointmentResource {
  private Long id;
  private String meetUrl;
  private String motive;
  private String personalHistory;
  private String testRealized;
  private String treatment;
  private String scheduleDate;
  private Long psychologistId;
  private Long patientId;
}
