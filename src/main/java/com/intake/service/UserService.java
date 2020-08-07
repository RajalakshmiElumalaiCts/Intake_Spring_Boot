package com.intake.service;

import org.springframework.stereotype.Service;

import com.intake.model.db.UserProfile;


public interface UserService {

	UserProfile getUser(int id);
}
