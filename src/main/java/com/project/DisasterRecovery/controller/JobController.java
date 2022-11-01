package com.project.DisasterRecovery.controller;


import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Services.JobServices;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Transactional
@RequestMapping(value="/jobs", method = RequestMethod.OPTIONS)
public class JobController {


      @Autowired
      JobServices JobServices;


      @GetMapping("")
      public ResponseEntity<?> listOfJobs(){
          return JobServices.getListJob();
      }

      @PostMapping("")
      public ResponseEntity<?> createJob(@RequestBody Job job) throws DuplicateException {
            return JobServices.createJob(job);
      }

      @PutMapping ("/{id}")
      public ResponseEntity<?> UpdateJob(@PathVariable Integer id, @RequestBody Job job) throws NotFoundException {
            return JobServices.updateJob(id,job);
      }


      @GetMapping ("/{id}")
      public ResponseEntity<?> getOneJob(@PathVariable int id) throws NotFoundException {
            return JobServices.getOneJob(id);
      }

}