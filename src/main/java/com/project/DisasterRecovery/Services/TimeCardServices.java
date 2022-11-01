package com.project.DisasterRecovery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DisasterRecovery.Entities.TimeCard;
import com.project.DisasterRecovery.repositories.TimeCardRepo;

@Service
public class TimeCardServices {

	@Autowired 
	TimeCardRepo timecardRepo;
	
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
    public ResponseEntity<TimeCard> createTimeCard(TimeCard timecard){
        if(timecard.getCode().isEmpty())
            return ResponseEntity.badRequest().build();
        System.out.println(timecard.getTimecardJob());
        timecardRepo.save(timecard);
        return ResponseEntity.status(201).build();
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
