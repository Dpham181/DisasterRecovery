package com.project.DisasterRecovery.controller;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.JwtResponse;
import com.project.DisasterRecovery.Services.RoleServices;
import com.project.DisasterRecovery.Services.UserServices;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.project.DisasterRecovery.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    RoleServices RoleService;

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

        
       
        return  authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

    }

    private ResponseEntity<?> authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        final UserDetails userDetails = UserServices
                .loadUserByUsername(username);
        if(userDetails == null) {
			ResponseEntity.notFound().build();
			ResponseEntity.ok(new JwtResponse("",""));
		}
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
        	ResponseEntity.notFound().build();
			return  ResponseEntity.ok(new JwtResponse("",""));
        } catch (BadCredentialsException e) {
        	return  ResponseEntity.ok(new JwtResponse("",""));
        }
        
       
        final String token = jwtTokenUtil.generateToken(userDetails);
        final String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        System.out.println(role);
        return ResponseEntity.ok(new JwtResponse(token,role));
    }
   
}


