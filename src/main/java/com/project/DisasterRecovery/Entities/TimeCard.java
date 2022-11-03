package com.project.DisasterRecovery.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(unique = true, length = 200)
    @NonNull
    private String Code;
    @Column
    @NonNull
    private String Contractor;
    @Column
    @NonNull
    private Double Hours;	
    @Column
    @NonNull
    private Double Amount;
    @Column
    @NonNull
    private String Status ;	
    @Column
    @NonNull
    private Date date ;	
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    @JsonIgnore
    private EndUser owner;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       
    @JoinTable(																																			
    		  name = "Timecard_Job", 
    		  joinColumns = @JoinColumn(name = "Timecard_Id"),
    		  inverseJoinColumns = @JoinColumn(name = "Job_Id"))
   Set<Job> TimecardJob ;
    
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       
    @JoinTable(																																			
    		  name = "Timecard_Machine", 
    		  joinColumns = @JoinColumn(name = "Timecard_Id"),
    		  inverseJoinColumns = @JoinColumn(name = "Machine_Id"))
    Set<Machine> TimecardMachine ;
    
}
