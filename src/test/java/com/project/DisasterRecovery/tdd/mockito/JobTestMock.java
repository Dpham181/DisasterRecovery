package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Services.JobServices;
import com.project.DisasterRecovery.repositories.JobRepo;

public class JobTestMock {

	@Mock 
	JobRepo jobRepo;
	
	@InjectMocks
	@Autowired
	JobServices jobServices;
	
	
}
