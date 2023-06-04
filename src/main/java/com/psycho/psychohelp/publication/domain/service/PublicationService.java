package com.psycho.psychohelp.publication.domain.service;

import com.psycho.psychohelp.publication.domain.model.entity.Publication;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * <p>Service interface for publication.</p>
 *
 */
public interface PublicationService {
  List<Publication> getAll();

  Publication getById(Long publicationId);

  Publication create(Publication publication, Long psychologistId);

  Publication update(Long publicationId, Publication request);

  ResponseEntity<?> delete(Long publicationId);

  List<Publication> getByPsychologistId(Long psychologistId);
}
