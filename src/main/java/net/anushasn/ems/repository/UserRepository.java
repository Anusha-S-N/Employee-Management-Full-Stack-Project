package net.anushasn.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.anushasn.ems.entity.User;

public interface UserRepository extends JpaRepository <User,Long> {
	 User findByUsername(String username);

}
