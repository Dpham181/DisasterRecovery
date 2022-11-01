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

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.Services.MachineServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import com.project.DisasterRecovery.repositories.MachineRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MachineTestMock {

	@Mock 
	MachineRepo machineRepo;
	
	@InjectMocks
	@Autowired
	MachineServices machineServices;
	
	@Test
	public void getMachineList()
	{
		assertEquals(200, machineServices.getListMachine().getStatusCodeValue());
	}
	
	@Test
	public void getOneMachineItem()
	{
		assertEquals(200, machineServices.getOneMachine(1).getStatusCodeValue());
	}
	
	@Test
	public void createMachine() throws NotFoundException, DuplicateException {
		Machine m = new Machine("new machine", "new machine", 1.1, 1.1);
		assertEquals(201, machineServices.createMachine(m).getStatusCodeValue());
	}
	
	@Test
	public void updateMachineItem()
	{
		Machine m = new Machine("aaa", "bbb", 1.1, 2.1);
		assertEquals(202, machineServices.updateMachine(2, m).getStatusCodeValue());
	}
	
	@Test
	public void deleteMachineItem()
	{
		assertEquals(202, machineServices.deleteMachine(4).getStatusCodeValue());
	}
	
}
