package com.template.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.model.User;
import com.template.repository.UserRepository;
import com.template.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.getAllUsers();
//		return new ArrayList<>();
	}

	@Override
	public User getUserByHash(String userHash) {
		// TODO Auto-generated method stub
		return userRepository.getUserByHash(userHash);
	}

	@Override
	public boolean deleteUser(String userHash) {
		// TODO Auto-generated method stub
		return userRepository.deleteUser(userHash);
	}

	@Override
	public boolean saveUser(User user) {
		user.setUserHash(UUID.randomUUID().toString());
		return userRepository.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public int countUsersByGender(String gender) {
		// TODO Auto-generated method stub
		return userRepository.countUsersByGender(gender);
	}	
}
