package com.project.DisasterRecovery.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity

public class EndUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
	@Column(unique = true, length = 200)
    @NonNull
    private String email;
    @Column
    @NonNull
    private String password;											 
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       
    @JoinTable(																																			
    		  name = "user_roles", 
    		  joinColumns = @JoinColumn(name = "User_Id"), 
    		  inverseJoinColumns = @JoinColumn(name = "Role_Id"))
    Set<Role> UserRole = new HashSet<>();
}

