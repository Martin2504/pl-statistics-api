package edu.martin.plstatisticsapi.controller;

import edu.martin.plstatisticsapi.controller.interfaces.ISortingController;
import edu.martin.plstatisticsapi.model.Role;
import edu.martin.plstatisticsapi.service.IRoleService;
import edu.martin.plstatisticsapi.util.ApiMappings;
import edu.martin.plstatisticsapi.util.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = ApiMappings.API + "/" +ApiMappings.ROLES)
public class RoleController extends AbstractController<Role> implements ISortingController<Role> {

  @Autowired
  private IRoleService service;

  // API

  // find - all/paginated

  @Override
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @PostMapping(ApiMappings.ROLES)
  @ResponseBody
  public List<Role> findAllPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size, @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                              @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
    return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
  }

  @Override
  @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE }, method = RequestMethod.GET)
  @ResponseBody
  public List<Role> findAllPaginated(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size) {
    return findPaginatedInternal(page, size);
  }

  @Override
  @RequestMapping(params = { QueryConstants.SORT_BY }, method = RequestMethod.GET)
  @ResponseBody
  public List<Role> findAllSorted(@RequestParam(value = QueryConstants.SORT_BY) final String sortBy, @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
    return findAllSortedInternal(sortBy, sortOrder);
  }

  @Override
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Role> findAll(final HttpServletRequest request) {
    return findAllInternal(request);
  }

  // find - one

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Role findOne(@PathVariable("id") final Long id) {
    return findOneInternal(id);
  }

  // create

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody final Role resource) {
    createInternal(resource);
  }

  // update

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable("id") final Long id, @RequestBody final Role resource) {
    updateInternal(id, resource);
  }

  // delete

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") final Long id) {
    deleteByIdInternal(id);
  }

  // Spring

  @Override
  protected final IRoleService getService() {
    return service;
  }

}
