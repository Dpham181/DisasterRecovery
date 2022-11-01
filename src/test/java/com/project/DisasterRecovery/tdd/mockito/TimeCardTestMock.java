package com.project.DisasterRecovery.tdd.mockito;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.Services.TimeCardServices;
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
	public void getOneTimeCardItem()
	{
		assertEquals(200, timecardServices.getOneTimeCard(1).getStatusCodeValue());
	}
	
	@Test
	public void createTimeCardItem()
	{
		TimeCard tc = new TimeCard("new timecard", "aa", 22.0, 1220.0, "Open");
		System.out.println(timecardServices.createTimeCard(tc).getStatusCodeValue());
		assertEquals(201, timecardServices.createTimeCard(tc).getStatusCodeValue());
	}
	
	@Test
	public void updateTimeCardItem()
	{
		TimeCard tc = new TimeCard("update timecard", "update", 22.0, 1220.0, "Open");
		assertEquals(202, timecardServices.updateTimeCard(2, tc).getStatusCodeValue());
	}
	
	@Test
	public void deleteTimeCardItem()
	{
		assertEquals(202, timecardServices.deleteTimeCard(4).getStatusCodeValue());
	}
	
}
