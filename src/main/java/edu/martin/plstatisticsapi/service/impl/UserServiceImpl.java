package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.User;
import edu.martin.plstatisticsapi.repository.IUserJpaDao;
import edu.martin.plstatisticsapi.service.AbstractService;
import edu.martin.plstatisticsapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

  @Autowired
  private IUserJpaDao dao;

  public UserServiceImpl() {
    super();
  }

  // API

  // find

  @Override
  @Transactional(readOnly = true)
  public User findOneByName(final String name) {
    return dao.findOneByName(name);
  }

  // other

  // Spring

  @Override
  protected final IUserJpaDao getDao() {
    return dao;
  }

  @Override
  protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
    return dao;
  }
}
