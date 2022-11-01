package com.project.DisasterRecovery.tdd.mockito;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.Role;
import com.project.DisasterRecovery.Services.RoleServices;
import com.project.DisasterRecovery.repositories.RoleRepo;

public class RoleTestMock {
	
	@Mock 
	RoleRepo roleRepo;
	
	@InjectMocks
	@Autowired
	RoleServices roleServices;
	
	@Test
	public void createRoleUser(Role r)
	{
		roleServices.createRole(r);
	}

}
