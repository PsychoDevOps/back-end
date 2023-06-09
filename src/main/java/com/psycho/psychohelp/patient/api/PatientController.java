package com.psycho.psychohelp.patient.api;

import com.psycho.psychohelp.patient.domain.service.PatientService;
import com.psycho.psychohelp.patient.mapping.PatientMapper;
import com.psycho.psychohelp.patient.resource.CreatePatientResource;
import com.psycho.psychohelp.patient.resource.PatchPanicResource;
import com.psycho.psychohelp.patient.resource.PatientResource;
import com.psycho.psychohelp.patient.resource.UpdatePatientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>Controller class for patient.</p>
 *
 */
@Tag(name = "Patient")
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

  @Autowired
  private PatientService patientService;

  @Autowired
  private PatientMapper mapper;


  @Operation(summary = "Get Patients", description = "Get All Patients")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Patients found"),
      @ApiResponse(responseCode = "400", description = "Patient not found") })
  @GetMapping
  public List<PatientResource> getAllPatients() {
    return mapper.toResource(patientService.getAll());
  }

  @Operation(summary = "Get Patients by Id", description = "Get Patient by Id")
  @GetMapping("{patientId}")
  public PatientResource getById(@PathVariable Long patientId) {
    return mapper.toResource(patientService.getById(patientId));
  }


  @Operation(summary = "Get Patients by Email", description = "Get Patient information by email")
  @GetMapping("/email/{patientEmail}")
  public PatientResource getPatientByEmail(@PathVariable String patientEmail) {
    return mapper.toResource(patientService.getByEmail(patientEmail));
  }

  //create patient
  @Operation(summary = "Create Patient", description = "Create Patient")
  @PostMapping
  public PatientResource createPatient(@RequestBody CreatePatientResource request) {
    return mapper.toResource(patientService.create(mapper.toModel(request)));
  }

  @Operation(summary = "Update patient", description = "Update Patient by Id ")
  @PutMapping("{patientId}")
  public PatientResource updatePatient(@PathVariable Long patientId,
                                       @RequestBody UpdatePatientResource request) {
    return mapper.toResource(patientService.update(patientId, mapper.toModel(request)));
  }

  @Operation(summary = "Activate panic patient", description = "Activate panic Patient by Id")
  @PatchMapping("panic/{patientId}")
  public PatientResource activatePanicPatient(@PathVariable Long patientId,
                                              @RequestBody PatchPanicResource request) {
    return mapper.toResource(patientService.activatePanic(patientId, mapper.toModel(request)));
  }

  @Operation(summary = "Get all panic patient", description = "Get all panic patients")
  @GetMapping("panic")
  public List<PatientResource> getPanicPatients() {
    return mapper.toResource(patientService.getPanicPatients());
  }

  @Operation(summary = "Delete patient", description = "Delete Patient by Id")
  @DeleteMapping("{patientId}")
  public ResponseEntity<?> deletePost(@PathVariable Long patientId) {
    return patientService.delete(patientId);
  }
}
