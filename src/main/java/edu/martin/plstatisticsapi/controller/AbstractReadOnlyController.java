package edu.martin.plstatisticsapi.controller;

import com.google.common.collect.Lists;
import edu.martin.plstatisticsapi.exceptions.MyEntityNotFoundException;
import edu.martin.plstatisticsapi.interfaces.IWithName;
import edu.martin.plstatisticsapi.service.IRawService;
import edu.martin.plstatisticsapi.util.RestPreconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class AbstractReadOnlyController<T extends IWithName> {
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  // find - one

  protected final T findOneInternal(final Long id) {
    return RestPreconditions.checkNotNull(getService().findOne(id));
  }

  // find - all

  protected final List<T> findAllInternal(final HttpServletRequest request) {
    if (request.getParameterNames()
        .hasMoreElements()) {
      throw new MyEntityNotFoundException();
    }

    return getService().findAll();
  }

  protected final List<T> findPaginatedAndSortedInternal(final int page, final int size, final String sortBy, final String sortOrder) {
    final Page<T> resultPage = getService().findAllPaginatedAndSortedRaw(page, size, sortBy, sortOrder);
    if (page > resultPage.getTotalPages()) {
      throw new MyEntityNotFoundException();
    }

    return Lists.newArrayList(resultPage.getContent());
  }

  protected final List<T> findPaginatedInternal(final int page, final int size) {
    final Page<T> resultPage = getService().findAllPaginatedRaw(page, size);
    if (page > resultPage.getTotalPages()) {
      throw new MyEntityNotFoundException();
    }

    return Lists.newArrayList(resultPage.getContent());
  }

  protected final List<T> findAllSortedInternal(final String sortBy, final String sortOrder) {
    final List<T> resultPage = getService().findAllSorted(sortBy, sortOrder);
    return resultPage;
  }

  // count

  protected final long countInternal() {
    // InvalidDataAccessApiUsageException dataEx - ResourceNotFoundException
    return getService().count();
  }

  // generic REST operations

  // count

  /**
   *
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/count")
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  public long count() {
    return countInternal();
  }

  // template method

  protected abstract IRawService<T> getService();

}