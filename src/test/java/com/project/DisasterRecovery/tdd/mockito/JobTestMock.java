package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import com.project.DisasterRecovery.exception.NotFoundException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Services.JobServices;
import com.project.DisasterRecovery.repositories.JobRepo;

public class JobTestMock {

	@Mock 
	JobRepo jobRepo;
	
	@InjectMocks
	@Autowired
	JobServices jobServices;
	
	@Test
	public List<Job> getJobList()
	{
		return jobServices.getListJob().getBody();
	}
	
	@Test
	public Job getOneJobItem(int id) throws NotFoundException {
		return jobServices.getOneJob(id).getBody();
	}
	
	@Test
	public void updateJobItem(int id, Job j) throws NotFoundException {
		jobServices.updateJob(id, j);
	}
	
	@Test
	public void deleteJobItem(int id) throws NotFoundException {
		jobServices.deleteJob(id);
	}

}
