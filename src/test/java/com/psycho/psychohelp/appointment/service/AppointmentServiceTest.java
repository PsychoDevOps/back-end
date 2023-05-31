package com.psycho.psychohelp.appointment.service;

import com.psycho.psychohelp.appointment.domain.model.entity.Appointment;
import com.psycho.psychohelp.appointment.domain.persistance.AppointmentRepository;
import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentServiceImpl appointmentService;
    @Mock
    private AppointmentRepository appointmentRepository;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");;

    @Test
    @DisplayName("Test for search by ID")
    public void testSearchByID() {
        Appointment wait = new Appointment(1L, "www.meet.com/HtzJja", "Peace", "Treatment", "Psycologist", "Weekly", "12/05/2023", new Patient(), new Psychologist());
        Mockito.when(appointmentRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Appointment(1L, "www.meet.com/HtzJja", "Peace", "Treatment", "Psycologist", "Weekly", "12/05/2023", new Patient(), new Psychologist())));


        Appointment getting = appointmentService.getById(1L);
        Assertions.assertEquals(wait.getId(), getting.getId());

        Mockito.verify(appointmentRepository,Mockito.times(1)).findById(Mockito.anyLong());
    }
    @Test
    public void testGetAppointmentById() {
        Long appointmentId = 1L;
        Patient patient = new Patient();
        patient.setId(2L);
        Psychologist psychologist = new Psychologist();
        psychologist.setId(3L);
        Appointment appointment = new Appointment();
        appointment.setId(appointmentId);
        appointment.setPatient(patient);
        appointment.setPsychologist(psychologist);

        Mockito.when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));

        Appointment result = appointmentService.getById(appointmentId);

        Assertions.assertEquals(appointment, result);
        Assertions.assertEquals(patient, result.getPatient());
        Assertions.assertEquals(psychologist, result.getPsychologist());

        Mockito.verify(appointmentRepository, Mockito.times(1)).findById(appointmentId);
    }
    @Test
    @DisplayName("Test for search a Psychologist by id")
    public void testSearchPsychologistById() throws ParseException {
        Psychologist psychologist = new Psychologist(1L, "John Doe", "12345", format.parse("1980-01-01"), "john.doe@mail.com", "password",
                "123456789", "Specialization", "Formation", "About me", "male", "session type", "img.jpg", "CMP12345", true, true);
        Appointment appointment = new Appointment(1L, "www.meet.com/HtzJja", "Peace", "Treatment", "Psychologist", "Weekly",
                "12/05/2023", new Patient(1L, "Juan", "Normal", "user@gmail.com", "123456", "android", "01/01", "Male", "photo"),
                psychologist);

        Mockito.when(appointmentRepository.findByPsychologistId(1L)).thenReturn(Collections.singletonList(appointment));
        List<Appointment> appointments = appointmentService.getByPsychologistId(1L);
        Assertions.assertEquals(psychologist, appointments.get(0).getPsychologist());
        Mockito.verify(appointmentRepository, Mockito.times(1)).findByPsychologistId(Mockito.anyLong());
    }
    @Test
    @DisplayName("Test for search a Patient")
    public void testSearchPatient() throws ParseException {
        Patient expectedPatient = new Patient(1L, "Juan", "Normal", "user@gmail.com", "123456", "android", "01/01", "Masculino", "photo");
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1L, "www.meet.com/HtzJja", "Peace", "Treatment", "Psychologist", "Weekly", "12/05/2023", expectedPatient, new Psychologist(1L, "Jorge", "12345", format.parse("1980-12-05"), "jorgel@mail.com", "password", "984561278", "especializacion", "formacion", "about", "masculino", "sesiontype", "img.jpg", "cmp", true, true)));
        Mockito.when(appointmentRepository.findByPatientId(1L)).thenReturn(appointments);
        List<Appointment> resultAppointments = appointmentService.getByPatientId(1L);
        Assertions.assertEquals(expectedPatient, resultAppointments.get(0).getPatient());
        Mockito.verify(appointmentRepository, Mockito.times(1)).findByPatientId(Mockito.anyLong());
    }
    @Test
    @DisplayName("Test for search a Patient and Psychologist")
    public void testSearchPatientAndPsychologist() throws ParseException {
        Patient patient = new Patient(1L, "Juan", "Normal", "user@gmail.com","123456","android","01/01","Masculino","photo");
        Psychologist psychologist = new Psychologist(1L, "Jorge",  "12345", format.parse("1980-12-05"),"jorgel@mail.com","password", "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true);
        Appointment appointment = new Appointment(1L, "www.meet.com/HtzJja", "Peace", "Treatment", "Psychologist", "Weekly", "12/05/2023", patient, psychologist);

        List<Appointment> appointments = Collections.singletonList(appointment);
        Mockito.when(appointmentRepository.findByPatientIdAndPsychologistId(1L, 1L)).thenReturn(appointments);

        List<Appointment> appointmentsResult = appointmentService.getByPatientIdAndPsychologistId(1L, 1L);

        Assertions.assertEquals(1, appointmentsResult.size());
        Assertions.assertEquals(patient, appointmentsResult.get(0).getPatient());
        Assertions.assertEquals(psychologist, appointmentsResult.get(0).getPsychologist());

        Mockito.verify(appointmentRepository, Mockito.times(1)).findByPatientIdAndPsychologistId(Mockito.any(), Mockito.any());
    }

}