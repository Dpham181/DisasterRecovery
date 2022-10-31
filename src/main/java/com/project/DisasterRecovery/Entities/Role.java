package com.project.DisasterRecovery.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Enumerated(EnumType.STRING) 
    private RoleBase role;
	
	@ManyToMany(mappedBy = "UserRole", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	Set<EndUser> users;
	
}