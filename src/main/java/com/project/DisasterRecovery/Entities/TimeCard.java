package com.project.DisasterRecovery.Entities;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class TimeCard  implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column
    @NonNull
    private String Site_Code;
    @Column
    @NonNull
    private String Contractor_Name;
    @Column
    @NonNull
    private Double Total_Hours;	
    @Column
    @NonNull
    private Double Total_Amount;										 

    @Column
    @NonNull
    private String Status ;		
    
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       
    @JoinTable(																																			
    		  name = "Timecard_Job", 
    		  joinColumns = @JoinColumn(name = "Timecard_Id"),
    		  inverseJoinColumns = @JoinColumn(name = "Job_Id"))
   Set<Job> TimecardJob;
    
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       
    @JoinTable(																																			
    		  name = "Timecard_Machine", 
    		  joinColumns = @JoinColumn(name = "Timecard_Id"),
    		  inverseJoinColumns = @JoinColumn(name = "Machine_Id"))
    Set<Machine> TimecardMachine;
    
}
