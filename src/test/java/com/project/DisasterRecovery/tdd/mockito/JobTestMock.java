package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import com.project.DisasterRecovery.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Services.JobServices;
import com.project.DisasterRecovery.repositories.JobRepo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class JobTestMock {

	@Mock 
	JobRepo jobRepo;
	
	@InjectMocks
	@Autowired
	JobServices jobServices;
	
	@Test
	public void getJobList()
	{
		assertEquals(200, jobServices.getListJob().getStatusCodeValue());
	}

	@Test
	public void  getOneJobItem() throws NotFoundException {
		assertEquals(200, jobServices.getOneJob(1).getStatusCodeValue());
	}
	/*
	@Test
	public void updateJobItem(int id, Job j) throws NotFoundException {
		jobServices.updateJob(id, j);
	}
	
	@Test
	public void deleteJobItem(int id) throws NotFoundException {
		jobServices.deleteJob(id);
	}
*/
}
