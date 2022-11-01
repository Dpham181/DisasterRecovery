package com.project.DisasterRecovery.controller;


import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.Services.TimeCardServices;
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
    @PostMapping("")
    public ResponseEntity<?> createTimeCard(@RequestBody TimeCard TimeCard){
    	System.out.println(TimeCard.getTimecardJob());
        return TimeCardServices.createTimeCard(TimeCard);
    }
    // timecard id 
    // job timecard 
    // machine timecard 
    @PutMapping ("/{id}")
    public ResponseEntity<?> UpdateTimeCard(@PathVariable Integer id, @RequestBody TimeCard TimeCard){
        return TimeCardServices.updateTimeCard(id,TimeCard);
    }


    @GetMapping ("/{id}")
    public ResponseEntity<?> getOneTimeCard(@PathVariable int id){
        System.out.println(id);
        return TimeCardServices.getOneTimeCard(id);
    }
}
