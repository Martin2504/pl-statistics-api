package edu.martin.plstatisticsapi.controller;

import edu.martin.plstatisticsapi.controller.interfaces.ISortingController;
import edu.martin.plstatisticsapi.model.FootballTeam;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import edu.martin.plstatisticsapi.service.IRawService;
import edu.martin.plstatisticsapi.util.ApiMappings;
import edu.martin.plstatisticsapi.util.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiMappings.API + "/" + ApiMappings.TEAMS)
@CrossOrigin("*")
public class FootballTeamController extends AbstractController<FootballTeam> implements ISortingController<FootballTeam> {

  @Autowired
  private FootballTeamService service;

  // find all

  @Override
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @ResponseBody
  public List<FootballTeam> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
    return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
  }

  @Override
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE }, method = RequestMethod.GET)
  @ResponseBody
  public List<FootballTeam> findAllPaginated(int page, int size) {
    return findPaginatedInternal(page, size);
  }

  @Override
  @RequestMapping(params = { QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @ResponseBody
  public List<FootballTeam> findAllSorted(String sortBy, String sortOrder) {
    return findAllSortedInternal(sortBy, sortOrder);
  }

  @Override
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<FootballTeam> findAll(final HttpServletRequest request) {
    return findAllInternal(request);
  }

  // find one

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public FootballTeam findOne(@PathVariable("id") Long id) {
    return findOneInternal(id);
  }

  // create

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody @Valid FootballTeam footballTeam) {
    createInternal(footballTeam);
  }

  // update

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable("id") final Long id, @RequestBody @Valid final FootballTeam resource) {
    updateInternal(id, resource);
  }

  // delete

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") final Long id) {
    deleteByIdInternal(id);
  }

  // spring

  @Override
  protected IRawService<FootballTeam> getService() {
    return service;
  }
}
