

package com.project.DisasterRecovery.Services;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;


@Service
public class UserServices {

    @Autowired
    UserRepo   UserRepo;



    // create user

    public ResponseEntity createUser(EndUser user){
        if(user.getEmail().isEmpty() && user.getPassword().isEmpty())
            return ResponseEntity.badRequest().build();
        UserRepo.save(user);
        return ResponseEntity.status(201).build();

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
}
