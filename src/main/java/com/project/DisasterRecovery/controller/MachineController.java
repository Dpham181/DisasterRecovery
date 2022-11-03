package com.project.DisasterRecovery.controller;


import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.Services.MachineServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Transactional
@RequestMapping(value="/machines", method = RequestMethod.OPTIONS)
public class MachineController {

    @Autowired
    MachineServices MachineServices;


    @GetMapping("")
    public ResponseEntity<?> listOfJobs(){
        return MachineServices.getListMachine();
    }

    @PostMapping("")
    public ResponseEntity<?> createJob(@RequestBody Machine Machine) throws DuplicateException{
        return MachineServices.createMachine(Machine);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> UpdateJob(@PathVariable Integer id, @RequestBody Machine Machine) throws NotFoundException{
        return MachineServices.updateMachine(id,Machine);
    }


    @GetMapping ("/{id}")
    public ResponseEntity<?> getOneJob(@PathVariable int id) throws NotFoundException{
        return MachineServices.getOneMachine(id);
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable int id) throws NotFoundException{
        return MachineServices.deleteMachine(id);
    }

}
