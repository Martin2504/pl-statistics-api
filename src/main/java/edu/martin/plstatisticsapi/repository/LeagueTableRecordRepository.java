package edu.martin.plstatisticsapi.repository;

import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueTableRecordRepository extends JpaRepository<LeagueTableRecord, Long> {
}