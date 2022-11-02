package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.TimeCard;

@Repository
public interface TimeCardRepo extends JpaRepository<TimeCard, Integer>{
    @Query(value = "Select * from time_card T Where T.code =?1", nativeQuery = true)
    TimeCard loadCardByCode(String TimeCardCode);
    @Modifying
    @Query(value = "Insert into timecard_job values(?1,?2)", nativeQuery = true)
    void AddJob(int timecardid, int jobid);
    @Modifying
    @Query(value = "Insert into timecard_machine values(?1,?2)", nativeQuery = true)
    void AddMachine(int timecardid, int machineid);

	
}
