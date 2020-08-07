package com.intake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intake.jwt.JwtUtil;
import com.intake.jwt.JwtUserDetailsService;
import com.intake.model.jwt.JwtRequest;
import com.intake.model.jwt.JwtResponse;

@RestController
//Spring security will allow the URL with '/authenticate' combined with the contect path('/intake').
//But adding additional variable like 'auth_api' to the URI as below, will not be allowed by spring security
//@RequestMapping(value = "/auth_api")
public class AuthenticationController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest request) throws Exception{
		
		authenticate(request.getUsername(), request.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		String jwttoken = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(jwttoken));
		
	}

	private void authenticate(String username, String password) throws Exception {
		/*
		 * Objects.requireNonNull(username); Objects.requireNonNull(password);
		 */
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(BadCredentialsException ex) {
			System.out.println("Invalid username or password..");			
			throw new Exception("INVALID_CREDENTIALS", ex);
		}
		
		
	}
}
