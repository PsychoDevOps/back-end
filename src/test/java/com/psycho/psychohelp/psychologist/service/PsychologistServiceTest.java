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

import java.util.Date;
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



}
