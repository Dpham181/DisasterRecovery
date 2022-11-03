package com.project.DisasterRecovery.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Job implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(unique = true, length = 200)
    @NonNull
    private String Code;
    @Column
    @NonNull
    private String Description;
    @Column
    @NonNull
    private Double Rate;	
    @Column
    @NonNull
    private Double Hours;										 

    @ManyToMany(mappedBy = "TimecardJob", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JsonIgnore
	Set<TimeCard> timecards;
}
