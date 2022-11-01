package com.project.DisasterRecovery.repositories;

import com.project.DisasterRecovery.Entities.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Job;

import java.util.Optional;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{
    @Query(value = "Select * from job J Where J.code =?1", nativeQuery = true)
    Job loadJobByJobCode(String JobCode);

}
