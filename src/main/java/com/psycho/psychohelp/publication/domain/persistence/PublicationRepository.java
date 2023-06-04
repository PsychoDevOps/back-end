package com.psycho.psychohelp.publication.domain.persistence;

import com.psycho.psychohelp.publication.domain.model.entity.Publication;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * <p>Repository interface for publication.</p>
 *
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
  List<Publication> findByPsychologistId(Long psychologistId);
}
