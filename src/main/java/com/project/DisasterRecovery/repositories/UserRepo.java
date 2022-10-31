package com.project.DisasterRecovery.repositories;

import com.project.DisasterRecovery.Entities.EndUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<EndUser, Integer>{

	 @Query(value = "Select * from end_user U Where U.email =?1", nativeQuery = true)
	 EndUser loadUserByUsername(String email);
}
