

package com.project.DisasterRecovery.Services;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepo   UserRepo;

    @Autowired
    PasswordEncoder encoder;

    // create user

	@SuppressWarnings("rawtypes")
	public ResponseEntity<Optional> createUser(EndUser user) {
		System.out.println(user.getUserRole());

        if(user.getEmail().isEmpty() && user.getPassword().isEmpty())
            return ResponseEntity.badRequest().build();
        EndUser DBuser = UserRepo.loadUserByUsername(user.getEmail());
        if(DBuser == null) {
            user.setPassword(encoder.encode(user.getPassword()));

            UserRepo.save(user);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(409).build();

    }

    // list of users

    public ResponseEntity<List<EndUser>> getListUsers() {
        List<EndUser> Users = UserRepo.findAll();
        if(Users.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(Users);
    }
   // get one user

    public ResponseEntity<EndUser> geOneUsers(int id) {
        if(UserRepo.existsById(id)){
            return ResponseEntity.ok().body(UserRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }
    // get user by email
	public UserDetails loadUserByUsername(String email)  throws UsernameNotFoundException{

		EndUser DBuser = UserRepo.loadUserByUsername(email);


        User user = new User(DBuser.getEmail(), DBuser.getPassword(), new ArrayList<>() );

        if(user.getPassword().isEmpty()){

            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return user;
			
	}	
}
