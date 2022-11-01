package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Services.UserServices;
import com.project.DisasterRecovery.repositories.UserRepo;

public class EndUserTestMock {

	@Mock 
	UserRepo userRepo;
	
	@InjectMocks
	@Autowired
	UserServices userServices;
	
	@Test
	public void createUser(EndUser user)
	{
		userServices.createUser(user);
	}
	
	@Test
	public List<EndUser> getUserList()
	{
		return userServices.getListUsers().getBody();
	}
	
	@Test
	public EndUser getOneUser(int id)
	{
		return userServices.geOneUsers(id).getBody();
	}
}
