package net.anushasn.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import net.anushasn.ems.entity.User;
import net.anushasn.ems.repository.UserRepository;
import net.anushasn.ems.service.UserService;

public class UserServiceImpl  implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
