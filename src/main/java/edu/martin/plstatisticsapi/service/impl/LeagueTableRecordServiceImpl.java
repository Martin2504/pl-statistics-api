package edu.martin.plstatisticsapi.service.impl;

import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;
import edu.martin.plstatisticsapi.repository.LeagueTableRecordRepository;
import edu.martin.plstatisticsapi.service.LeagueTableRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueTableRecordServiceImpl implements LeagueTableRecordService {

  @Autowired
  private LeagueTableRecordRepository leagueTableRecordRepository;

  @Override
  public List<LeagueTableRecord> getAllLeagueTableRecords() {
    return (leagueTableRecordRepository.count() < 20) ? populateLeagueTable() : leagueTableRecordRepository.findAll();
  }

  @Override
  public Optional<LeagueTableRecord> getLeagueTableRecordById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<LeagueTableRecord> populateLeagueTable() {
    /*String uri = "https://api.football-data-api.com/league-tables?key=example&league_id=4759";
    RestTemplate restTemplate = new RestTemplate();

    LeagueTableRecord[] records = restTemplate.getForObject(uri, LeagueTableRecord[].class);

    return Arrays.asList(records);*/
    return null;

  }
}
