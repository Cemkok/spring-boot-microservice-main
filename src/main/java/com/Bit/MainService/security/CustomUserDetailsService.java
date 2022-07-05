package com.Bit.MainService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Bit.MainService.model.User;
import com.Bit.MainService.service.user.IUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   User user=userService.findByUsername(username).orElseThrow(()-> 
	   		new UsernameNotFoundException("User not found with username:"+username));	
			   return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword());
	}
	
	

}
