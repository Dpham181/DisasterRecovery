package com.project.DisasterRecovery.controller;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.JwtResponse;
import com.project.DisasterRecovery.Services.UserServices;

import java.util.Objects;
import java.util.Optional;

import com.project.DisasterRecovery.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Transactional
@RequestMapping(value="/users", method = RequestMethod.OPTIONS)
public class UserController {

    @Autowired
    UserServices UserServices;

    @Autowired
    private com.project.DisasterRecovery.Config.JwtTokenUtil jwtTokenUtil;


    @Autowired
    private AuthenticationManager authenticationManager;

    
   
	@GetMapping("")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok().build();
    }
	@PostMapping("/")
    public ResponseEntity<?> createUser(@Validated @RequestBody EndUser user) throws DuplicateException {

        return UserServices.createUser(user);
    }
    
	@PostMapping("/login")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody EndUser authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        
        final UserDetails userDetails = UserServices
                .loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
   
}


