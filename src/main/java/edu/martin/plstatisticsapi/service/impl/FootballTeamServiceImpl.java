package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.FootballTeam;
import edu.martin.plstatisticsapi.repository.FootballTeamRepository;
import edu.martin.plstatisticsapi.service.AbstractService;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FootballTeamServiceImpl extends AbstractService<FootballTeam> implements FootballTeamService {

  @Autowired
  private FootballTeamRepository dao;

  public FootballTeamServiceImpl() {
    super();
  }

  // API

  // Find

  @Override
  public FootballTeam findOneByName(String name) {
    return getDao().findOneByName(name);
  }

  // spring

  @Override
  protected FootballTeamRepository getDao() {
    return dao;
  }

  @Override
  protected JpaSpecificationExecutor<FootballTeam> getSpecificationExecutor() {
    return dao;
  }

}
