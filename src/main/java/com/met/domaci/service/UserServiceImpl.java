package com.met.domaci.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.met.domaci.entities.Role;
import com.met.domaci.entities.User;
import com.met.domaci.repository.RoleRepository;
import com.met.domaci.repository.UserRepository;



@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("STUDENT");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

	}

	public void save(User student) {
		userRepository.save(student);
		
	}

}
