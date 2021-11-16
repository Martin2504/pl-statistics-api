package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.interfaces.IByNameApi;
import edu.martin.plstatisticsapi.model.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long>, JpaSpecificationExecutor<FootballTeam>, IByNameApi<FootballTeam> {
  //
}
