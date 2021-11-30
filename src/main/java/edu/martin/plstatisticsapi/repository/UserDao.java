package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	
}