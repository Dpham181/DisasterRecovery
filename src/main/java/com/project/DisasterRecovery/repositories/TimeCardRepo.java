package com.project.DisasterRecovery.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Entities.TimeCard;

@Repository
public interface TimeCardRepo extends JpaRepository<TimeCard, Integer>{

	 @Query(value = "Select * from timecard tc Where tc.code =?1", nativeQuery = true)
	 TimeCard loadTimeCardByCode(String code);
}
