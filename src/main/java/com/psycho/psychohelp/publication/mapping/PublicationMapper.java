package com.psycho.psychohelp.publication.mapping;

import com.psycho.psychohelp.publication.domain.model.entity.Publication;
import com.psycho.psychohelp.publication.resource.CreatePublicationResource;
import com.psycho.psychohelp.publication.resource.PublicationResource;
import com.psycho.psychohelp.publication.resource.UpdatePublicationResource;
import com.psycho.psychohelp.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * <p>Mapper class for publication.</p>
 *
 */
public class PublicationMapper implements Serializable {

  @Autowired
  private EnhancedModelMapper mapper;

  public PublicationResource toResource(Publication model) {
    return mapper.map(model, PublicationResource.class);
  }

  public List<PublicationResource> toResource(List<Publication> model) {
    return mapper.mapList(model, PublicationResource.class);
  }

  /**
   *
   * <p>Method to convert a publication model list to a page.</p>
   *
   */
  public Page<PublicationResource> modelListToPage(List<Publication> modelList, Pageable pageable) {
    return new PageImpl<>(
            mapper.mapList(modelList, PublicationResource.class),
            pageable,
            modelList.size());
  }

  public Publication toModel(CreatePublicationResource resource) {
    return mapper.map(resource, Publication.class);
  }

  public  Publication toModel(UpdatePublicationResource resource) {
    return mapper.map(resource, Publication.class);
  }
}
