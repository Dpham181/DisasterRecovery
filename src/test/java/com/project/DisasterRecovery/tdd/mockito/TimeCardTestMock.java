package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.Services.TimeCardServices;
import com.project.DisasterRecovery.repositories.TimeCardRepo;

public class TimeCardTestMock {

	@Mock 
	TimeCardRepo timecardRepo;
	
	@InjectMocks
	@Autowired
	TimeCardServices timecardServices;
	
	@Test
	public List<TimeCard> getTimeCardList()
	{
		return timecardServices.getListTimeCard().getBody();
	}
	
	@Test
	public TimeCard getOneTimeCardItem(int id)
	{
		return timecardServices.getOneTimeCard(id).getBody();
	}
	
	@Test
	public void updateTimeCardItem(int id, TimeCard tc)
	{
		timecardServices.updateTimeCard(id, tc);
	}
	
	@Test
	public void deleteTimeCardItem(int id)
	{
		timecardServices.deleteTimeCard(id);
	}
}
