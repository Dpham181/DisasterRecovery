

package com.project.DisasterRecovery.Services;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.exception.DuplicateException;
import com.project.DisasterRecovery.exception.NotFoundException;
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

	public ResponseEntity<?> createUser(EndUser user) throws DuplicateException {

        if(user.getEmail().isEmpty() && user.getPassword().isEmpty())
            return ResponseEntity.badRequest().build();
        EndUser DBuser = UserRepo.loadUserByUsername(user.getEmail());
        int id = 0;
        if(DBuser == null ) {
            user.setPassword(encoder.encode(user.getPassword()));
            id =  UserRepo.save(user).getId();

        }
        EndUser User =  UserRepo.findById(id).orElseThrow(() -> new DuplicateException("Email already exists :: " ));
        return    ResponseEntity.ok(User);
    }

    // list of users

    public ResponseEntity<List<EndUser>> getListUsers() {
        List<EndUser> Users = UserRepo.findAll();
        if(Users.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(Users);
    }
   // get one user

    public ResponseEntity<EndUser> getOneUsers(int id) throws NotFoundException {
        if(UserRepo.existsById(id)){
            return ResponseEntity.ok().body(UserRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    	 
    }
    // get user by email
	public UserDetails loadUserByUsername(String email)  throws UsernameNotFoundException{

		EndUser DBuser = UserRepo.loadUserByUsername(email);

       if(DBuser == null) {
           throw new UsernameNotFoundException("User not found with email: " + email);
       }
        User user = new User(DBuser.getEmail(), DBuser.getPassword(), new ArrayList<>() );

       
        return user;
			
	}	
}
