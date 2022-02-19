package edu.martin.plstatisticsapi.controller;

import edu.martin.plstatisticsapi.model.entity.FootballTeam;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import edu.martin.plstatisticsapi.util.ApiMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(ApiMappings.API + "/" + ApiMappings.TEAMS)
@CrossOrigin("*")
public class FootballTeamController {

  @Autowired
  private FootballTeamService service;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<FootballTeam> findAll() {
    return service.getAllFootballTeams();
  }

  // find one

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Optional<FootballTeam> findOne(@PathVariable("id") Long id) {
    return service.getFootballTeamById(id);
  }

  // create

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void add(@RequestBody FootballTeam footballTeam, HttpServletResponse response) {
    FootballTeam team = service.saveTeam(footballTeam);

    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(team.getId())
      .toUri();

    response.setStatus(CREATED.value());
    response.setHeader(HttpHeaders.LOCATION, location.getPath());
  }

}
