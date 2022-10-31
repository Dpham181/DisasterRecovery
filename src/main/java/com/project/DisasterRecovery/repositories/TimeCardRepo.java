package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.TimeCard;

@Repository
public interface TimeCardRepo extends JpaRepository<TimeCard, Integer>{

}
