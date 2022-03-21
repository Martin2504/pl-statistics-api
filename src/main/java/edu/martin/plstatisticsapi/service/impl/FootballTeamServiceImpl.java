package edu.martin.plstatisticsapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.martin.plstatisticsapi.model.entity.FootballTeam;
import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;
import edu.martin.plstatisticsapi.repository.FootballTeamRepository;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import edu.martin.plstatisticsapi.vo.FootballTeamVO;
import edu.martin.plstatisticsapi.vo.LeagueTableRecordVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootballTeamServiceImpl implements FootballTeamService {

  private final FootballTeamRepository footballTeamRepository;
  private final RestTemplate restTemplate;

  @Override
  public FootballTeam saveTeam(FootballTeam footballTeam) {
    return footballTeamRepository.save(footballTeam);
  }

  @Override
  public List<FootballTeam> getAllFootballTeams() {

    return (footballTeamRepository.count() < 20) ? populateFootballTeams() : footballTeamRepository.findAll();
  }

  @Override
  public Optional<FootballTeam> getFootballTeamById(Long id) {
    return footballTeamRepository.findById(id);
  }

  @Override
  public List<FootballTeam> populateFootballTeams() {

    log.info("---> The teams table is about to be populated.");

    String getTeamsUrl = "https://api.football-data-api.com/league-teams?key=example&season_id=4759&include%3Dstats";
    String getLeagueTableRecordsUrl = "https://api.football-data-api.com/league-tables?key=example&league_id=4759";
    ResponseEntity<String> responseTeams = restTemplate.getForEntity(getTeamsUrl, String.class);
    ResponseEntity<String> responseLeagueRecords = restTemplate.getForEntity(getLeagueTableRecordsUrl, String.class);
    ObjectMapper mapper = new ObjectMapper();

    try {
      JsonNode rootTeams = mapper.readTree(responseTeams.getBody());
      JsonNode dataTeams = rootTeams.path("data");
      List<FootballTeamVO> teams = mapper.readValue(dataTeams.toString(), new TypeReference<List<FootballTeamVO>>(){});
      List<FootballTeam> resultTeams = teams.stream().map(team -> team.getFootballTeam()).collect(Collectors.toList());

      JsonNode rootLeagueRecords = mapper.readTree(responseLeagueRecords.getBody());
      JsonNode dataLeagueRecords = rootLeagueRecords.path("data").path("league_table");
      List<LeagueTableRecordVO> leagueRecords = mapper.readValue(dataLeagueRecords.toString(), new TypeReference<List<LeagueTableRecordVO>>(){});
//      List<LeagueTableRecord> resultLeagueRecords = leagueRecords.stream().map(lr -> lr.getRecord()).collect(Collectors.toList());

//      resultTeams.stream().filter(team -> team.);
      leagueRecords.forEach(recordVo -> {
        FootballTeam team = resultTeams.stream().filter(t -> recordVo.getTeamId() == t.getExternalId()).findFirst().get();
        LeagueTableRecord recordEntity = recordVo.getRecord();
        recordEntity.setFootballTeam(team);
        team.setLeagueTableRecord(recordVo.getRecord());
        log.info(team.getName() + " has been added.");
      });
      footballTeamRepository.saveAll(resultTeams);
      log.info("---> The teams table have been populated.");
      return resultTeams;

    } catch (JsonProcessingException e) {
      log.error("Error while populating teams table: " + e.getOriginalMessage());
    }


    return null;
  }

}
