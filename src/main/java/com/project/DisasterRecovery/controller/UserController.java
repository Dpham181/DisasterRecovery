package com.project.DisasterRecovery.controller;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Services.UserServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/users", method = RequestMethod.OPTIONS)
public class UserController {

    @Autowired
    UserServices UserServices;


    @GetMapping("")
    public ResponseEntity<Optional> index(){
        return ResponseEntity.ok().build();
    }
    @PostMapping("/")
    public ResponseEntity<Optional> createUser(@RequestBody EndUser user){

        System.out.println(user);
        return UserServices.createUser(user);
    }
   
}


