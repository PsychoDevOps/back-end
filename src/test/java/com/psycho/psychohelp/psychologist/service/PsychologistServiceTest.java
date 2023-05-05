package com.psycho.psychohelp.psychologist.service;

import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.psychologist.domain.persistence.PsychologistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PsychologistServiceTest {

   @InjectMocks
    private PsychologistServiceImpl psychologistService;
    @Mock
    private PsychologistRepository psychologistRepository;

    @Test
    @DisplayName("test buscar por id")
    public void testBuscarPorID(){
     Psychologist espero = new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
             "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true);

     Mockito.when(psychologistRepository.findById(Mockito.anyLong()))
             .thenReturn(Optional.of(new Psychologist(1L, "Jorge", "12345", "1980/12/05", "jorgel@mail.com", "password",
                     "984561278", "especializacion", "formacion", "about", "masculino", "sesiontype", "img.jpg", "cmp", true, true)));

     Psychologist recibo =psychologistService.getById(1L);
     Assertions.assertEquals(espero.getId(),recibo.getId());

     Mockito.verify(psychologistRepository,Mockito.times(1)).findById(Mockito.anyLong());

    }

 @Test
 @DisplayName("test buscar psicologo por email")
 public void testBuscarPorEmail(){
  Psychologist espero = new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true);

  Mockito.when(psychologistRepository.findByEmail(Mockito.anyString()))
          .thenReturn(new Psychologist(1L, "Jorge", "12345", "1980/12/05", "jorgel@mail.com", "password",
                  "984561278", "especializacion", "formacion", "about", "masculino", "sesiontype", "img.jpg", "cmp", true, true));

  Psychologist recibo =psychologistService.getByEmail("jorgel@mail.com");
  Assertions.assertEquals(espero.getEmail(),recibo.getEmail());

  Mockito.verify(psychologistRepository,Mockito.times(1)).findByEmail(Mockito.anyString());

 }

 @Test
 @DisplayName("test buscar psicologo por genero")
 public void testBuscarPorGenero(){
  ArrayList<Psychologist> espero = new ArrayList<>();
  espero.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  espero.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  List<Psychologist> psychologists = new ArrayList<>();
  psychologists.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  psychologists.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));


  Mockito.when(psychologistRepository.findByGenre("masculino"))
          .thenReturn(psychologists);


  List<Psychologist> recibo = psychologistService.getByGenre("masculino");
  Assertions.assertEquals(espero.get(0).getGenre(),recibo.get(0).getGenre());
  Assertions.assertEquals(espero.get(1).getGenre(),recibo.get(1).getGenre());
  Mockito.verify(psychologistRepository,Mockito.times(1)).findByGenre(Mockito.anyString());

 }


 @Test
 @DisplayName("test buscar psicologo por tipo de sesion")
 public void testBuscarPorTipoSesion(){
  ArrayList<Psychologist> espero = new ArrayList<>();
  espero.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  espero.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype1", "img.jpg","cmp",true,true));

  List<Psychologist> psychologists = new ArrayList<>();
  psychologists.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  psychologists.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype1", "img.jpg","cmp",true,true));


  Mockito.when(psychologistRepository.findBySessionType("sesiontype"))
          .thenReturn(psychologists);


  List<Psychologist> recibo = psychologistService.getBySessionType("sesiontype");
  Assertions.assertEquals(espero.get(0).getSessionType(),recibo.get(0).getSessionType());
  Assertions.assertEquals(espero.get(1).getSessionType(),recibo.get(1).getSessionType());
  Mockito.verify(psychologistRepository,Mockito.times(1)).findBySessionType(Mockito.anyString());

 }

 @Test
 @DisplayName("test buscar psicologo por genero y tipo de sesion")
 public void testBuscarPorGeneroYTipoDeSesion(){
  ArrayList<Psychologist> espero = new ArrayList<>();
  espero.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  espero.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype1", "img.jpg","cmp",true,true));

  List<Psychologist> psychologists = new ArrayList<>();
  psychologists.add(new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true));

  psychologists.add(new Psychologist(2L, "Jorgito",  "123456","1980/12/05","jorgitol@mail.com","password",
          "984568278","especializacion","formacion","about", "masculino","sesiontype1", "img.jpg","cmp",true,true));


  Mockito.when(psychologistRepository.findByGenreAndSessionType("masculino","sesiontype"))
          .thenReturn(psychologists);


  List<Psychologist> recibo = psychologistService.getByGenreAndSessionType("masculino","sesiontype");
  Assertions.assertEquals(espero.get(0).getGenre(),recibo.get(0).getGenre());
  Assertions.assertEquals(espero.get(1).getGenre(),recibo.get(1).getGenre());
  Assertions.assertEquals(espero.get(0).getSessionType(),recibo.get(0).getSessionType());
  Assertions.assertEquals(espero.get(1).getSessionType(),recibo.get(1).getSessionType());
  Mockito.verify(psychologistRepository,Mockito.times(1)).findByGenreAndSessionType(Mockito.anyString(),Mockito.anyString());

 }


 @Test
 @DisplayName("test buscar psicologo por nombre")
 public void testBuscarPorNombre(){
  Psychologist espero = new Psychologist(1L, "Jorge",  "12345","1980/12/05","jorgel@mail.com","password",
          "984561278","especializacion","formacion","about", "masculino","sesiontype", "img.jpg","cmp",true,true);

  Mockito.when(psychologistRepository.findByName(Mockito.anyString()))
          .thenReturn(new Psychologist(1L, "Jorge", "12345", "1980/12/05", "jorgel@mail.com", "password",
                  "984561278", "especializacion", "formacion", "about", "masculino", "sesiontype", "img.jpg", "cmp", true, true));

  Psychologist recibo =psychologistService.getByName("Jorge");
  Assertions.assertEquals(espero.getName(),recibo.getName());

  Mockito.verify(psychologistRepository,Mockito.times(1)).findByName(Mockito.anyString());

 }




}
