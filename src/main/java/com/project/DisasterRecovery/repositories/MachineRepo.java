package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Machine;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer>{

	 @Query(value = "Select * from machine m Where m.code =?1", nativeQuery = true)
	 Machine loadMachineByCode(String code);
}
