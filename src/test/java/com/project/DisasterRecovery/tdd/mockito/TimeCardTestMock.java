package com.project.DisasterRecovery.tdd.mockito;
import com.project.DisasterRecovery.Entities.*;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.Services.TimeCardServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import com.project.DisasterRecovery.repositories.TimeCardRepo;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimeCardTestMock {

	@Mock 
	TimeCardRepo timecardRepo;
	
	@InjectMocks
	@Autowired
	TimeCardServices timecardServices;
	
	@Test
	public void getTimeCardList()
	{
		assertEquals(200, timecardServices.getListTimeCard().getStatusCodeValue());
	}
	
	@Test
	public void getOneTimeCardItem() throws NotFoundException
	{
		assertEquals(200, timecardServices.getOneTimeCard(1).getStatusCodeValue());
	}
	
	@Test
	public void createTimeCardItem() throws DuplicateException
	{
		Date d = new Date();
		TimeCard tc = new TimeCard("new timecard", "aa", 22.0, 1220.0, "Open", d);
		Set<Job> j = new HashSet<Job>();
		j.add(new Job("Plumber","Fix The Plumbing",65.0, 6.0));
		j.add(new Job("General Labor","General Work",30.0, 8.0));
		tc.setTimecardJob(j);
		Set<Machine> m = new HashSet<Machine>();
		m.add(new Machine("HT-100","han Truck with 1000LBS",12.0,8.0));
		m.add(new Machine("AirComp","Air Compressor",10.0, 4.0));
		tc.setTimecardMachine(m);
		assertEquals(200, timecardServices.createTimeCard(tc).getStatusCodeValue());
	}
	
	@Test
	public void updateTimeCardItem() throws NotFoundException
	{
		Date d = new Date();
		TimeCard tc = new TimeCard("update timecard", "update", 22.0, 1220.0, "Open", d);
		assertEquals(202, timecardServices.updateTimeCard(3, tc).getStatusCodeValue());
	}
	
	@Test
	public void deleteTimeCardItem() throws NotFoundException
	{
		assertEquals(202, timecardServices.deleteTimeCard(4).getStatusCodeValue());
	}
}
