package com.project.DisasterRecovery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.Role;
import com.project.DisasterRecovery.repositories.RoleRepo;

@Service
public class RoleServices {

	@Autowired
	RoleRepo roleRepo;
	
	// create role
    public ResponseEntity<?> createRole(Role role){
        if(role.getRole() == null)
            return ResponseEntity.badRequest().build();
        roleRepo.save(role);
        return ResponseEntity.status(201).build();
    }
	
}
