package edu.martin.plstatisticsapi.service;

import edu.martin.plstatisticsapi.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

  public AbstractService() {
    super();
  }

  // API

}
