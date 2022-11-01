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
    public ResponseEntity<?> listOfJobs(){
        return TimeCardServices.getListTimeCard();
    }

    @PostMapping("")
    public ResponseEntity<?> createJob(@RequestBody TimeCard TimeCard){
        return TimeCardServices.createTimeCard(TimeCard);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> UpdateJob(@PathVariable Integer id, @RequestBody TimeCard TimeCard){
        return TimeCardServices.updateTimeCard(id,TimeCard);
    }


    @GetMapping ("/{id}")
    public ResponseEntity<?> getOneJob(@PathVariable int id){
        System.out.println(id);
        return TimeCardServices.getOneTimeCard(id);
    }
}
