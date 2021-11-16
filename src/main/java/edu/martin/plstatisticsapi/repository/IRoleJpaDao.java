package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.interfaces.IByNameApi;
import edu.martin.plstatisticsapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoleJpaDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, IByNameApi<Role> {
  //
}
