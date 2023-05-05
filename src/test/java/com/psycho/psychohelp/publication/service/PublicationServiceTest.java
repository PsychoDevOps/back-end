package com.psycho.psychohelp.publication.service;

import com.psycho.psychohelp.publication.domain.model.entity.Publication;
import com.psycho.psychohelp.publication.domain.persistence.PublicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PublicationServiceTest {

    @InjectMocks
    private PublicationServiceImpl publicationService;
    @Mock
    private PublicationRepository publicationRepository;

    @Test
    @DisplayName("Test para Buscar por ID")
    public void testBuscarPorID(){
        Publication espero = new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        Mockito.when(publicationRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")));

        Publication recibo = publicationService.getById(1L);
        Assertions.assertEquals(espero.getId(),recibo.getId());

        Mockito.verify(publicationRepository,Mockito.times(1)).findById(Mockito.anyLong());

    }

    @Test
    @DisplayName("Test para Buscar por ID de psicólogo")
    public void testBuscarPorIdDePsicologo(){
        Publication espero = new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        Mockito.when(publicationRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")));

        Publication recibo = publicationService.getByPsychologistId(1L).get(1);
        Assertions.assertEquals(espero.getPsychologist().getId(),recibo.getPsychologist().getId());

        Mockito.verify(publicationRepository,Mockito.times(1)).findByPsychologistId(Mockito.anyLong());

    }

    @Test
    @DisplayName("Test para Obtener todas las Publicaciones")
    public void testObtenerTodasLasPublicaciones(){
        List<Publication> espero = new ArrayList<>();
        espero.add(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."));
        espero.add(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."));

        List<Publication> recibo = new ArrayList<>();
        recibo.add(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."));
        recibo.add(new Publication(1L, "Investigación sobre el Covid-19", "Investigación en curso para poder saber más sobre el virus", "covid", "https://imgur.com/DxuaaEg", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."));

        Mockito.when( publicationRepository.findAll() )
                .thenReturn( recibo );

        List<Publication> actual = publicationService.getAll();

        Assertions.assertEquals(espero.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(espero.get(1).getId(), actual.get(1).getId());

        Mockito.verify(publicationRepository, Mockito.times(1)).findAll();
    }
}
