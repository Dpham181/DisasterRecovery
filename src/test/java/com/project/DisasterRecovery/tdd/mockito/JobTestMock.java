package com.project.DisasterRecovery.tdd.mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Services.JobServices;
import com.project.DisasterRecovery.repositories.JobRepo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

	public void getOneJobItem() throws NotFoundException {

		assertEquals(200, jobServices.getOneJob(1).getStatusCodeValue());
	}
	
	@Test
	public void createJob() throws NotFoundException, DuplicateException {
		Job j = new Job("new job", "new job", 1.1, 1.1);
		assertEquals(200, jobServices.createJob(j).getStatusCodeValue());
	}
	
	@Test
	public void updateJobItem() throws NotFoundException {
		Job j = new Job("aaa", "bbb", 2.2, 1.1);
		assertEquals(202, jobServices.updateJob(3, j).getStatusCodeValue());
	}

	
	@Test
	public void deleteJobItem() throws NotFoundException {
		assertEquals(202, jobServices.deleteJob(4).getStatusCodeValue());
	}
	
}
