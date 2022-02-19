package edu.martin.plstatisticsapi.service;

import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;

import java.util.List;
import java.util.Optional;

public interface LeagueTableRecordService {

  List<LeagueTableRecord> getAllLeagueTableRecords();

  Optional<LeagueTableRecord> getLeagueTableRecordById(Long id);

  List<LeagueTableRecord> populateLeagueTable();

}
