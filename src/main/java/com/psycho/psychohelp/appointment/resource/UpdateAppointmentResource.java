package com.psycho.psychohelp.appointment.resource;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Update resource class for appointment.</p>
 *
 */
@Getter
@Setter
public class UpdateAppointmentResource {

  private String meetUrl;
  private String motive;
  private String personalHistory;
  private String testRealized;
  private String treatment;
  private String scheduleDate;
}
