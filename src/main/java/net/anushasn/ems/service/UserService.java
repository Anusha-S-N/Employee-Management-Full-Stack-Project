package net.anushasn.ems.service;

import net.anushasn.ems.entity.User;

public interface UserService {
	 void saveUser(User user);
	    User findByUsername(String username);

}
