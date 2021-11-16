package edu.martin.plstatisticsapi.controller;

import edu.martin.plstatisticsapi.controller.interfaces.ISortingController;
import edu.martin.plstatisticsapi.model.User;
import edu.martin.plstatisticsapi.service.IUserService;
import edu.martin.plstatisticsapi.util.ApiMappings;
import edu.martin.plstatisticsapi.util.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = ApiMappings.API + "/" +ApiMappings.USERS)
public class UserController extends AbstractController<User> implements ISortingController<User> {

  @Autowired
  private IUserService service;

  // API

  // find - all/paginated

  @Override
  @GetMapping(ApiMappings.USERS)
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @ResponseBody
  public List<User> findAllPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size, @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                              @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
    return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
  }

  @Override
  @GetMapping(ApiMappings.USERS)
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE }, method = RequestMethod.GET)
  @ResponseBody
  public List<User> findAllPaginated(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size) {
    return findPaginatedInternal(page, size);
  }

  @Override
  @GetMapping(ApiMappings.USERS)
  @RequestMapping(params = { QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @ResponseBody
  public List<User> findAllSorted(@RequestParam(value = QueryConstants.SORT_BY) final String sortBy, @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
    return findAllSortedInternal(sortBy, sortOrder);
  }

  @Override
  @GetMapping(ApiMappings.USERS)
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<User> findAll(final HttpServletRequest request) {
    return findAllInternal(request);
  }

  // find - one

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @GetMapping(ApiMappings.USERS)
  @ResponseBody
  public User findOne(@PathVariable("id") final Long id) {
    return findOneInternal(id);
  }

  // create

  @RequestMapping(method = RequestMethod.POST)
  @PostMapping(ApiMappings.USERS)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody final User resource) {
    createInternal(resource);
  }

  // update

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  @Secured("CAN_UPDATE_USER")
  public void update(@PathVariable("id") final Long id, @RequestBody final User resource) {
    updateInternal(id, resource);
  }

  // delete

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Secured("CAN_DELETE_USER")
  public void delete(@PathVariable("id") final Long id) {
    deleteByIdInternal(id);
  }

  // Spring

  @Override
  protected final IUserService getService() {
    return service;
  }

}
