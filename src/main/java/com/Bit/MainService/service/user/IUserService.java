package com.Bit.MainService.service.user;

import java.util.List;
import java.util.Optional;

import com.Bit.MainService.model.User;

public interface IUserService {

	User saveUser(User user);

	Optional<User> findByUsername(String username);

	List<User> findAllUsers();

}
