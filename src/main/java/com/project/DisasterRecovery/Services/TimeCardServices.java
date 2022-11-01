package com.project.DisasterRecovery.Services;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.repositories.JobRepo;
import com.project.DisasterRecovery.repositories.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.repositories.TimeCardRepo;

@Service
public class TimeCardServices {

	@Autowired 
	TimeCardRepo timecardRepo;
    @Autowired
    JobRepo  JobRepo;
    @Autowired
    MachineRepo MachineRepo;
    // list of timecards
    public ResponseEntity<List<TimeCard>> getListTimeCard() {
        List<TimeCard> timecards = timecardRepo.findAll();
        if(timecards.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(timecards);
    }
    
    // get one timecard
    public ResponseEntity<TimeCard> getOneTimeCard(int id) {
        if(timecardRepo.existsById(id)){
            return ResponseEntity.ok().body(timecardRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }
    
    // create timecard
    // it should take a list of job and a list machine 
    public ResponseEntity<TimeCard> createTimeCard(TimeCard timecard) throws DuplicateException{
        if(timecard.getCode().isEmpty())
            return ResponseEntity.badRequest().build();
        // get all the id of jobs and machines
        List<Integer> JobIds =  timecard.getTimecardJob().stream().map(job-> JobRepo.loadJobByJobCode(job.getCode()).getId()).collect(Collectors.toList());
        // [1, 2]
        //List<Integer> MachineCodes =  timecard.getTimecardMachine().stream().map(machine-> MachineRepo(machine.).getId()).collect(Collectors.toList());

        TimeCard TimeCard = timecardRepo.loadCardByCode(timecard.getCode());  // load timecard in database
        int id= 0 ;
        if(TimeCard == null ) {  // if this timecard not exits in database then add
            timecard.setTimecardJob(new HashSet<Job>()); // {timecard, jobs[]}
            id =  timecardRepo.save(timecard).getId();
            System.out.println(id);

        }
        TimeCard ExitsTimeCard =  timecardRepo.findById(id).orElseThrow(() -> new DuplicateException("Timecard  already exists :: " + timecard.getCode() ));

        final int finalId = id;
        JobIds.forEach(j -> timecardRepo.AddJob(finalId,j));
       // add with machince

        return ResponseEntity.ok(ExitsTimeCard);
    }
    
    // update timecard
    public ResponseEntity<TimeCard> updateTimeCard(int id, TimeCard timecard){
        if(getOneTimeCard(id).hasBody())
        {
        	TimeCard modifiedTimecard = getOneTimeCard(id).getBody();
        	modifiedTimecard.setCode(timecard.getCode());
        	modifiedTimecard.setContractor(timecard.getContractor());
        	modifiedTimecard.setHours(timecard.getHours());
        	modifiedTimecard.setAmount(timecard.getAmount()); 
        	modifiedTimecard.setStatus(timecard.getStatus());
        	modifiedTimecard.setTimecardJob(timecard.getTimecardJob());
        	modifiedTimecard.setTimecardMachine(timecard.getTimecardMachine());
        	return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // delete timecard
    public ResponseEntity<TimeCard> deleteTimeCard(int id)
    {
    	if(getOneTimeCard(id).hasBody())
    	{
    		timecardRepo.deleteById(id);
    		return ResponseEntity.accepted().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}
