package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.model.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {

}
