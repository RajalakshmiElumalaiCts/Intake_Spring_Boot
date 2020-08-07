package com.intake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intake.model.db.UserProfile;
import com.intake.repository.UserRepository;
import com.intake.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserProfile getUser(int userId) {
		return userRepository.findById(userId).get();
	}

}
