package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.entity.FootballTeam;
import edu.martin.plstatisticsapi.repository.FootballTeamRepository;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballTeamServiceImpl implements FootballTeamService {

  @Autowired
  private FootballTeamRepository footballTeamRepository;

  @Override
  public FootballTeam saveTeam(FootballTeam footballTeam) {
    return footballTeamRepository.save(footballTeam);
  }

  @Override
  public List<FootballTeam> getAllFootballTeams() {

    // TODO: populate football teams instead of null;
    return (footballTeamRepository.count() < 20) ? populateFootballTeams() : footballTeamRepository.findAll();
  }

  @Override
  public Optional<FootballTeam> getFootballTeamById(Long id) {
    return footballTeamRepository.findById(id);
  }

  @Override
  public List<FootballTeam> populateFootballTeams() {
    // TODO: Make a call to the Rest endpoint: https://api.football-data-api.com/league-teams (insomnia) and return the list
    return null;
  }

}
