package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.interfaces.IByNameApi;
import edu.martin.plstatisticsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByNameApi<User> {
  //
}
