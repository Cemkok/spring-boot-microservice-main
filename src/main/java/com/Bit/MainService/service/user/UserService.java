package com.Bit.MainService.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Bit.MainService.model.User;
import com.Bit.MainService.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreateTime(LocalDateTime.now());
		return userRepository.save(user);	
	}
	
	
	@Override
	public Optional<User> findByUsername(String username){
		return userRepository.findByUsername(username);
	}


	@Override
	public List<User> findAllUsers() {
	
		return userRepository.findAll();
	}
	
	
	
	

}
