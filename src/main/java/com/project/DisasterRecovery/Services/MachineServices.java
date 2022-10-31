package com.project.DisasterRecovery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.Machine;
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
    public ResponseEntity<Machine> getOneMachine(int id) {
        if(machineRepo.existsById(id)){
            return ResponseEntity.ok().body(machineRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }
    
    // create machine
    public ResponseEntity<Machine> createMachine(Machine machine){
        if(machine.getMachine_Code().isEmpty())
            return ResponseEntity.badRequest().build();
        machineRepo.save(machine);
        return ResponseEntity.status(201).build();
    }
    
    // update machine
    public ResponseEntity<Machine> updateMachine(int id, Machine machine){
        if(getOneMachine(id).hasBody())
        {
        	Machine modifiedMachine = getOneMachine(id).getBody();
        	modifiedMachine.setDescription(machine.getDescription());
        	modifiedMachine.setMachine_Code(machine.getMachine_Code());
        	modifiedMachine.setHourly_Rent(machine.getHourly_Rent());
        	modifiedMachine.setMax_Hours_Per_Day(machine.getMax_Hours_Per_Day());   
        	return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // delete machine
    public ResponseEntity<Machine> deleteMachine(int id)
    {
    	if(getOneMachine(id).hasBody())
    	{
    		machineRepo.deleteById(id);
    		return ResponseEntity.accepted().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
