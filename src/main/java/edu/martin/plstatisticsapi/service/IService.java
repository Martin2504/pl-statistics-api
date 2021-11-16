package edu.martin.plstatisticsapi.service;

import edu.martin.plstatisticsapi.interfaces.IByNameApi;
import edu.martin.plstatisticsapi.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

  //

}
