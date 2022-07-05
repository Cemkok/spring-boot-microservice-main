package com.Bit.MainService.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.Bit.MainService.model.User;
import com.Bit.MainService.security.UserPrincipal;
import com.Bit.MainService.security.jwt.IJwtProvider;

@Service
public class AuthenticationService implements IAuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IJwtProvider jwtProvider;
	
	
	@Override
	public String signInAndReturnJWT(User signInRequest) {
		
		Authentication authentication =authenticationManager.authenticate(
				new  UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
				);
		
		UserPrincipal userPrincipal =(UserPrincipal) authentication.getPrincipal();
		
		return jwtProvider.generateToken(userPrincipal);
	}

}
