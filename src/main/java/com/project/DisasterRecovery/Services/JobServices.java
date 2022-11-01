package com.project.DisasterRecovery.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.repositories.JobRepo;

@Service 
public class JobServices {

	@Autowired 
	JobRepo jobRepo;
	
	// list of job
    public ResponseEntity<List<Job>> getListJob() {
        List<Job> jobs = jobRepo.findAll();
        if(jobs.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(jobs);
    }
    
    // get one job
    public ResponseEntity<Job> getOneJob(int id) {
        if(jobRepo.existsById(id)){
            return ResponseEntity.ok().body(jobRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }
    
    // create job
    public ResponseEntity<Job> createJob(Job job){
        Job checkJob = jobRepo.loadJobByCode(job.getCode());
        if(checkJob == null)
        {
        	jobRepo.save(job);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(409).build();
    }
    
    // update job
    public ResponseEntity<Job> updateJob(int id, Job job){
        if(getOneJob(id).hasBody())
        {
        	Job modifiedJob = getOneJob(id).getBody();
        	modifiedJob.setDescription(job.getDescription());
        	modifiedJob.setCode(job.getCode());
        	modifiedJob.setRate(job.getRate());
        	modifiedJob.setHours(job.getHours());   
        	return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // delete job
    public ResponseEntity<Job> deleteJob(int id)
    {
    	if(getOneJob(id).hasBody())
    	{
    		jobRepo.deleteById(id);
    		return ResponseEntity.accepted().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
