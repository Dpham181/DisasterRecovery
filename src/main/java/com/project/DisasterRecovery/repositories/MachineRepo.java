package com.project.DisasterRecovery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.DisasterRecovery.Entities.Machine;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer>{

}
