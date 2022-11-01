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

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Services.UserServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import com.project.DisasterRecovery.repositories.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndUserTestMock {

	@Mock 
	UserRepo userRepo;
	
	@InjectMocks
	@Autowired
	UserServices userServices;
	
	@Test
	public void createUser() throws DuplicateException
	{
		EndUser u = new EndUser("user3@gmail.com", "123456");
		assertEquals(201, userServices.createUser(u).getStatusCodeValue());
	}
	
	@Test
	public void getUserList()
	{
		assertEquals(200, userServices.getListUsers().getStatusCodeValue());
	}
	
	@Test
	public void getOneUser() throws NotFoundException
	{
		System.out.println(userServices.getOneUsers(1).getStatusCodeValue());
		assertEquals(200, userServices.getOneUsers(1).getStatusCodeValue());
	}
	
}
