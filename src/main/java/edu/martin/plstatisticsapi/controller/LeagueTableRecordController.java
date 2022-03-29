package edu.martin.plstatisticsapi.controller;

import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;
import edu.martin.plstatisticsapi.service.LeagueTableRecordService;
import edu.martin.plstatisticsapi.util.ApiMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiMappings.API + "/" + ApiMappings.LEAGUE_TABLE, method = RequestMethod.GET)
@CrossOrigin(origins = "http://localhost:3000/")
public class LeagueTableRecordController {

  @Autowired
  private LeagueTableRecordService service;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<LeagueTableRecord> findAll() {
    return service.getAllLeagueTableRecords();
  }

}
