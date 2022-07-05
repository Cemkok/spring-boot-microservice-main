package com.Bit.MainService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bit.MainService.model.User;
import com.Bit.MainService.service.authentication.IAuthenticationService;
import com.Bit.MainService.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
	
	private IAuthenticationService authenticationService;
	
	private IUserService userService;
	
	@Autowired
	public AuthenticationController(IAuthenticationService authenticationService, IUserService userService) {
		super();
		this.authenticationService = authenticationService;
		this.userService = userService;
	}
		
	@PostMapping("sign-up")
	public ResponseEntity<?> signUp(@RequestBody User user){
		log.info("sign-up called ");
		this.internalLogDetail();
		if (userService.findByUsername(user.getUsername()).isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
			
	}
	
	@PostMapping ("sign-in")
		public ResponseEntity<?>  signIn(@RequestBody User user){
		log.info("sign-in called ");
		this.internalLogDetail();
		return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
		
	}
	
	private String internalLogDetail() {
		  try {
			  log.debug("internalLogDetail methodu basladi");
			  Thread.sleep(1000);
			  return "Api Mesaj";
		  } 
		  catch (InterruptedException e ) {
			  log.error("Hata : {}", e);
		  }
		  return "";
	  }
	
	

}
