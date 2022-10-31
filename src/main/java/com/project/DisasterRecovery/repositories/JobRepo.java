package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{

}
