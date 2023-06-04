package com.psycho.psychohelp.shared.mapping;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

/**
 *
 * <p>Enhanced model mapper class.</p>
 *
 */
public class EnhancedModelMapper extends ModelMapper {

  public EnhancedModelMapper() {
    super();
  }

  /**
   *
   * <p>Method for map list a list to a target class.</p>
   *
   */
  public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
    return sourceList.stream().map(item -> this.map(item, targetClass))
            .collect(Collectors.toList());

  }
}
