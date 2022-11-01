package com.project.DisasterRecovery.Services;

import java.util.List;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<Job> getOneJob(int id)  throws NotFoundException {
        Job job = jobRepo.findById(id).orElseThrow(()-> new NotFoundException("Job not found "+ id));
       return ResponseEntity.ok(job);
    }
    
    // create job
    public ResponseEntity<Job> createJob(Job job) throws DuplicateException {

        Job JOB = jobRepo.loadJobByJobCode(job.getCode());
        int id = 0;
        if(JOB == null ) {
            id =  jobRepo.save(job).getId();

        }
        Job ExitsJob =  jobRepo.findById(id).orElseThrow(() -> new DuplicateException("Job already exists :: " + job.getCode() ));

        return ResponseEntity.ok(ExitsJob);
    }
    
    // update job
    public ResponseEntity<Job> updateJob(int id, Job job) throws NotFoundException {
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
    public ResponseEntity<Job> deleteJob(int id) throws NotFoundException {
    	if(getOneJob(id).hasBody())
    	{
    		jobRepo.deleteById(id);
    		return ResponseEntity.accepted().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
