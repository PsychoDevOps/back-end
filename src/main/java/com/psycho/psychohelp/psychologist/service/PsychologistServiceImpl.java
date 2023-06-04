package com.psycho.psychohelp.psychologist.service;

import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.psychologist.domain.persistence.PsychologistRepository;
import com.psycho.psychohelp.psychologist.domain.service.PsychologistService;
import com.psycho.psychohelp.shared.exception.ResourceNotFoundException;
import java.util.List;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * <p>Service implementation class for psychologist.</p>
 *
 */
@Service
public class PsychologistServiceImpl implements PsychologistService {

  private static final String ENTITY = "Psychologist";

  @Autowired
  private PsychologistRepository psychologistRepository;

  @Autowired
  private Validator validator;


  @Override
  public List<Psychologist> getAll() {
    return psychologistRepository.findAll();
  }

  //@Override
  //public Page<Psychologist> getAll(Pageable pageable)
  //{
  //    return psychologistRepository.findAll(pageable);
  //}

  @Override
  public Psychologist getById(Long psychologistId) {
    return psychologistRepository.findById(psychologistId)
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, psychologistId));
  }

  @Override
  public Psychologist getByEmail(String psychologistEmail) {
    return psychologistRepository.findByEmail(psychologistEmail);
  }

  @Override
  public List<Psychologist> getByGenre(String psychologistGenre) {
    return psychologistRepository.findByGenre(psychologistGenre);
  }

  @Override
  public List<Psychologist> getBySessionType(String sessionType) {
    return psychologistRepository.findBySessionType(sessionType);
  }

  @Override
  public List<Psychologist> getByGenreAndSessionType(String genre, String sessionType) {
    return psychologistRepository.findByGenreAndSessionType(genre, sessionType);
  }

  @Override
  public Psychologist getByName(String name) {
    return psychologistRepository.findByName(name);
  }

  @Override
  public Psychologist create(Psychologist request) {
    return psychologistRepository.save(request);
  }

  @Override
  public Psychologist update(Long psychologistId, Psychologist request) {
    return psychologistRepository.findById(psychologistId).map(psychologist ->
                    psychologistRepository.save(
                            psychologist.withName(request.getName())
                                    .withDni(request.getDni())
                                    .withBirthdayDate(request.getBirthdayDate())
                                    .withEmail(request.getEmail())
                                    .withPassword(request.getPassword())
                                    .withPhone(request.getPhone())
                                    .withSpecialization(request.getSpecialization())
                                    .withFormation(request.getFormation())
                                    .withAbout(request.getAbout())
                                    .withGenre(request.getGenre())
                                    .withSessionType(request.getSessionType())
                                    .withImage(request.getImage())
                                    .withCmp(request.getCmp())
                                    .withActive(request.getActive())
                                    .withFresh(request.getFresh())))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, psychologistId));
  }

  @Override
  public ResponseEntity<?> delete(Long psychologistId) {

    return psychologistRepository.findById(psychologistId).map(psychologist -> {
      psychologistRepository.delete(psychologist);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, psychologistId));
  }
}
