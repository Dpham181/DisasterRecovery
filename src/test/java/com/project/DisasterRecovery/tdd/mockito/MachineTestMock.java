package com.project.DisasterRecovery.tdd.mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.Services.MachineServices;
import com.project.DisasterRecovery.repositories.MachineRepo;

public class MachineTestMock {

	@Mock 
	MachineRepo machineRepo;
	
	@InjectMocks
	@Autowired
	MachineServices machineServices;
	
	@Test
	public List<Machine> getMachineList()
	{
		return machineServices.getListMachine().getBody();
	}
	
	@Test
	public Machine getOneMachineItem(int id)
	{
		return machineServices.getOneMachine(id).getBody();
	}
	
	@Test
	public void updateMachineItem(int id, Machine m)
	{
		machineServices.updateMachine(id, m);
	}
	
	@Test
	public void deleteMachineItem(int id)
	{
		machineServices.deleteMachine(id);
	}
}
