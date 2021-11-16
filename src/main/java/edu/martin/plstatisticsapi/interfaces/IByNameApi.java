package edu.martin.plstatisticsapi.interfaces;

public interface IByNameApi<T extends IWithName>{

  T findOneByName(final String name);

}
