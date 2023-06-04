package com.psycho.psychohelp.psychologist.domain.service;

import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * <p>Service interface for psychologist.</p>
 *
 */
public interface PsychologistService {
  List<Psychologist> getAll();
  //Page<Psychologist> getAll(Pageable pageable);

  Psychologist getById(Long psychologistId);

  Psychologist create(Psychologist request);

  Psychologist update(Long psychologistId, Psychologist request);

  ResponseEntity<?> delete(Long psychologistId);

  Psychologist getByEmail(String email);

  List<Psychologist> getByGenre(String genre);

  List<Psychologist> getBySessionType(String sessionType);

  Psychologist getByName(String name);

  List<Psychologist> getByGenreAndSessionType(String genre, String sessionType);
}
