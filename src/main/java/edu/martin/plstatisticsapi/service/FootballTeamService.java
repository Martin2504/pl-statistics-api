package edu.martin.plstatisticsapi.service;

import edu.martin.plstatisticsapi.model.entity.FootballTeam;

import java.util.List;
import java.util.Optional;

public interface FootballTeamService {
  FootballTeam saveTeam(FootballTeam footballTeam);

  List<FootballTeam> getAllFootballTeams();

  Optional<FootballTeam> getFootballTeamById(Long id);

  List<FootballTeam> populateFootballTeams();
}
