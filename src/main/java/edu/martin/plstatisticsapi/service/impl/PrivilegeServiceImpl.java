package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.Privilege;
import edu.martin.plstatisticsapi.repository.IPrivilegeJpaDao;
import edu.martin.plstatisticsapi.service.AbstractService;
import edu.martin.plstatisticsapi.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements IPrivilegeService {

  @Autowired
  private IPrivilegeJpaDao dao;

  public PrivilegeServiceImpl() {
    super();
  }

  // API

  // find

  @Override
  public Privilege findOneByName(final String name) {
    return getDao().findOneByName(name);
  }

  // Spring

  @Override
  protected final IPrivilegeJpaDao getDao() {
    return dao;
  }

  @Override
  protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
    return dao;
  }
}
