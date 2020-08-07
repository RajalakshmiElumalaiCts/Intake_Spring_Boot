package com.intake.repository;

import org.springframework.data.repository.CrudRepository;

import com.intake.model.db.UserProfile;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<UserProfile, Integer> {

	
}
