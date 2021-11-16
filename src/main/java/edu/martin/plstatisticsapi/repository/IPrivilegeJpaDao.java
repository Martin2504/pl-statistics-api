package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.interfaces.IByNameApi;
import edu.martin.plstatisticsapi.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPrivilegeJpaDao extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege>, IByNameApi<Privilege> {
  //
}
