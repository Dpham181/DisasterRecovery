package com.project.DisasterRecovery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import com.project.DisasterRecovery.repositories.MachineRepo;

@Service
public class MachineServices {

	@Autowired 
	MachineRepo machineRepo;
	
	// list of machine
    public ResponseEntity<List<Machine>> getListMachine() {
        List<Machine> machines = machineRepo.findAll();
        if(machines.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(machines);
    }
    
    // get one machine
    public ResponseEntity<Machine> getOneMachine(int id) throws NotFoundException {
        Machine m = machineRepo.findById(id).orElseThrow(() -> new NotFoundException("Machine not found " + id));
    	return ResponseEntity.ok(m);
    }
    
    // create machine
    public ResponseEntity<Machine> createMachine(Machine machine) throws DuplicateException{
      
    	Machine checkMachine = machineRepo.loadMachineByCode(machine.getCode());
    	int id = 0;
    	if(checkMachine == null)
    		id = machineRepo.save(machine).getId();
    	Machine existMachine = machineRepo.findById(id).orElseThrow(() -> new DuplicateException("Machine already exists: " + machine.getCode()));
        return ResponseEntity.ok(existMachine);
    }
    
    // update machine
    public ResponseEntity<Machine> updateMachine(int id, Machine machine) throws NotFoundException{
        if(getOneMachine(id).hasBody())
        {
        	Machine modifiedMachine = getOneMachine(id).getBody();
        	modifiedMachine.setDescription(machine.getDescription());
        	modifiedMachine.setCode(machine.getCode());
        	modifiedMachine.setRent(machine.getRent());
        	modifiedMachine.setHours(machine.getHours());   
        	machineRepo.save(modifiedMachine);
        	return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // delete machine
    public ResponseEntity<Machine> deleteMachine(int id) throws NotFoundException
    {
    	if(getOneMachine(id).hasBody())
    	{
    		machineRepo.deleteById(id);
    		return ResponseEntity.accepted().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
