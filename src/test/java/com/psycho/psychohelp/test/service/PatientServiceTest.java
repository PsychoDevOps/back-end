package com.psycho.psychohelp.test.service;

import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.patient.domain.persistence.PatientRepository;
import com.psycho.psychohelp.patient.domain.service.PatientService;
import com.psycho.psychohelp.patient.service.PatientServiceImpl;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.stubbing.Answer;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    private PatientServiceImpl patientService;

    @Mock
    private PatientRepository patientRepository;

    @Test
    @DisplayName("Test for getAll from patient")
    public void testGetAll(){
        List<Patient> expected = new ArrayList<>();
        expected.add(new Patient(1L, "Jorge", "López", "jorgel@mail.com", "12345", "984561278", "03/05/2023", "masculino", "img.jpg"));
        expected.add(new Patient(2L, "Juan", "Flores", "jflores@mail.com", "abcde", "974568178", "02/05/2023", "masculino", "img1.jpg"));

        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Jorge", "López", "jorgel@mail.com", "12345", "984561278", "03/05/2023", "masculino", "img.jpg"));
        patients.add(new Patient(2L, "Juan", "Flores", "jflores@mail.com", "abcde", "974568178", "02/05/2023", "masculino", "img1.jpg"));

        Mockito.when( patientRepository.findAll() )
                .thenReturn( patients );

        List<Patient> actual = patientService.getAll();

        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(1).getId(), actual.get(1).getId());

        Mockito.verify(patientRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Test for getById function")
    public void testgetById() {
        Patient expected = new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg");
        Mockito.when( patientRepository.findById(Mockito.anyLong()) )
                .thenReturn(Optional.of(new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg")));

        Patient actual = patientService.getById(1L);

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());

        Mockito.verify(patientRepository, Mockito.times(1)).findById(Mockito.anyLong());

    }

    @Test
    @DisplayName("Test create function")
    public void testCreate(){
        Patient expected = new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg");
        Patient patient = new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg");

        Mockito.when(patientRepository.save(Mockito.any())).thenReturn(patient);

        Patient actual = patientService.create(new Patient(null,"Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg"));

        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(expected.getLastName(), actual.getLastName());
        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
        Assertions.assertEquals(expected.getPassword(), actual.getPassword());
        Assertions.assertEquals(expected.getPhone(), actual.getPhone());
        Assertions.assertEquals(expected.getDate(), actual.getDate());
        Assertions.assertEquals(expected.getGender(), actual.getGender());
        Assertions.assertEquals(expected.getImg(), actual.getImg());
    }

    @Test
    @DisplayName("Test for getByEmail function")
    public void testgetByEmail() {
        Patient expected = new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg");
        Mockito.when( patientRepository.findByEmail(Mockito.anyString()) )
                .thenReturn(new Patient(1L, "Ana", "López", "alopez@mail.com", "12345", "945786213", "03/04/2023", "femenino", "img.jpg"));

        Patient actual = patientService.getByEmail("alopez@mail.com");

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());

        Mockito.verify(patientRepository, Mockito.times(1)).findByEmail(Mockito.anyString());

    }

}
