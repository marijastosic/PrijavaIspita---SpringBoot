package com.met.domaci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.met.domaci.entities.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
