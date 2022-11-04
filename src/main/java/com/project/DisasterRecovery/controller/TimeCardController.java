package com.project.DisasterRecovery.controller;


import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.Services.TimeCardServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Transactional
@RequestMapping(value="/TimeCards", method = RequestMethod.OPTIONS)
public class TimeCardController {

    @Autowired
    TimeCardServices TimeCardServices;

    @GetMapping("")
    public ResponseEntity<?> listOfTimeCard(){
        return TimeCardServices.getListTimeCard();
    }
   /// class timecardDto
    // timecard
    // list job
    // list machine
    // form    list of job list of machine in agular
    // {"amount":70, "code":"test","contractor":"danh", "hours":80, "Status:":"open", "timecardJob": [{"code":"Plumber", "description":"fix the blumbing", "hours": 6, "rate": 65}], "TimecardMachine":[] }
    @PostMapping("")
    public ResponseEntity<?> createTimeCard(@RequestBody TimeCard TimeCard ) throws DuplicateException {

        return TimeCardServices.createTimeCard(TimeCard);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> UpdateTimeCard(@PathVariable Integer id, @RequestBody TimeCard TimeCard) throws NotFoundException{
        return TimeCardServices.updateTimeCard(id,TimeCard);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<?> getOneTimeCard(@PathVariable int id) throws NotFoundException{
        System.out.println(id);
        return TimeCardServices.getOneTimeCard(id);
    }
}
