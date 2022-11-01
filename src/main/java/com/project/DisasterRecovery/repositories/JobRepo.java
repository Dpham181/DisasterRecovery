package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{

	 @Query(value = "Select * from job j Where j.code =?1", nativeQuery = true)
	 Job loadJobByCode(String code);
}
