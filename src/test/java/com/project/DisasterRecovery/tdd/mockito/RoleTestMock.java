package com.project.DisasterRecovery.tdd.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.DisasterRecovery.Entities.Role;
import com.project.DisasterRecovery.Services.RoleServices;
import com.project.DisasterRecovery.repositories.RoleRepo;
import com.project.DisasterRecovery.Entities.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleTestMock {
	
	@Mock 
	RoleRepo roleRepo;
	
	@InjectMocks
	@Autowired
	RoleServices roleServices;
	

}
