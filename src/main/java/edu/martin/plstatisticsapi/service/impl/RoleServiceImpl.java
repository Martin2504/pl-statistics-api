package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.Role;
import edu.martin.plstatisticsapi.repository.IRoleJpaDao;
import edu.martin.plstatisticsapi.service.AbstractService;
import edu.martin.plstatisticsapi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements IRoleService {

  @Autowired
  private IRoleJpaDao dao;

  public RoleServiceImpl() {
    super();
  }

  // API

  // get/find

  @Override
  public Role findOneByName(final String name) {
    return getDao().findOneByName(name);
  }

  // create

  @Override
  public Role create(final Role entity) {
    /*
     * final long id = IdUtil.randomPositiveLong(); entity.setId( id );
     */

    /*
     * final List< Privilege > associationsTemp = Lists.newArrayList( entity.getPrivileges() ); entity.getPrivileges().clear(); for( final Privilege privilege : associationsTemp ){ entity.getPrivileges().add(
     * associationDao.findByName( privilege.getName() ) ); }
     */

    return super.create(entity);
  }

  // Spring

  @Override
  protected final IRoleJpaDao getDao() {
    return dao;
  }

  @Override
  protected JpaSpecificationExecutor<Role> getSpecificationExecutor() {
    return dao;
  }

}
