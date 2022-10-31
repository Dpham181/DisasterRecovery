package com.project.DisasterRecovery.repositories;

import com.project.DisasterRecovery.Entities.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<EndUser, Integer>{


}
